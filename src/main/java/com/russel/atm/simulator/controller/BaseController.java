package com.russel.atm.simulator.controller;

import com.russel.atm.simulator.common.CardExpirationYearMonth;
import com.russel.atm.simulator.common.FundTransfer;
import com.russel.atm.simulator.common.Trk2EquivData;
import com.russel.atm.simulator.util.StringUtil;
import com.russel.atm.simulator.util.ValidatorUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
@Controller
public class BaseController {

    protected String getCurrentUsername() {
        String username;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal == null) {
            return StringUtil.EMPTY;
        }
        if (principal != null && principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        }
        else {
            username = principal.toString();
        }
        return ValidatorUtil.isValidCardNo(username) ? username : null;
    }

    protected FundTransfer createFundTransfer(String cardNo, double amount) {
        FundTransfer fundTransfer = new FundTransfer();
        fundTransfer.setAmount(Long.valueOf(Double.valueOf(amount).longValue()));
        fundTransfer.setSourceCardNo(cardNo);

        return fundTransfer;
    }

    protected Trk2EquivData createTrk2EquivData(String pin , String cvv2) {
        CardExpirationYearMonth cardExpirationYearMonth = new CardExpirationYearMonth("99", "12");
        Trk2EquivData trk2EquivData = new Trk2EquivData();
        trk2EquivData.setPin(pin);
        trk2EquivData.setCVV2(cvv2);
        trk2EquivData.setCardExpirationYearMonth(cardExpirationYearMonth);

        return trk2EquivData;
    }

    protected String generateRequestUUID() {
        return RandomStringUtils.randomNumeric(6);
    }
}