package org.blogtree.util.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类型转换的工具类
 *
 * @author AlanGeeker
 */
public class ConvertUtil {

    private static Integer[] EMPTY_ARRAY_INTEGER = new Integer[0];

    /**
     * int数组 转为 Integer列表
     */
    public static List<Integer> toList(int[] arr) {
        if (arr == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * long数组 转为 Long列表
     */
    public static List<Long> toList(long[] arr) {
        if (arr == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }

    /**
     * String数组 转为 String列表
     */
    public static List<String> toList(String[] arr) {
        if (arr == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.stream(arr)
                .collect(Collectors.toList());
    }

    /**
     * Integer列表 转为 Integer数组
     */
    public static Integer[] toArray(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return EMPTY_ARRAY_INTEGER;
        }
        Integer[] arr = new Integer[list.size()];
        return list.toArray(arr);
    }
}
