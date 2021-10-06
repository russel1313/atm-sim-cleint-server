package com.russel.atm.simulator.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
@Entity
@Table(name = "accounts")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private int accountId;
    @Column(name = "checking")
    private double checking;
    @Column(name = "saving")
    private double saving;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getChecking() {
        return checking;
    }

    public void setChecking(double checking) {
        this.checking = checking;
    }

    public double getSaving() {
        return saving;
    }

    public void setSaving(double saving) {
        this.saving = saving;
    }
}
