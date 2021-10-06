package com.russel.atm.simulator.iso.transformer.balance;

import com.russel.atm.simulator.common.BalanceInquiryResponse;
import com.russel.atm.simulator.common.BaseResponseService;
import com.russel.atm.simulator.iso.ISOField;
import com.russel.atm.simulator.iso.transformer.BaseResponseTransformer;
import org.jpos.iso.ISOMsg;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class BalanceInqRsTransformer extends BaseResponseTransformer<BalanceInquiryResponse> {

    @Override
    public BaseResponseService createResponseService() {
        return new BalanceInquiryResponse();
    }

    @Override
    public Object transform(ISOMsg message) {
        BalanceInquiryResponse response = (BalanceInquiryResponse)super.transform(message);
        response.setBalance(createBalance(message.getString(ISOField.ADDITIONAL_AMOUNTS.getPosition())));
        return response;
    }
}