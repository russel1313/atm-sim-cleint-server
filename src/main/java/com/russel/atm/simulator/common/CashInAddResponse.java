package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class CashInAddResponse extends FundTransferAddResponse {

    private static final long serialVersionUID = -5498259890024922603L;

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.BaseResponseService#getServiceAttribute()
     */
    @Override
    public ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.CASH_IN_ADD;
    }
}