package org.darebeat.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.darebeat.utils.TimeUtils.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by darebeat on 9/30/16.
 */
public class TimeUtilsTest {
    private static SimpleDateFormat myFormat;
    private static long milliseconds;
    private static Date timeDate;
    private static String timeString;
    private static String myTimeString;
    private static String timeString0;
    private static String timeString1;
    private static String myTimeString0;
    private static String myTimeString1;

    @Before
    public void testBefore() {
        System.out.println("-------------------------------");
        System.out.println("The variable init ...");
        myFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        milliseconds = 1470991049000L;
        timeDate = new Date(milliseconds);
        timeString = "2016-08-12 16:37:29";
        myTimeString = "2016-08-12 16:37:29";
        timeString0 = "2016-08-12 16:00:00";
        timeString1 = "2016-08-12 17:10:10";
        myTimeString0 = "2016-08-12 16:00:00";
        myTimeString1 = "2016-08-12 17:10:10";
        System.out.println("The variable have been ready!");
        System.out.println("-------------------------------");
        System.out.println("\n");
    }

    @Test
    public void testMilliseconds2String() throws Exception {
        assertEquals(milliseconds2String(milliseconds),timeString);
        assertEquals(milliseconds2String(milliseconds, myFormat),myTimeString);
    }

    @Test
    public void testString2Milliseconds() throws Exception {
        assertEquals(string2Milliseconds(timeString),milliseconds);
        assertEquals(string2Milliseconds(myTimeString, myFormat),milliseconds);
    }

    @Test
    public void testString2Date() throws Exception {
        assertEquals(string2Date(timeString),timeDate);
        assertEquals(string2Date(myTimeString, myFormat),timeDate);
    }

    @Test
    public void testDate2String() throws Exception {
        assertEquals(date2String(timeDate),timeString);
        assertEquals(date2String(timeDate, myFormat),myTimeString);
    }

    @Test
    public void testDate2Milliseconds() throws Exception {
        assertEquals(date2Milliseconds(timeDate),milliseconds);
    }

    @Test
    public void testMilliseconds2Date() throws Exception {
        assertEquals(milliseconds2Date(milliseconds),timeDate);
    }

    @Test
    public void testGetIntervalTime() throws Exception {
        assertEquals(getIntervalTime(timeString0, timeString1, ConstUtils.TimeUnit.SEC),4210);
        assertEquals(getIntervalTime(myTimeString0, myTimeString1, ConstUtils.TimeUnit.SEC, myFormat),4210);
        assertEquals(getIntervalTime(new Date(4210000), new Date(0), ConstUtils.TimeUnit.SEC),4210);
    }

    @Test
    public void testGetCurTimeMills() throws Exception {
        long interval = getCurTimeMills() - System.currentTimeMillis();
        assertTrue(interval<10L);
    }

    @Test
    public void testGetCurTimeString() throws Exception {
        System.out.println(getCurTimeString());
        System.out.println(getCurTimeString(myFormat));
    }

    @Test
    public void testGetIntervalByNow() throws Exception {

    }

    @Test
    public void testIsLeapYear() throws Exception {
        assertEquals(isLeapYear(2012),true);
        assertEquals(isLeapYear(2000),true);
        assertEquals(isLeapYear(1900),false);
    }

    @After
    public void testAfter() {
        System.out.println("Test with Successful!");
    }

}
