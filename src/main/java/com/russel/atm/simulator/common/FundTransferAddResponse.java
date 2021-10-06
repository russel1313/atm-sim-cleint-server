package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class FundTransferAddResponse extends BaseResponseService {

    private static final long serialVersionUID = -3990791498520349114L;

    private FundTransfer fundTransfer;

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.FundTransfer#getFundTransfer()
     */
    public FundTransfer getFundTransfer() {
        return fundTransfer;
    }

    /**
     * Sets the fund transfer.
     *
     * @param transfer the new fund transfer
     */
    public void setFundTransfer(FundTransfer transfer) {
        this.fundTransfer = (FundTransfer)transfer;
    }

    public Long getAmount() {
        return getFundTransfer() != null ? getFundTransfer().getAmount() : null;
    }

    public void setAmount(Long amount) {
        if(getFundTransfer() == null) {
            setFundTransfer(new FundTransfer());
        }
        getFundTransfer().setAmount(amount);
    }

    public String getCardNo() {
        return getFundTransfer() != null ? getFundTransfer().getSourceCardNo() : null;
    }

    public void setCardNo(String cardNo) {
        if(getFundTransfer() == null) {
            setFundTransfer(new FundTransfer());
        }
        getFundTransfer().setSourceCardNo(cardNo);
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.BaseService#getServiceAttribute()
     */
    @Override
    public ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.XFER_ADD;
    }
}