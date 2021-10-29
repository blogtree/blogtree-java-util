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

    public static List toList(int[] arr) {
        if (arr == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List toList(long[] arr) {
        if (arr == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List toList(String[] arr) {
        if (arr == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.stream(arr)
                .collect(Collectors.toList());
    }

    public static Integer[] toArray(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return EMPTY_ARRAY_INTEGER;
        }
        Integer[] arr = new Integer[list.size()];
        return list.toArray(arr);
    }
}
