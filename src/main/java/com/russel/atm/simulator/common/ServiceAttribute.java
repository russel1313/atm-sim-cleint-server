package com.russel.atm.simulator.common;

import java.io.Serializable;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public enum ServiceAttribute implements Serializable {

    CASH_IN_ADD("CashInAddRq"),
    CASH_OUT_ADD("CashOutAddRq"),
    XFER_ADD("XferAddRq"),
    BALANCE_INQ("BalanceInqRq"),
    UNKNOWN_SERVICE("UnknwonSvc");

    /**
     * The code.
     */
    private String code;

    /**
     * Instantiates a new service attribute.
     *
     * @param code the code
     */
    ServiceAttribute(String code) {
        this.code = code;
    }


    /**
     * Gets the code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }
}