package com.russel.atm.simulator.iso.transformer.cashout;

import com.russel.atm.simulator.common.BaseResponseService;
import com.russel.atm.simulator.common.CashOutAddResponse;
import com.russel.atm.simulator.common.ServiceAttribute;
import com.russel.atm.simulator.iso.transformer.BaseResponseTransformer;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class CashOutAddRsTransformer extends BaseResponseTransformer<CashOutAddResponse> {

    @Override
    public BaseResponseService createResponseService() {
        return new CashOutAddResponse();
    }

    @Override
    public ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.CASH_OUT_ADD;
    }
}