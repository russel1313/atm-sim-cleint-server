package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class CashOutAddResponse extends BaseResponseService {

    private static final long serialVersionUID = 2942775721727709627L;

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.BaseResponseService#getServiceAttribute()
     */
    @Override
    public ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.CASH_OUT_ADD;
    }
}