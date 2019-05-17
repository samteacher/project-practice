package com.sam.redisdemo.util;

import java.util.Calendar;

/**
 * @author Administrator
 */
public class Utils {

    /**
     * 现在到今天结束的毫秒数
     *
     * @return
     */
    public static Long getCurrent2TodayEndMillisTime() {
        Calendar todayEnd = Calendar.getInstance();
        // Calendar.HOUR 12小时制
        // HOUR_OF_DAY 24小时制
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTimeInMillis() - System.currentTimeMillis();
    }

}
