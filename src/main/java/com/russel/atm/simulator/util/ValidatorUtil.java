package com.russel.atm.simulator.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class ValidatorUtil {
    public static boolean isValidCardNo(String cardNo) {
        if(StringUtil.isEmpty(cardNo)) {
            return false;
        }

        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
                "(?<mastercard>5[1-5][0-9]{14})|" +
                "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(?<amex>3[47][0-9]{13})|" +
                "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
                "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

        Pattern pattern = Pattern.compile(regex);

        //Strip all hyphens
        cardNo = cardNo.replaceAll("-", "");

        //Match the card
        Matcher matcher = pattern.matcher(cardNo);
        return matcher.matches();
    }
}