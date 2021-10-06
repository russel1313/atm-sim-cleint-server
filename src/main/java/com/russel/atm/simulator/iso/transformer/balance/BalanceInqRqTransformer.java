package com.russel.atm.simulator.iso.transformer.balance;

import com.russel.atm.simulator.common.BalanceInquiryRequest;
import com.russel.atm.simulator.common.BaseRequestService;
import com.russel.atm.simulator.common.ServiceAttribute;
import com.russel.atm.simulator.exception.TransformerException;
import com.russel.atm.simulator.iso.MTI;
import com.russel.atm.simulator.iso.ProcessCode;
import com.russel.atm.simulator.iso.packager.AsciiXAPackager;
import com.russel.atm.simulator.iso.transformer.BaseRequestTransformer;
import com.russel.atm.simulator.util.DateUtil;
import com.russel.atm.simulator.util.StringUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import java.util.Date;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class BalanceInqRqTransformer extends BaseRequestTransformer<BalanceInquiryRequest> {
    @Override
    protected ISOMsg transform(BaseRequestService o) {
        BalanceInquiryRequest request = (BalanceInquiryRequest)o;
        try {
            ISOMsg msg = new ISOMsg();
            msg.setPackager(new AsciiXAPackager());
            msg.set(BalanceInqRq.MTI.getPosition(), MTI.TRANSFER_REQUEST_COMMAND.getCode());
            msg.set(BalanceInqRq.PAN.getPosition(), request.getSourceCardNo());
            msg.set(BalanceInqRq.PROCESSING_CODE.getPosition(), createProcessCode());
            msg.set(BalanceInqRq.TRANSACTION_AMOUNT.getPosition(), StringUtil.ZERO);
            msg.set(BalanceInqRq.TRANSACTION_FEE_AMOUNT.getPosition(), StringUtil.ZERO);
            msg.set(BalanceInqRq.TRANSMISSON_DATE_TIME.getPosition(), DateUtil.getDate(new Date(),
                    DateUtil.ISO_TRANSMISSION_DATE_PATTERN));
            msg.set(BalanceInqRq.SYSTEM_TRACE_AUDIT_NUMBER.getPosition(),
                    request.getRequestUUID().substring(request.getRequestUUID().length() - 6));
            msg.set(BalanceInqRq.LOCAL_TRANSACTION_DATE_TIME.getPosition(),
                    DateUtil.getDate(new Date(),
                            DateUtil.ISO_LOCAL_TRANSACTION_DATE_TIME_PATTERN));
            msg.set(BalanceInqRq.EXPIRY_DATE.getPosition(),
                    (request.getTrk2EquivData() != null &&
                            request.getTrk2EquivData().getCardExpirationYearMonth() != null ?
                            request.getTrk2EquivData().getCardExpirationYearMonth().getCardExpirationDate() : null));
            msg.set(BalanceInqRq.POINT_OF_SERVICE_DATA_CODE.getPosition(), DEFAULT_POINT_OF_SERVICE);
            msg.set(BalanceInqRq.ACQUIRER_INSTITUTION_ID.getPosition(), DEFAULT_ACQUIRER_INSTITUTION_ID);
            msg.set(BalanceInqRq.FORWARDING_INSTITUTION_ID.getPosition(),
                    DEFAULT_ACQUIRER_INSTITUTION_ID);
            msg.set(BalanceInqRq.RETRIEVAL_REFERENCE_NO.getPosition(),
                    StringUtil.hasText(request.getRequestUUID()) ?
                            (request.getRequestUUID().length() > 6 ?
                                    request.getRequestUUID().substring(0, 6) :
                                    request.getRequestUUID()) :
                            RandomStringUtils.randomNumeric(6));
            msg.set(BalanceInqRq.CARD_ACCEPT_TERMINAL_ID.getPosition(), DEFAULT_CARD_ACCEPT_TERMINAL_ID);
            msg.set(BalanceInqRq.CARD_ACCEPT_ID_CODE.getPosition(), DEFAULT_CARD_ACCEPT_ID_CODE);
            msg.set(BalanceInqRq.CARD_ACCEPT_NAME_LOCATION.getPosition(), DEFAULT_CARD_ACCEPT_NAME_LOCATION);
            if(request.getTrk2EquivData() != null) {
                msg.set(BalanceInqRq.ADDITIONAL_PRIVATE_DATA.getPosition(), tailoreCVV2(request.getTrk2EquivData().getCVV2()));
            }
            msg.set(BalanceInqRq.TRANSACTION_CURRENCY_CODE.getPosition(), DEFAULT_CURRENCY_CODE);
            msg.set(BalanceInqRq.PIN_DATA.getPosition(), (request.getTrk2EquivData() != null)  ?
                    encryptPin(request.getTrk2EquivData().getPin()) : null);
            return msg;
        }
        catch (ISOException e) {
            throw new TransformerException(e.getMessage());
        }
    }

    private String createProcessCode() {
        return ProcessCode.BALANCE.getCode();
    }

    @Override
    public ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.BALANCE_INQ;
    }

}