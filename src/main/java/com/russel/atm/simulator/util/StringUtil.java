package com.russel.atm.simulator.util;

/**
 * @author Rassul Hessampour
 * @version $Revision: 1.1.0 $
 */
public class StringUtil {
    public static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String ZERO = "0";

    /**
     * Checks if is empty.
     *
     * @param str the str
     * @return true, if is empty
     */
    public static boolean isEmpty(String str) {
        return (str == null) || str.trim().equals(EMPTY);
    }

    /**
     * Checks for text.
     *
     * @param str the str
     * @return true, if successful
     */
    public static boolean hasText(String str) {
        return !isEmpty(str);
    }

    public static String fixSize(String source, int length) {
        if (hasText(source)) {
            return source.length() > length ? source.substring(0, length) : source;
        }
        return source;
    }

    /**
     * Append zero.
     *
     * @param str       the str
     * @param length    the length
     * @param alignment the alignment
     * @return the string
     */
    public static String padZero(String str, int length, Alignment alignment) {
        if (isEmpty(str)) {
            str = EMPTY;
        }
        while (str.length() < length) {
            if (alignment == Alignment.LEFT) {
                str = ZERO + str;
            } else if (alignment == Alignment.RIGHT) {
                str = str + ZERO;
            }
        }

        return str;
    }

    /**
     * Removes the redundant characters.
     *
     * @param srcStr  the src str
     * @param pattern the pattern
     * @return the string
     */
    public static String removeRedundantCharacters(String srcStr, String pattern) {
        if (isEmpty(srcStr) || isEmpty(pattern)) {
            return srcStr;
        }

        String destStr = srcStr;

        while ((destStr.length() >= pattern.length()) &&
                destStr.substring(0, pattern.length()).equals(pattern)) {
            destStr = destStr.substring(pattern.length());
        }

        return destStr;
    }

    public static String unpadZero(String srcStr) {
        return removeRedundantCharacters(srcStr, ZERO);
    }
}