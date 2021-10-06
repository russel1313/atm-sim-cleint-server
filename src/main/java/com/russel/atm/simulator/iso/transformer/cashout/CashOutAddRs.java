package com.russel.atm.simulator.iso.transformer.cashout;

import com.russel.atm.simulator.iso.ISOField;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public enum CashOutAddRs {

    MTI(ISOField.MTI.getPosition()),
    PAN(ISOField.PAN.getPosition()),
    PROCESSING_CODE(ISOField.PROCESSING_CODE.getPosition()),
    TRANSACTION_AMOUNT(ISOField.TRANSACTION_AMOUNT.getPosition()),
    TRANSACTION_FEE_AMOUNT(ISOField.TRANSACTION_FEE_AMOUNT.getPosition(), false),
    TRANSMISSON_DATE_TIME(ISOField.TRANSMISSON_DATE_TIME.getPosition()),
    SYSTEM_TRACE_AUDIT_NUMBER(ISOField.SYSTEM_TRACE_AUDIT_NUMBER.getPosition()),
    LOCAL_TRANSACTION_DATE_TIME(ISOField.LOCAL_TRANSACTION_DATE_TIME.getPosition()),
    EXPIRY_DATE(ISOField.EXPIRY_DATE.getPosition()),
    CAPTURE_DATE(ISOField.CAPTURE_DATE.getPosition(),false),
    POINT_OF_SERVICE_DATA_CODE(ISOField.POINT_OF_SERVICE_DATA_CODE.getPosition(), false),
    ACQUIRER_INSTITUTION_ID(ISOField.ACQUIRER_INSTITUTION_ID.getPosition(), false),
    FORWARDING_INSTITUTION_ID(ISOField.FORWARDING_INSTITUTION_ID.getPosition(), false),
    RETRIEVAL_REFERENCE_NO(ISOField.RETRIEVAL_REFERENCE_NO.getPosition(), false),
    ACTION_CODE(ISOField.ACTION_CODE.getPosition()),
    CARD_ACCEPT_TERMINAL_ID(ISOField.CARD_ACCEPT_TERMINAL_ID.getPosition()),
    CARD_ACCEPT_ID_CODE(ISOField.CARD_ACCEPT_ID_CODE.getPosition(), false),
    CARD_ACCEPT_NAME_LOCATION(ISOField.CARD_ACCEPT_NAME_LOCATION.getPosition(), false),
    TRANSACTION_CURRENCY_CODE(ISOField.TRANSACTION_CURRENCY_CODE.getPosition(), false),
    DATA_RECORD(ISOField.DATA_RECORD.getPosition()),
    MAC_CODE(ISOField.MAC_CODE.getPosition());

    private Integer position;
    private boolean required;

    CashOutAddRs(Integer position) {
        this.position = position;
        this.required = true;
    }

    CashOutAddRs(Integer position, boolean required) {
        this.position = position;
        this.required=required;
    }

    public Integer getPosition() {
        return position;
    }

    public boolean isRequired() {
        return required;
    }
}