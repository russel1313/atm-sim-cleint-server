package com.russel.atm.simulator.iso;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public enum MTI {

    AUTHORIZATION_ADVICE_REQUEST_COMMAND("1100"),
    AUTHORIZATION_ADVICE_RESPONSE_COMMAND("1110"),
    TRANSFER_REQUEST_COMMAND("1200"),
    TRANSFER_RESPONSE_COMMAND("1210"),
    NETWORK_MANAGEMENT_REQUEST_COMMAND("1804"),
    NETWORK_MANAGEMENT_RESPONSE_COMMAND("1814");

    private String code;

    MTI(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}