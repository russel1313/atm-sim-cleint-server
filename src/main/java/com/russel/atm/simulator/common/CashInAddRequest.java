package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class CashInAddRequest extends FundTransferAddRequest {

    private static final long serialVersionUID = -4800475648623977212L;

    @Override
    public ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.CASH_IN_ADD;
    }
}