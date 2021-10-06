package com.russel.atm.simulator.dao;

import com.russel.atm.simulator.entity.Account;
import com.russel.atm.simulator.entity.UserInfo;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public interface IUserInfoDAO {
    UserInfo getActiveUser(String userName);

    String getFullName();

    Account getAllBalances();

    void setChecking(double amt);

    void setSaving(double amt);

    void checkingToSaving(double amt);

    void savingToChecking(double amt);
}
