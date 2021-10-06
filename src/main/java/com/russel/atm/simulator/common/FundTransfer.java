package com.russel.atm.simulator.common;

import java.io.Serializable;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class FundTransfer implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 9077774152756744066L;

    /**
     * The source card no.
     */
    private String sourceCardNo;

    /**
     * The destination card no.
     */
    private String destinationCardNo;

    /**
     * The amount.
     */
    private Long amount;//Amount

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /* (non-Javadoc)
     * @see com.russel.atm.simulator.common.FundTransfer#getAmount()
     */
    public Long getAmount() {
        return amount;
    }

    /**
     * Sets the amount.
     *
     * @param amount the new amount
     */
    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getSourceCardNo() {
        return sourceCardNo;
    }

    public void setSourceCardNo(String sourceCardNo) {
        this.sourceCardNo = sourceCardNo;
    }

    public String getDestinationCardNo() {
        return destinationCardNo;
    }

    public void setDestinationCardNo(String destinationCardNo) {
        this.destinationCardNo = destinationCardNo;
    }
}