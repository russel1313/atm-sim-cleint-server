package com.russel.atm.simulator.common;

import java.io.Serializable;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public enum Status implements StatusIF, Serializable {

    SUCCESS("0", Severity.INFO, "Success"),
    GENERAL_ERROR("100", Severity.ERROR, "General Error"),//All uncatched exception and general data errors
    GENERAL_DATA_ERROR("200", Severity.ERROR, "General Data Error");//All uncatched exceptions

    private Severity severity;
    private String code;
    private String description;

    Status(String code, Severity severity, String description) {
        this.severity = severity;
        this.code = code;
        this.description = description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getServerCode() {
        return null;
    }

    public String getName() {
        return name();
    }

    public static Status findByCode(String code) {  //@todo duplicate code with ServiceAttribute
        Status[] attrs = Status.values();
        for (Status attr : attrs) {
            if (attr.getCode().equals(code)) {
                return attr;
            }
        }
        return null;
    }
}