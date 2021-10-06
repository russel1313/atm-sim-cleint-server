package com.russel.atm.simulator.iso.transformer;

import com.russel.atm.simulator.exception.TransformerException;
import com.russel.atm.simulator.iso.ISOField;
import com.russel.atm.simulator.iso.ProcessCode;
import com.russel.atm.simulator.iso.transformer.balance.BalanceInqRsTransformer;
import com.russel.atm.simulator.iso.transformer.cashin.CashInAddRsTransformer;
import com.russel.atm.simulator.iso.transformer.cashout.CashOutAddRsTransformer;
import org.jpos.iso.ISOMsg;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class DynamicCoreToClientTransformer {
    private static DynamicCoreToClientTransformer instance;

    private DynamicCoreToClientTransformer() {
    }

    public static DynamicCoreToClientTransformer getInstance() {
        if (instance == null) {
            instance = new DynamicCoreToClientTransformer();
        }
        return instance;
    }

    public Object doTransform(Object src) throws TransformerException {
        ISOMsg message = (ISOMsg)src;

        BaseResponseTransformer responseTransformer;
        if(ProcessCode.BALANCE.getCode().equals(message.getString(ISOField.PROCESSING_CODE.getPosition()))) {
            responseTransformer = new BalanceInqRsTransformer();
        }
        else if(ProcessCode.CASHIN.getCode().equals(message.getString(ISOField.PROCESSING_CODE.getPosition()))) {
            responseTransformer = new CashInAddRsTransformer();
        }
        else if(ProcessCode.CASHOUT.getCode().equals(message.getString(ISOField.PROCESSING_CODE.getPosition()))) {
            responseTransformer = new CashOutAddRsTransformer();
        }
        else {
            throw new TransformerException("No transformer found for " +
                    message.getString(ISOField.PROCESSING_CODE.getPosition()));
        }
        Object transformed = responseTransformer.transform(message);
        return transformed;
    }
}