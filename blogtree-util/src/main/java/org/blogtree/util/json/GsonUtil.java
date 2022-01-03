package org.blogtree.util.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 基于 Gson 的 JSON工具类
 * <p>
 * 优点：
 * 1. obj to string 是按照字母顺序输出的。通常对象的属性顺序，有一定含义。
 * <p>
 * 缺点：
 * 1. 速度相比 fastjson慢一点
 *
 * @author AlanGeeker
 * @see <a href="https://github.com/google/gson">gson - GitHub</a>
 * @see <a href="https://github.com/google/gson/blob/master/UserGuide.md">gson - UserGuide - GitHub</a>
 */
public class GsonUtil {

    private final static Gson gson = new Gson();
    ;

    /**
     * 将任意对象转换为String类型
     *
     * @param obj java对象
     * @return json字符串
     */
    public static String toStr(Object obj) {
        return gson.toJson(obj);
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
    public static <T> T toObj(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    /**
     * 将字符串转换为列表。
     * <p>
     * 注意：此方法中的范型T，并没有传递过去。方法会返回 List<LinkedTreeMap>
     * <p>
     * 原生方案：
     * List<UserPo> newList = mapper.readValue(json, new TypeReference<List<UserPo>>() {});
     *
     * @param json  json字符串
     * @param clazz 要转换的java类
     * @param <T>   要转换的java类
     * @return 要转换的java对象列表
     */
    @Deprecated
    public static <T> List<T> toList(String json, Class<T> clazz) {
        List<T> list = gson.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
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
     * <p>
     * 注意：此方法中的范型T，并没有传递过去。方法会返回 Map<String, LinkedTreeMap>
     * <p>
     * 原生方案：
     * List<UserPo> ps = gson.fromJson(str, new TypeToken<Map<String, Object>>(){}.getType());
     *
     * @param json json字符串
     * @return Map<String, Object>
     */
    @Deprecated
    public static Map<String, Object> toMap(String json) {
        return gson.fromJson(json, new TypeToken<Map<String, Object>>() {
        }.getType());
    }

    /**
     * 将字符串转换为 map
     *
     * @param json  json字符串
     * @param clazz 要转换的java类
     * @param <T>   要转换的java类
     * @return map
     */
    @Deprecated
    public static <T> Map<String, T> toMap(String json, Class<T> clazz) {
        Map<String, T> map = gson.fromJson(json, new TypeToken<Map<String, T>>() {
        }.getType());
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
        String json = GsonUtil.toStr(obj);
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
