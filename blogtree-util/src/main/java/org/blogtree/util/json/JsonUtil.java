package org.blogtree.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSON字符串的工具类
 */
public class JsonUtil {

    /**
     * 将任意对象转换为String类型
     *
     * @param obj java对象
     * @return json字符串
     */
    public static String toStr(Object obj) {
        // toJSONString的时候，默认如果重用对象的话，会使用引用的方式进行引用对象
        // SerializerFeature.DisableCircularReferenceDetect 表示 禁用
        return JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect);
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
            map = new HashMap<>(jsonObject.size());
            for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
                map.put(entry.getKey(), (T) entry.getValue());
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
        String json = JsonUtil.toStr(obj);
        return JsonUtil.formatJson(json);
    }

    /**
     * 格式化json字符串。增加制表符和回车，用于json字符串的打印
     *
     * @param json json字符串
     * @return 格式化的字符串，带回车
     */
    public static String formatJson(String json) {
        if (null == json || "".equals(json)) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        char last = '\0';
        char current = '\0';
        int indent = 0;
        boolean isInQuotationMarks = false;
        for (int i = 0; i < json.length(); i++) {
            last = current;
            current = json.charAt(i);
            switch (current) {
                case '"':
                    if (last != '\\') {
                        isInQuotationMarks = !isInQuotationMarks;
                    }
                    builder.append(current);
                    break;
                case '{':
                case '[':
                    builder.append(current);
                    if (!isInQuotationMarks) {
                        builder.append('\n');
                        indent++;
                        addIndentBlank(builder, indent);
                    }
                    break;
                case '}':
                case ']':
                    if (!isInQuotationMarks) {
                        builder.append('\n');
                        indent--;
                        addIndentBlank(builder, indent);
                    }
                    builder.append(current);
                    break;
                case ',':
                    builder.append(current);
                    if (last != '\\' && !isInQuotationMarks) {
                        builder.append('\n');
                        addIndentBlank(builder, indent);
                    }
                    break;
                default:
                    builder.append(current);
            }
        }
        return builder.toString();
    }

    /**
     * formatJson用到的私有方法：添加制表符
     *
     * @param builder 要拼接的字符串
     * @param indent  缩进长度
     */
    private static void addIndentBlank(StringBuilder builder, int indent) {
        for (int i = 0; i < indent; i++) {
            builder.append('\t');
        }
    }
}
