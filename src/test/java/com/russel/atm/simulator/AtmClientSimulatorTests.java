package com.russel.atm.simulator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
@SpringBootTest
class AtmClientSimulatorTests {

    @Test
    void contextLoads() {
    }

    @Test
    void encryptPassword() {
        String rawPassword = "123";

        String encryptedPassword = new BCryptPasswordEncoder().encode(rawPassword);
        System.out.println(encryptedPassword);

    }

}