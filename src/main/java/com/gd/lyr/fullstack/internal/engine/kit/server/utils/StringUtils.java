package com.gd.lyr.fullstack.internal.engine.kit.server.utils;

/**
 * @author Yan.Ru.Li
 * @description StringUtils
 * @date 7/20/2023 15:41:51
 */
public class StringUtils {
    public static String truncateString(String value, int maxSize) {
        return value.length() > maxSize ? value.substring(0, maxSize) : value;
    }
}
