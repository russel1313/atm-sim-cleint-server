package com.russel.atm.simulator.common;

import java.io.Serializable;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class Balance implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9052299063508329964L;

    /** The ledger balance. */
    private Long ledgerBalance;//LedgerBalance
    
    /** The depositable amount. */
    private Long depositableAmount;//AvailableBalance

    /** The blocked amount. */
    private Long blockedAmount;//Blocked Amount

    /** The currency. */
    private String currency;
    // balance Type can also be considered

    /**
     * Instantiates a new balance.
     */
    public Balance() {

    }

    /**
     * Instantiates a new balance.
     * 
     * @param ledgerBalance the ledger balance
     * @param availableBalance the depositable amount
     */
    public Balance(Long ledgerBalance, Long availableBalance) {
        this.ledgerBalance = ledgerBalance;
        this.depositableAmount = availableBalance;
    }

    /**
     * Gets the ledger balance.
     * 
     * @return the ledger balance
     */
    public Long getLedgerBalance() {
        return ledgerBalance;
    }

    /**
     * Sets the ledger balance.
     * 
     * @param ledgerBalance the new ledger balance
     */
    public void setLedgerBalance(Long ledgerBalance) {
        this.ledgerBalance = ledgerBalance;
    }

    /**
     * Gets the depositable amount.
     * 
     * @return the depositable amount
     */
    public Long getDepositableAmount() {
        return depositableAmount;
    }

    /**
     * Sets the depositable amount.
     * 
     * @param depositableAmount the new depositable amount
     */
    public void setDepositableAmount(Long depositableAmount) {
        this.depositableAmount = depositableAmount;
    }

    public Long getBlockedAmount() {
        return blockedAmount;
    }

    public void setBlockedAmount(Long blockedAmount) {
        this.blockedAmount = blockedAmount;
    }

    /**
     * Gets the currency.
     *
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency.
     *
     * @param currency the new currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }//accountNo can also be considered

    @Override
    public String toString() {
        return  ledgerBalance + "";
    }
}