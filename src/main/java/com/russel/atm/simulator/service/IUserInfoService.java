package com.russel.atm.simulator.service;

import com.russel.atm.simulator.entity.Account;
import org.springframework.security.access.annotation.Secured;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public interface IUserInfoService {
    String getFullName();

    @Secured({"ROLE_ADMIN"})
    Account getAllBalances();

    void setChecking(double amt);

    void setSaving(double amt);

    void checkingToSaving(double amt);

    void savingToChecking(double amt);
}