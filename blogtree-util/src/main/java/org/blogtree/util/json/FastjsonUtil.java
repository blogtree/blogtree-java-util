package org.blogtree.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.blogtree.util.json.common.FormatJsonUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于 FastJson 的 JSON工具类
 * <p>
 * 备注：
 * 1. 如果不希望使用 FastJson，可以使用 JacksonUtil 或者 GsonUtil
 * <p>
 * 优点：
 * 1. 速度较快
 * <p>
 * 缺点：
 * 1. obj to string 是按照字母顺序输出的。通常对象的属性顺序，有一定含义。
 *
 * @author AlanGeeker
 * @see <a href="https://github.com/alibaba/fastjson">FastJson - GitHub</a>
 */
public class FastjsonUtil {

    /**
     * 将任意对象转换为String类型
     *
     * @param obj java对象
     * @return json字符串
     */
    public static String toStr(Object obj) {
        // toJSONString的时候，默认如果重用对象的话，会使用引用的方式进行引用对象
        // SerializerFeature.DisableCircularReferenceDetect 表示 禁用
        return JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.MapSortField);
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
        return JSON.parseObject(json, clazz);
    }

    /**
     * 将字符串转换为列表
     *
     * @param json  json字符串
     * @param clazz 要转换的java类
     * @param <T>   要转换的java类
     * @return 要转换的java对象列表
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

    /**
     * 将字符串转换为 map
     *
     * @param json json字符串
     * @return map
     */
    public static Map toMap(String json) {
        return JSON.parseObject(json, Map.class);
    }

    /**
     * 将字符串转换为 map
     *
     * @param json  json字符串
     * @param clazz 要转换的java类
     * @param <T>   要转换的java类
     * @return map
     */
    public static <T> Map<String, T> toMap(String json, Class<T> clazz) {
        Map<String, T> map = null;
        JSONObject jsonObject = JSON.parseObject(json);
        if (jsonObject == null || jsonObject.size() == 0) {
            map = new HashMap<>();
        } else {
            map = new HashMap<>(jsonObject.size() * 2);
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                String value = FastjsonUtil.toStr(entry.getValue());
                T t = JSON.parseObject(value, clazz);
                map.put(entry.getKey(), t);
            }
        }
        return map;
    }

    /**
     * 格式化json字符串。增加制表符和回车，用于json字符串的打印
     *
     * @param obj java对象
     * @return 格式化的字符串，带回车
     */
    public static String formatJson(Object obj) {
        String json = FastjsonUtil.toStr(obj);
        return FormatJsonUtil.formatJson(json);
    }

    /**
     * 格式化json字符串。增加制表符和回车，用于json字符串的打印
     *
     * @param json json字符串
     * @return 格式化的字符串，带回车
     */
    public static String formatJson(String json) {
        return FormatJsonUtil.formatJson(json);
    }


}
