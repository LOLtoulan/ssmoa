package com.toulan.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author LOL_toulan
 * @Time 2020/2/28 0:04
 * @Message
 */
public class DateUtils {

    /**
     * 日期转字符串
     * @param departureTime 日期
     * @param patt 模式 yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String dateToString(Date departureTime, String patt) {

        SimpleDateFormat sdf = new SimpleDateFormat(patt);

        System.out.println("=======================");
        String format = sdf.format(departureTime);
        System.out.println("format:"+ format);
        System.out.println("patt:"+patt);
        System.out.println("=======================");

        return format;

    }

    /**
     * 字符串转日期
     * @param str
     * @param patt
     * @return
     * @throws ParseException
     */
    public static Date stringToDate(String str, String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        return sdf.parse(str);
    }

}
