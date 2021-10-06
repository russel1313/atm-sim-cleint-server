package com.russel.atm.simulator.iso.transformer;

import com.russel.atm.simulator.common.*;
import com.russel.atm.simulator.iso.ISOField;
import com.russel.atm.simulator.iso.converter.CoreToClientStatusConverter;
import com.russel.atm.simulator.util.StringUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jpos.iso.ISOMsg;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public abstract class BaseResponseTransformer <T> implements ServiceAttributeAware {

    protected abstract BaseResponseService createResponseService();

    private static final Log logger = LogFactory.getLog(BaseResponseTransformer.class);

    public Object transform(ISOMsg message) {
        BaseResponseService response = createResponseService();
        response.setRequestUUID(resolveRquid(message));
        response.setProcessCode(message.getString(ISOField.PROCESSING_CODE.getPosition()));
        response.setStatus(new StatusWrapper(CoreToClientStatusConverter.getInstance().convert(resolveActionCode(message))));
        response.setCardNo(message.getString(ISOField.PAN.getPosition()));
        return response;
    }

    private String resolveActionCode(ISOMsg message) {
        return message.getString(ISOField.ACTION_CODE.getPosition());
    }

    private String resolveRquid(ISOMsg message) {
        return message.getString(ISOField.SYSTEM_TRACE_AUDIT_NUMBER.getPosition());
    }

    public ServiceAttribute getServiceAttribute() {
        throw new UnsupportedOperationException();
    }

    protected Balance createBalance(String balanceValue) {
        if(StringUtil.isEmpty(balanceValue)) {
            return null;
        }
        Balance balance = new Balance();
        // Balance is merged in filed 52
        // The block of first 8 characters is zeropad depositable balance
        // The block of second 8 characters is zeropad ledger balance
        String availableBalance = balanceValue.length() >= 8 ? balanceValue.substring(0, 8) : null;
        String ledgerBalance = balanceValue.length() >= 16 ? balanceValue.substring(8, 16) : null;
        try {
            balance.setDepositableAmount(Long.valueOf(StringUtil.unpadZero(availableBalance)));
        }
        catch(Exception ex) {
            balance.setDepositableAmount(Long.valueOf(0));
        }
        try {
            balance.setLedgerBalance(Long.valueOf(StringUtil.unpadZero(ledgerBalance)));
        }
        catch(Exception ex) {
            balance.setLedgerBalance(Long.valueOf(0));
        }
        return balance;
    }
}