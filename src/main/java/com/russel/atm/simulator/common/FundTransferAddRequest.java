package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class FundTransferAddRequest extends BaseTransferService {

    private static final long serialVersionUID = 1254094274712018837L;

    private FundTransfer fundTransfer = new FundTransfer();
    private Trk2EquivData trk2EquivData;

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.FundTransferAddRequest#getFundTransfer()
     */
    public FundTransfer getFundTransfer() {
        return fundTransfer;
    }

    /**
     * Sets the fund transfer.
     *
     * @param fundTransfer the new fund transfer
     */
    public void setFundTransfer(FundTransfer fundTransfer) {
        this.fundTransfer = fundTransfer;
    }

    public Trk2EquivData getTrk2EquivData() {
        return trk2EquivData;
    }

    public void setTrk2EquivData(Trk2EquivData trk2EquivData) {
        this.trk2EquivData = trk2EquivData;
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.BaseService#getServiceAttribute()
     */
    @Override
    public ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.XFER_ADD;
    }
}