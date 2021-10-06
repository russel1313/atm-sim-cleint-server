package com.russel.atm.simulator.iso.transformer.cashin;

import com.russel.atm.simulator.common.BaseResponseService;
import com.russel.atm.simulator.common.CashInAddResponse;
import com.russel.atm.simulator.common.ServiceAttribute;
import com.russel.atm.simulator.iso.transformer.BaseResponseTransformer;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class CashInAddRsTransformer extends BaseResponseTransformer<CashInAddResponse> {

    @Override
    public BaseResponseService createResponseService() {
        return new CashInAddResponse();
    }

    @Override
    public ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.CASH_IN_ADD;
    }
}