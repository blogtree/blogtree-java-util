package org.blogtree.util.api.util;

import org.blogtree.util.api.base.BaseEnum;

/**
 * 枚举工具类，需要和BaseEnum配合使用
 *
 * @author AlanGeeker
 */
public class EnumUtil {

    /**
     * 根据value获取enum
     *
     * @param value value值
     * @param enums 实际的enum列表
     * @param <T>   实际的enum类型
     * @return 对应的enum，可能为null
     */
    public static <T extends BaseEnum> T getEnumByValue(Integer value, T[] enums) {
        if (value == null || enums == null || enums.length == 0) {
            return null;
        }
        for (T item : enums) {
            if (item.getValue().equals(value)) {
                return item;
            }
        }
        return null;
    }

    /**
     * 根据value获取enum文案
     *
     * @param value value值
     * @param enums 实际的enum列表
     * @param <T>   实际的enum类型
     * @return 对应的enum文案，可能为null
     */
    public static <T extends BaseEnum> String getTextByValue(Integer value, T[] enums) {
        BaseEnum item = EnumUtil.getEnumByValue(value, enums);
        return item == null ? null : item.getText();
    }

    /**
     * 判断枚举类是否包含value
     *
     * @param value value值
     * @param enums 实际的enum列表
     * @param <T>   实际的enum类型
     * @return 是否包含
     */
    public static <T extends BaseEnum> boolean contain(Integer value, T[] enums) {
        BaseEnum item = EnumUtil.getEnumByValue(value, enums);
        return item != null;
    }
}
