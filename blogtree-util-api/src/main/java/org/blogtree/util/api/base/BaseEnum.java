package org.blogtree.util.api.base;

/**
 * 枚举类接口
 *
 * @author AlanGeeker
 */
public interface BaseEnum<T extends BaseEnum> {

    /**
     * 获取当前枚举的code（枚举唯一编码）
     *
     * @return 当前枚举的code
     */
    Integer getCode();

    /**
     * 获取当前枚举的text（枚举的描述信息）
     *
     * @return 当前枚举的text
     */
    String getText();

    /**
     * 获取当前枚举的name（枚举的name()）
     *
     * @return 当前枚举的name
     */
    String name();

    /**
     * 判断 入参code 与 当前枚举code 是否相等
     * <p>
     * 如果 入参code为null，则返回false
     *
     * @param code 需要比较的code
     * @return 是否相等
     */
    default boolean isEqualByCode(Integer code) {
        if (code == null) {
            return false;
        }
        return this.getCode().equals(code);
    }

    /**
     * 判断 入参name 与 当前枚举name 是否相等
     * <p>
     * 如果 入参name为null，则返回false
     *
     * @param name 需要比较的name
     * @return 是否相等
     */
    default boolean isEqualByName(String name) {
        if (name == null) {
            return false;
        }
        return this.name().equals(name);
    }


}
