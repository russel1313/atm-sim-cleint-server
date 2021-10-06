package com.russel.atm.simulator.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class DateUtil {

    /**
     * The Constant DEFAULT_DATE_PATTERN.
     */
    public static final String DEFAULT_DATE_PATTERN = "yyyy/MM/dd"; //RS FIXED

    /**
     * The Constant FULL_DATE_PATTERN.
     */
    public static final String FULL_DATE_PATTERN = "yyyy/MM/dd HH:mm";

    /**
     * The Constant ISO_TRANSMISSION_DATE_PATTERN.
     */
    public static final String ISO_TRANSMISSION_DATE_PATTERN = "MMddHHmmss";

    /**
     * The Constant ISO_LOCAL_TRANSACTION_DATE_TIME_PATTERN.
     */
    public static final String ISO_LOCAL_TRANSACTION_DATE_TIME_PATTERN = "yyMMddHHmmss";

    private static Map formatHolder = new HashMap();

    /**
     * Instantiates a new date util.
     */
    public DateUtil() {
    }

    /**
     * Gets the simple format date.
     *
     * @param date the date
     * @return the simple format date
     */
    public static final String getSimpleFormatDate(Date date) {
        return getDate(date, DEFAULT_DATE_PATTERN);
    }

    /**
     * Gets the date.
     *
     * @param date    the date
     * @param pattern the pattern
     * @return the date
     */
    public static final String getDate(Date date, String pattern) {
        return (date == null) ? StringUtil.EMPTY
                : getSimpleDateFormat(pattern, null).format(date);
    }

    /**
     * Convert string to date.
     *
     * @param strDate the str date
     * @return the date
     * @throws ParseException the parse exception
     */
    public static Date convertStringToDate(String strDate)
            throws ParseException {
        Date aDate = null;

        try {
            aDate = convertStringToDate(FULL_DATE_PATTERN, strDate);
        } catch (ParseException pe) {
            pe.printStackTrace();
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return aDate;
    }

    /**
     * Convert string to date.
     *
     * @param aMask   the a mask
     * @param strDate the str date
     * @return the date
     * @throws ParseException the parse exception
     */
    public static final Date convertStringToDate(String aMask, String strDate)
            throws ParseException {
        Date date = null;
        SimpleDateFormat df = getSimpleDateFormat(aMask, null);

        try {
            date = df.parse(strDate);
        }
        catch (ParseException pe) {
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return date;
    }

    private static SimpleDateFormat getSimpleDateFormat(String pattern, Locale locale) {
        return (SimpleDateFormat) getFormat(pattern, locale);
    }

    private static Object getFormat(String pattern, Locale locale) {
        String formatKey = (locale != null)
                ? (new StringBuilder()).append(pattern).append(locale.toString())
                .toString() : pattern;
        formatKey = formatKey;
        if (formatHolder.get(formatKey) == null) {
            if (locale != null) {
                formatHolder.put(formatKey, new SimpleDateFormat(pattern, locale));
            }
            else {
                formatHolder.put(formatKey, new SimpleDateFormat(pattern));
            }
        }

        return formatHolder.get(formatKey);
    }
}