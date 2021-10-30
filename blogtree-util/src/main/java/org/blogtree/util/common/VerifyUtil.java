package org.blogtree.util.common;

import java.util.Date;
import java.util.List;

/**
 * 校验类
 *
 * @author AlanGeeker
 */
public class VerifyUtil {

    /**
     * 校验 String 是否为null、空字符串
     */
    public static boolean isEmpty(String val) {
        return val == null || "".equals(val);
    }

    /**
     * 校验 String 是否为null、空字符串、多个空格
     */
    public static boolean isBlank(String val) {
        return val == null || "".equals(val) || "".equals(val.trim());
    }

    /**
     * 校验 Integer 是否为null、0
     */
    public static boolean isEmpty(Integer val) {
        return val == null || val == 0;
    }

    /**
     * 校验 Long 是否为null、0
     */
    public static boolean isEmpty(Long val) {
        return val == null || val == 0;
    }

    /**
     * 校验 Double 是否为null、0
     */
    public static boolean isEmpty(Double val) {
        return val == null || val == 0;
    }

    /**
     * 校验 Date 是否为null、0
     */
    public static boolean isEmpty(Date val) {
        return val == null || val.getTime() == 0;
    }

    /**
     * 校验 List 是否为null、size=0
     */
    public static boolean isEmpty(List val) {
        return val == null || val.size() == 0;
    }

    /**
     * 判断 int 是否在区间中（包含边界值min和max）
     * 注意：入参value不能为空
     */
    public static boolean isBetween(int value, int min, int max) {
        return value >= min && value <= max;
    }
}
