package org.blogtree.util.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 基于 Jackson 的 JSON工具类
 * <p>
 * 优点：
 * 1. obj to string 是按照字母顺序输出的。通常对象的属性顺序，有一定含义。
 * 2. Spring 默认集成
 * <p>
 * 缺点：
 * 1. 速度相比 fastjson慢一点
 *
 * @author AlanGeeker
 * @see <a href="https://github.com/FasterXML/jackson">Jackson - GitHub</a>
 */
public class JacksonUtil {

    private final static ObjectMapper mapper = new ObjectMapper();

    /**
     * 将任意对象转换为String类型
     *
     * @param obj java对象
     * @return json字符串
     */
    @SneakyThrows
    public static String toStr(Object obj) {
        return mapper.writeValueAsString(obj);
    }

    /**
     * 将字符串按照指定类型，转换为对象
     * <p>
     * 注意：对象的属性，需要有set方法；否则，赋值不会成功
     *
     * @param json  json字符串
     * @param clazz 要转换的java类
     * @param <T>   要转换的java类
     * @return 要转换的java对象
     */
    @SneakyThrows
    public static <T> T toObj(String json, Class<T> clazz) {
        return mapper.readValue(json, clazz);
    }

    /**
     * 将字符串转换为列表。
     * <p>
     * 注意：此方法中的范型T，并没有传递过去。方法会返回 List<LinkedHashMap>
     * <p>
     * 原生方案：
     * List<UserPo> newList = mapper.readValue(json, new TypeReference<List<UserPo>>() {});
     *
     * @param json  json字符串
     * @param clazz 要转换的java类
     * @param <T>   要转换的java类
     * @return 要转换的java对象列表
     */
    @SneakyThrows
    @Deprecated
    public static <T> List<T> toList(String json, Class<T> clazz) {
        List<T> list = mapper.readValue(json, new TypeReference<List<T>>() {
        });
        if (list == null || list.size() == 0) {
            return list;
        }
        List<T> resList = new LinkedList<>();
        for (T t : list) {
            resList.add(toObj(toStr(t), clazz));
        }
        return resList;
    }

    /**
     * 将字符串转换为 map
     *
     * @param json json字符串
     * @return Map<String, Object>
     */
    @SneakyThrows
    @Deprecated
    public static Map<String, Object> toMap(String json) {
        return mapper.readValue(json, new TypeReference<Map<String, Object>>() {
        });
    }

    /**
     * 将字符串转换为 map
     *
     * @param json  json字符串
     * @param clazz 要转换的java类
     * @param <T>   要转换的java类
     * @return map
     */
    @SneakyThrows
    @Deprecated
    public static <T> Map<String, T> toMap(String json, Class<T> clazz) {
        Map<String, T> map = mapper.readValue(json, new TypeReference<Map<String, T>>() {
        });
        if (map == null || map.size() == 0) {
            return map;
        }

        Map<String, T> resMap = new HashMap<>();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            resMap.put(entry.getKey(), toObj(toStr(entry.getValue()), clazz));
        }
        return resMap;
    }

    /**
     * 格式化json字符串。增加制表符和回车，用于json字符串的打印
     *
     * @param obj java对象
     * @return 格式化的字符串，带回车
     */
    public static String formatJson(Object obj) {
        String json = JacksonUtil.toStr(obj);
        return CommonJsonUtil.formatJson(json);
    }

    /**
     * 格式化json字符串。增加制表符和回车，用于json字符串的打印
     *
     * @param json json字符串
     * @return 格式化的字符串，带回车
     */
    public static String formatJson(String json) {
        return CommonJsonUtil.formatJson(json);
    }

}
