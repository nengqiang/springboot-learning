package com.hnq.study.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author henengqiang
 * @date 2018/9/14
 */
public class DateUtil {

    /**
     * Date --> String
     *
     * @param date      指定日期
     * @param format    指定格式
     * @return          转换后的日期
     */
    public static String dateToString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * String --> Date
     *
     * @param dateStr   指定日期
     * @param format    指定格式
     * @return          转换后的日期
     * @throws ParseException
     *                  抛出格式转换异常给调用该方法的地方去捕获
     */
    public static Date stringToDate(String dateStr, String format) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.parse(dateStr);
    }

}
