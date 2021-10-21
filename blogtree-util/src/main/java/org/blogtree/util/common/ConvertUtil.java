package org.blogtree.util.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 类型转换的工具类
 */
public class ConvertUtil {

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
}
