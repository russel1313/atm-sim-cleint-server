package com.russel.atm.simulator.common;

import java.io.Serializable;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public abstract class BaseTransferService extends BaseRequestService implements Serializable {

    private static final long serialVersionUID = -362581063757510222L;
    private FundTransfer transfer;

    public FundTransfer getFundTransfer() {
        return transfer;
    }

    public void setFundTransfer(FundTransfer transfer) {
        this.transfer = transfer;
    }

    public Long getAmount() {
        return getFundTransfer() != null ? getFundTransfer().getAmount() : null;
    }

    public void setAmount(Long amount) {
        if(getFundTransfer() == null) {
            setFundTransfer(new FundTransfer());
        }
        this.getFundTransfer().setAmount(amount);
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.model.PaymentAware#getPayment()
     */
    public String getDestinationCardNo() {
        return getFundTransfer()!=null? getFundTransfer().getDestinationCardNo(): null;
    }
}