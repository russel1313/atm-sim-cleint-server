package com.russel.atm.simulator.dao;

import com.russel.atm.simulator.entity.Account;
import com.russel.atm.simulator.entity.UserInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
@Repository
@Transactional
public class UserInfoDAO implements IUserInfoDAO {
    private int userId;
    private String fullName;
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserInfo getActiveUser(String userName) {
        UserInfo activeUserInfo = new UserInfo();
        List<?> list = entityManager.createQuery("SELECT u FROM UserInfo u WHERE userName=?1")
                .setParameter(1, userName).getResultList();
        if (!list.isEmpty()) {
            activeUserInfo = (UserInfo) list.get(0);
        }
        this.userId = activeUserInfo.getUserId();
        this.fullName = activeUserInfo.getFullName();
        return activeUserInfo;
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Account getAllBalances() {
        String hql = "FROM Account as atcl WHERE atcl.accountId=" + userId;
        return ((List<Account>) entityManager.createQuery(hql).getResultList()).get(0);
    }

    @Override
    public void setChecking(double amt) {
        Query query = entityManager.createQuery("update Account set checking=:amt where account_id=:userId");
        query.setParameter("amt", amt);
        query.setParameter("userId", this.userId);
        query.executeUpdate();
    }

    @Override
    public void setSaving(double amt) {
        Query query = entityManager.createQuery("update Account set saving=:amt where account_id=:userId");
        query.setParameter("amt", amt);
        query.setParameter("userId", this.userId);
        query.executeUpdate();
    }

    @Override
    public void checkingToSaving(double amt) {
        Query query = entityManager.createQuery("update Account set saving=saving+:amt where account_id =:userId");
        query.setParameter("amt", amt);
        query.setParameter("userId", this.userId);
        query.executeUpdate();
        Query query1 = entityManager.createQuery("update Account set checking=checking-:amt where account_id =:userId");
        query1.setParameter("amt", amt);
        query1.setParameter("userId", this.userId);
        query1.executeUpdate();
    }

    @Override
    public void savingToChecking(double amt) {
        Query query = entityManager.createQuery("update Account set saving=saving-:amt where account_id =:userId");
        query.setParameter("amt", amt);
        query.setParameter("userId", this.userId);
        query.executeUpdate();
        Query query1 = entityManager.createQuery("update Account set checking=checking+:amt where account_id =:userId");
        query1.setParameter("amt", amt);
        query1.setParameter("userId", this.userId);
        query1.executeUpdate();
    }
}
