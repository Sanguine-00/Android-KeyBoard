package com.mobcb.android.keyboard.demo.util;

import android.content.Context;
import android.content.res.Resources;


import com.mobcb.android.keyboard.demo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期操作
 *
 * @author lvmenghui
 * on 2018-03-22
 */

public class DateUtils {

    public static final String TYPE_01 = "yyyy-MM-dd HH:mm:ss";

    public static final String TYPE_02 = "yyyy-MM-dd";

    public static final String TYPE_03 = "HH:mm:ss";

    public static final String TYPE_04 = "yyyy年MM月dd日";

    public static final String TYPE_05 = "yyyy-MM-dd HH:mm";

    public static final String TYPE_06 = "yyyyMMddHHmmss";

    public static final String TYPE_07 = "yyyy/MM/dd HH:mm";

    public static final String TYPE_08 = "yyyy.MM.dd HH:mm";

    public static final String TYPE_09 = "yyyy.MM.dd";

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss型字符串
     */
    public static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(TYPE_01);
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * 获取当前日期
     *
     * @return yyyy-MM-dd型字符串
     */
    public static String getDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(TYPE_02);
        String date = sdf.format(new Date());
        return date;
    }

    /**
     * 获取昨天日期
     *
     * @return yyyy-MM-dd型字符串
     */
    public static String getYestodayDate() {
        SimpleDateFormat sdf = new SimpleDateFormat(TYPE_02);
        String date = sdf.format(new Date().getTime() - 24 * 60 * 60
                * 1000);
        return date;
    }

    /**
     * 获取时间
     *
     * @return yyyyMMddHH型字符串
     */
    public static String getNowOfYYYYMMDDHH() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH");
        String date = sdf.format(new Date().getTime());
        return date;
    }

    /**
     * 获取时间
     *
     * @return yyyy-MM
     */
    public static String getNowOfYYYY_MM() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String date = sdf.format(new Date().getTime());
        return date;
    }


    /**
     * 根据格式将UNIX时间戳转换为时间字符串
     *
     * @param unixtimestamp
     * @param format
     * @return
     */
    public static String fromUnixTime(long unixtimestamp, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String date = sdf.format(new Date(unixtimestamp * 1000L));
        return date;
    }

    /**
     * 获取两个日期之间的间隔分钟
     *
     * @return
     */
    public static int getGapMinuteCount(Date startDate, Date endDate) {
        Calendar fromCalendar = Calendar.getInstance();
        fromCalendar.setTime(startDate);
        fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
        fromCalendar.set(Calendar.MINUTE, 0);
        fromCalendar.set(Calendar.SECOND, 0);
        fromCalendar.set(Calendar.MILLISECOND, 0);

        Calendar toCalendar = Calendar.getInstance();
        toCalendar.setTime(endDate);
        toCalendar.set(Calendar.HOUR_OF_DAY, 0);
        toCalendar.set(Calendar.MINUTE, 0);
        toCalendar.set(Calendar.SECOND, 0);
        toCalendar.set(Calendar.MILLISECOND, 0);

        return (int) Math.floor(((toCalendar.getTime().getTime() - fromCalendar
                .getTime().getTime()) / (1000 * 60))) + 1;
    }

    /**
     * 将时间字符串转换为时间戳
     *
     * @param timeStr
     * @param pattern
     * @return
     */
    public static long getTimestamp(String timeStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date d = sdf.parse(timeStr);
            long tm = d.getTime() / 1000L;   //获得时间戳
            return tm;
        } catch (ParseException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 将时间字符串转换为时间戳
     *
     * @param timeStr
     * @param pattern
     * @return
     */
    public static long getTimeLong(String timeStr, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            Date d = sdf.parse(timeStr);
            long tm = d.getTime();   //获得时间戳
            return tm;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static String toDateDD(long timestamp) {
        String result = null;
        SimpleDateFormat format = new SimpleDateFormat(TYPE_02);
        result = format.format(new Date(timestamp * 1000));
        return result;
    }

    public static String getDateAndWeek() {
        final Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mYear = String.valueOf(c.get(Calendar.YEAR)); // 获取当前年份
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            mWay = "日";
        } else if ("2".equals(mWay)) {
            mWay = "一";
        } else if ("3".equals(mWay)) {
            mWay = "二";
        } else if ("4".equals(mWay)) {
            mWay = "三";
        } else if ("5".equals(mWay)) {
            mWay = "四";
        } else if ("6".equals(mWay)) {
            mWay = "五";
        } else if ("7".equals(mWay)) {
            mWay = "六";
        }
//        return mYear + "年" + mMonth + "月" + mDay+"日"+"/星期"+mWay;
        return mMonth + "." + mDay + "星期" + mWay;
    }

    /**
     * yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String getDateMins(long date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if ((date + "").length() == 13) {
                date = date / 1000;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String str = sdf.format(date * 1000);
        return str;
    }

    /**
     * 将时间戳格式化成  昨天 18:00  今天 10:10 这样的格式
     * <p>
     * 将当前时间的dayOfYear -0 之后,如果等于给定的时间戳的dayOfYear,则为今天
     * 将当前时间的dayOfYear -1 之后,如果等于给定的时间戳的dayOfYear,则为昨天
     * 将当前时间的dayOfYear -2 之后,如果等于给定的时间戳的dayOfYear,则为前天
     *
     * @param timestamp
     * @return
     */
    public static String toDataByYesterDay(long timestamp) {
        String result = null;
        String dateFormat = "MM-dd HH:mm";
        try {
            Calendar gavenCal = Calendar.getInstance();
            gavenCal.setTimeInMillis(timestamp * 1000);
            int gavenDayOfYear = gavenCal.get(Calendar.DAY_OF_YEAR);
            Calendar nowCal = Calendar.getInstance();
            nowCal.setTimeInMillis(System.currentTimeMillis());
            int dayOfYear = nowCal.get(Calendar.DAY_OF_YEAR);
            if (dayOfYear == gavenDayOfYear) {
                dateFormat = "今天 HH:mm";
            }
            nowCal.setTimeInMillis(System.currentTimeMillis());
            nowCal.getTime();
            nowCal.add(Calendar.DAY_OF_YEAR, -1);
            dayOfYear = nowCal.get(Calendar.DAY_OF_YEAR);
            if (dayOfYear == gavenDayOfYear) {
                dateFormat = "昨天 HH:mm";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        result = format.format(new Date(timestamp * 1000));
        return result;
    }

    public static String dateToStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(TYPE_02);
        String dateString = formatter.format(date);
        return dateString;
    }

    public static Date strToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat(TYPE_02);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
