package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class BalanceInquiryRequest extends BaseRequestService {

    private static final long serialVersionUID = 1156800068111975119L;

    private String sourceCardNo;
    private Trk2EquivData trk2EquivData;

    public String getSourceCardNo() {
        return sourceCardNo;
    }

    public void setSourceCardNo(String sourceCardNo) {
        this.sourceCardNo = sourceCardNo;
    }

    public Trk2EquivData getTrk2EquivData() {
        return trk2EquivData;
    }

    public void setTrk2EquivData(Trk2EquivData trk2EquivData) {
        this.trk2EquivData = trk2EquivData;
    }

    public String getCardNo() {
        return getSourceCardNo();
    }

    public void setCardNo(String cardNo) {
        this.sourceCardNo = cardNo;
    }

    /* (non-Javadoc)
    * @see com.russel.atm.simulator.common.BaseService#getServiceAttribute()
    */
    @Override
    public final ServiceAttribute getServiceAttribute() {
        return ServiceAttribute.BALANCE_INQ;
    }
}