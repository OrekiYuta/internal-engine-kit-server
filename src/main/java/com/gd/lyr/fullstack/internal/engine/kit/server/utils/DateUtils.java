package com.gd.lyr.fullstack.internal.engine.kit.server.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Yan.Ru.Li
 * @description DateUtils
 * @date 7/20/2023 15:41:43
 */
public class DateUtils {
    public static String formatTimestamp(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }
}
