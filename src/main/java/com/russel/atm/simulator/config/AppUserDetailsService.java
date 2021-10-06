package com.russel.atm.simulator.config;

import com.russel.atm.simulator.dao.IUserInfoDAO;
import com.russel.atm.simulator.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
@Service
public class AppUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    @Autowired
    private IUserInfoDAO userInfoDAO;

    public IUserInfoDAO getUserInfoDAO() {
        return userInfoDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String userName)
            throws UsernameNotFoundException {
        UserInfo activeUserInfo = userInfoDAO.getActiveUser(userName);
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
        UserDetails userDetails = new User(activeUserInfo.getUserName(),
                activeUserInfo.getPassword(), Arrays.asList(authority));
        return userDetails;
    }
}