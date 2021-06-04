package org.blogtree.util.util;

import lombok.extern.slf4j.Slf4j;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间、日期相关的工具类
 *
 * @author AlanGeeker
 */
@Slf4j
public class TimeUtil {

    /**
     * 时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String FORMAT_DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 时间格式 yyyy-MM-dd
     */
    public static final String FORMAT_DATE = "yyyy-MM-dd";

    /**
     * 一天的毫秒数
     */
    public static final long MS_ONE_DAY = 24 * 60 * 60 * 1000;
    /**
     * 一小时的毫秒数
     */
    public static final long MS_ONE_HOUR = 60 * 60 * 1000;
    /**
     * 一分钟的毫秒数
     */
    public static final long MS_ONE_MINUTE = 60 * 1000;

    /**
     * 时间类型的DateFormat（私有函数）
     * 格式：yyyy-MM-dd HH:mm:ss
     */
    private static ThreadLocal<DateFormat> threadLocalFormatDateTime = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(FORMAT_DATE_TIME);
        }
    };

    /**
     * 日期类型的DateFormat（私有函数）
     * 格式：yyyy-MM-dd
     */
    private static ThreadLocal<DateFormat> threadLocalFormatDate = new ThreadLocal<DateFormat>() {
        @Override
        protected DateFormat initialValue() {
            return new SimpleDateFormat(FORMAT_DATE);
        }
    };

    /**
     * 根据已有类型，获取SimpleDateFormat（私有方法）
     */
    private static DateFormat getSimpleDateFormat(String format) {
        // 因为格式 yyyy-MM-dd HH:mm:ss 用的比较多，所有放在前边
        if (FORMAT_DATE_TIME.equals(format)) {
            return threadLocalFormatDateTime.get();
        } else if (FORMAT_DATE.equals(format)) {
            return threadLocalFormatDate.get();
        } else {
            // 新创建一个DateFormat，稍微耗性能
            return new SimpleDateFormat(format);
        }
    }

    /**
     * Date转换为String
     */
    public static String toStr(Date date) {
        return TimeUtil.toStr(date, TimeUtil.FORMAT_DATE_TIME);
    }

    /**
     * Date转换为String
     */
    public static String toStr(Date date, String format) {
        if (date == null) {
            return "";
        } else {
            DateFormat df = getSimpleDateFormat(format);
            return df.format(date);
        }
    }

    /**
     * String转换为Date
     */
    public static Date toDate(String dateStr, String format) {
        if (dateStr != null && dateStr.trim().length() > 0) {
            DateFormat df = TimeUtil.getSimpleDateFormat(format);
            try {
                return df.parse(dateStr);
            } catch (Exception e) {
                log.info("TimeUtil-toDate-error,dateStr={}, format={}, e={}", dateStr, format, e);
            }
        }
        return null;
    }

    /**
     * 在入参的时间上，增加或减少年
     * 注：如果是减少天数，则传入负值
     */
    public static Date addYear(Date date, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) + year); //加减年
        return calendar.getTime();
    }

    /**
     * 在入参的时间上，增加或减少月
     * 注：如果是减少天数，则传入负值
     */
    public static Date addMonth(Date date, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(date);
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month); //加减月
        return calendar.getTime();
    }

    /**
     * 在入参的时间上，增加或减少天数
     * 注：如果是减少天数，则传入负值
     */
    public static Date addDay(Date date, int day) {
        return new Date(date.getTime() + MS_ONE_DAY * day);
    }

    /**
     * 在入参的时间上，增加或减少小时
     * 注：如果是减少小时，则传入负值
     */
    public static Date addHour(Date date, int hour) {
        return new Date(date.getTime() + MS_ONE_HOUR * hour);
    }

    /**
     * 在入参的时间上，增加或减少分钟
     * 注：如果是减少分钟，则传入负值
     */
    public static Date addMinute(Date date, int minute) {
        return new Date(date.getTime() + MS_ONE_MINUTE * minute);
    }

    /**
     * 获取以秒为单位的时间戳
     * 注：毫秒是向下取整
     */
    public static int getSecondTimestamp(Date date) {
        if (null == date) {
            return 0;
        }
        double second = Math.floor(date.getTime() / 1000);
        return ((Double) second).intValue();
    }

    /**
     * 获取某日凌晨时间
     */
    public static Date getWeeHours(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
}
