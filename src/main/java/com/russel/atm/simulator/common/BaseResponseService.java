package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public abstract class BaseResponseService extends BaseService {

    private static final long serialVersionUID = 6657214350869291601L;

    /** The status. */
    private ResultStatus status;
    private String processCode;
    private String cardNo;

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public String getProcessCode() {
        return processCode;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.BaseService#getServiceAttribute()
     */
    public abstract ServiceAttribute getServiceAttribute();
}