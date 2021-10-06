package com.russel.atm.simulator.iso;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public enum ProcessCode {
    AUTHENTICATION("300000"),
    BALANCE("310000"),
    CASHIN("230000"),
    CASHOUT("010000");

    private String code;

    ProcessCode() {
        this.code = "111111";
    }

    ProcessCode(String code) {
        this.code = code;
    }

    public static ProcessCode getValue(String code) {
        for(ProcessCode processCode : ProcessCode.values()) {
            if(code.equals(processCode.code)) {
                return processCode;
            }
        }
        return null;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}