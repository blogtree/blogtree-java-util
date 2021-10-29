package org.blogtree.util.common;

import java.util.Objects;
import java.util.function.BiConsumer;

/**
 * Iterable 的工具类
 *
 * @author AlanGeeker
 */
public class IterableUtil {

    /**
     * 遍历列表时，可以同时使用 index 和 item
     *
     * @param elements 列表
     * @param action   执行动作
     * @param <E>      元素类型
     */
    public static <E> void forEach(
            Iterable<? extends E> elements, BiConsumer<Integer, ? super E> action) {
        Objects.requireNonNull(elements);
        Objects.requireNonNull(action);

        int index = 0;
        for (E element : elements) {
            action.accept(index++, element);
        }
    }
}
