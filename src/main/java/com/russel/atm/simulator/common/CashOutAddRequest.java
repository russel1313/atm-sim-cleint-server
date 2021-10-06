package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class CashOutAddRequest extends FundTransferAddRequest {

    private static final long serialVersionUID = 3687247521197417245L;

    @Override
    public ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.CASH_OUT_ADD;
    }
}