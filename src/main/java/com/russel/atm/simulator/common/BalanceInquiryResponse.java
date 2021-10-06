package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class BalanceInquiryResponse extends BaseResponseService {

    private static final long serialVersionUID = 4072212366101998286L;

    /** The balance. */
    private Balance balance;
    private String processCode;
    private String cardNo;

    /**
     * Gets the balance.
     * 
     * @return the balance
     */
    public Balance getBalance() {
        return balance;
    }

    /**
     * Sets the balance.
     * 
     * @param balance the new balance
     */
    public void setBalance(Balance balance) {
        this.balance = balance;
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
    * @see com.russel.atm.simulator.common.BaseResponseService#getServiceAttribute()
    */
    @Override
    public final ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.BALANCE_INQ;
    }
}