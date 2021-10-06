package com.russel.atm.simulator.common;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public enum CoreResponseCode {

    APPROVED("000"),
    REJECTED("100"),
    CARD_ISSUER_NOT_AVAILABLE("912");

    private String code;

    CoreResponseCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}