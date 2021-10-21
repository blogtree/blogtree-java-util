package org.blogtree.util.api.common;

import org.blogtree.util.api.base.BaseEnum;

/**
 * 枚举工具类，需要和BaseEnum配合使用
 *
 * @author AlanGeeker
 */
public class EnumUtil {

    /**
     * 根据code获取enum
     *
     * @param code  code值
     * @param enums 实际的enum列表
     * @param <T>   实际的enum类型
     * @return 对应的enum，可能为null
     */
    public static <T extends BaseEnum> T getEnumByCode(Integer code, T[] enums) {
        if (code == null || enums == null || enums.length == 0) {
            return null;
        }
        for (T item : enums) {
            if (item.getCode().equals(code)) {
                return item;
            }
        }
        return null;
    }

    /**
     * 判断枚举类是否包含code
     *
     * @param code  code值
     * @param enums 实际的enum列表
     * @param <T>   实际的enum类型
     * @return 是否包含
     */
    public static <T extends BaseEnum> boolean contain(Integer code, T[] enums) {
        BaseEnum item = EnumUtil.getEnumByCode(code, enums);
        return item != null;
    }
}
