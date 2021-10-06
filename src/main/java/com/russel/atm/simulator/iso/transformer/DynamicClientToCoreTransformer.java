package com.russel.atm.simulator.iso.transformer;

import com.russel.atm.simulator.common.ServiceAttribute;
import com.russel.atm.simulator.exception.TransformerException;
import com.russel.atm.simulator.iso.transformer.balance.BalanceInqRqTransformer;
import com.russel.atm.simulator.iso.transformer.cashin.CashInAddRqTransformer;
import com.russel.atm.simulator.iso.transformer.cashout.CashOutAddRqTransformer;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class DynamicClientToCoreTransformer {

    private static DynamicClientToCoreTransformer instance;

    private DynamicClientToCoreTransformer() {
    }

    public static DynamicClientToCoreTransformer getInstance() {
        if (instance == null) {
            instance = new DynamicClientToCoreTransformer();
        }
        return instance;
    }

    public Object doTransform(Object src) throws TransformerException {
        com.russel.atm.simulator.common.BaseRequestService service = (com.russel.atm.simulator.common.BaseRequestService) src;
        ServiceAttribute serviceAttribute = service.getServiceAttribute();
        BaseRequestTransformer requestTransformer;
        if(serviceAttribute.getCode().equals(ServiceAttribute.BALANCE_INQ.getCode())) {
            requestTransformer = new BalanceInqRqTransformer();
        }
        else if(serviceAttribute.getCode().equals(ServiceAttribute.CASH_IN_ADD.getCode())) {
            requestTransformer = new CashInAddRqTransformer();
        }
        else if(serviceAttribute.getCode().equals(ServiceAttribute.CASH_OUT_ADD.getCode())) {
            requestTransformer = new CashOutAddRqTransformer();
        }
        else {
            throw new TransformerException("No transformer found for " + serviceAttribute.getCode());
        }
        Object transformed = requestTransformer.transform(service);
        return transformed;
    }
}