package com.russel.atm.simulator.common;

import com.russel.atm.simulator.util.Alignment;
import com.russel.atm.simulator.util.StringUtil;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class CardExpirationYearMonth extends DateTime {

    private static final long serialVersionUID = 3714432893640895123L;

    public CardExpirationYearMonth(int year, int month) {
        super(year, month, 0);
    }

    public CardExpirationYearMonth(String year, String month) {
        super(Integer.parseInt(year), Integer.parseInt(month), 0);
    }

    public CardExpirationYearMonth(int year, int month, int day) {
        super(year, month, day);
    }

    public String getCardExpirationDate() {
        //last 2 digits of year + 2 digits of month
        return StringUtil.padZero(String.valueOf(getYear()), 2, Alignment.LEFT) + StringUtil.padZero(String.valueOf(getMonth()), 2, Alignment.LEFT);
    }
}