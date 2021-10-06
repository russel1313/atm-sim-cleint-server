package com.russel.atm.simulator.common;

import java.io.Serializable;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class Trk2EquivData implements Serializable{

    private static final long serialVersionUID = 2569303412775492534L;

    private String pin;
    private String CVV2;
    private CardExpirationYearMonth cardExpirationYearMonth;

    public Trk2EquivData() {
    }

    public Trk2EquivData(String pin, String CVV2, CardExpirationYearMonth expirationDate) {
        this.pin = pin;
        this.CVV2 = CVV2;
        this.cardExpirationYearMonth = expirationDate;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getCVV2() {
        return CVV2;
    }

    public void setCVV2(String CVV2) {
        this.CVV2 = CVV2;
    }

    public CardExpirationYearMonth getCardExpirationYearMonth() {
        return cardExpirationYearMonth;
    }

    public void setCardExpirationYearMonth(CardExpirationYearMonth cardExpirationYearMonth) {
        this.cardExpirationYearMonth = cardExpirationYearMonth;
    }
}