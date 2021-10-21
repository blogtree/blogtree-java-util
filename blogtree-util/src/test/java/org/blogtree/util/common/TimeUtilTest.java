package org.blogtree.util.common;

import org.blogtree.util.base.BaseTest;
import org.junit.Test;

import java.util.Date;

public class TimeUtilTest extends BaseTest {

    @Test
    public void toStr() {
        // 当前时间
        Date now = new Date();

        // 转换为字符串
        log.info("date1={}", TimeUtil.toStr(now));
        log.info("date2={}", TimeUtil.toStr(now, TimeUtil.FORMAT_DATE));
        log.info("date3={}", TimeUtil.toStr(now, TimeUtil.FORMAT_DATE_TIME));
        log.info("date4={}", TimeUtil.toStr(now, "yyyy-MM-dd HH:mm"));
    }


    @Test
    public void toDate() {
        String str1 = "2018-08-16 20:08:08";
        log.info("str1={}", TimeUtil.toStr(TimeUtil.toDate(str1, TimeUtil.FORMAT_DATE_TIME)));

        String str2 = "2018-08-16";
        log.info("str2={}", TimeUtil.toStr(TimeUtil.toDate(str2, TimeUtil.FORMAT_DATE)));

        String str3 = "2018-08-16 20:08";
        log.info("str3={}", TimeUtil.toStr(TimeUtil.toDate(str3, "yyyy-MM-dd HH:mm")));
    }

    @Test
    public void addYear() {
        // 当前时间
        Date now = new Date();

        log.info("now = {}", now);
        log.info("year + 1 = {}", TimeUtil.addYear(now, 1));
        log.info("year + 2 = {}", TimeUtil.addYear(now, 2));
        log.info("year + 3 = {}", TimeUtil.addYear(now, 3));

        log.info("year - 1 = {}", TimeUtil.addYear(now, -1));
        log.info("year - 2 = {}", TimeUtil.addYear(now, -2));
        log.info("year - 3 = {}", TimeUtil.addYear(now, -3));
    }

    @Test
    public void addMouth() {
        // 当前时间
        Date now = new Date();

        log.info("now = {}", now);
        log.info("month + 1 = {}", TimeUtil.addMonth(now, 1));
        log.info("month + 2 = {}", TimeUtil.addMonth(now, 2));
        log.info("month + 3 = {}", TimeUtil.addMonth(now, 3));

        log.info("month - 1 = {}", TimeUtil.addMonth(now, -1));
        log.info("month - 2 = {}", TimeUtil.addMonth(now, -2));
        log.info("month - 3 = {}", TimeUtil.addMonth(now, -3));
    }

    @Test
    public void addDay() {
        // 当前时间
        Date now = new Date();

        log.info("now = {}", now);
        log.info("day + 1 = {}", TimeUtil.addDay(now, 1));
        log.info("day + 2 = {}", TimeUtil.addDay(now, 2));
        log.info("day + 3 = {}", TimeUtil.addDay(now, 3));

        log.info("day - 1 = {}", TimeUtil.addDay(now, -1));
        log.info("day - 2 = {}", TimeUtil.addDay(now, -2));
        log.info("day - 3 = {}", TimeUtil.addDay(now, -3));
    }

    @Test
    public void addHour() {
        // 当前时间
        Date now = new Date();

        log.info("now = {}", now);
        log.info("hour + 1 = {}", TimeUtil.addHour(now, 1));
        log.info("hour + 2 = {}", TimeUtil.addHour(now, 2));
        log.info("hour + 3 = {}", TimeUtil.addHour(now, 3));

        log.info("hour - 1 = {}", TimeUtil.addHour(now, -1));
        log.info("hour - 2 = {}", TimeUtil.addHour(now, -2));
        log.info("hour - 3 = {}", TimeUtil.addHour(now, -3));
    }

    @Test
    public void addMinute() {
        // 当前时间
        Date now = new Date();

        log.info("now = {}", now);
        log.info("minute + 1 = {}", TimeUtil.addMinute(now, 1));
        log.info("minute + 2 = {}", TimeUtil.addMinute(now, 2));
        log.info("minute + 3 = {}", TimeUtil.addMinute(now, 3));

        log.info("minute - 1 = {}", TimeUtil.addMinute(now, -1));
        log.info("minute - 2 = {}", TimeUtil.addMinute(now, -2));
        log.info("minute - 3 = {}", TimeUtil.addMinute(now, -3));
    }

    @Test
    public void getSecondTimestamp() throws InterruptedException {
        int count = 10;
        long t1 = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            Date now = new Date();
            Integer second = TimeUtil.getSecondTimestamp(now);
            log.info("second={}, ms={}", second, now.getTime());
            Thread.sleep(300);
        }

        long t2 = System.currentTimeMillis();

        log.info("执行{}次,耗时{}毫秒", count, (t2 - t1));
    }

    @Test
    public void getWeeHours() {
        Date now = new Date();
        Date weeHours = TimeUtil.getWeeHours(now);

        print(weeHours);
        print(TimeUtil.toStr(weeHours));
    }
}