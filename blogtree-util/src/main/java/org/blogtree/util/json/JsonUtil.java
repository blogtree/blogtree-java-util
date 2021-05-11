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
     */
    public static String toStr(Object obj) {
        // toJSONString的时候，默认如果重用对象的话，会使用引用的方式进行引用对象
        // SerializerFeature.DisableCircularReferenceDetect 表示 禁用
        return JSON.toJSONString(obj, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 将字符串按照指定类型，转换为对象
     * 注意：对象的属性，需要有set方法；否则，赋值不会成功
     */
    public static <T> T toObj(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    /**
     * 将字符串转换为列表
     */
    public static <T> List<T> toList(String json, Class<T> clazz) {
        return JSON.parseArray(json, clazz);
    }

    /**
     * 将对象转换为列表
     */
    public static <T> List<T> toList(Object obj, Class<T> clazz) {
        String json = JSON.toJSONString(obj);
        return JSON.parseArray(json, clazz);
    }

    /**
     * 将字符串转换为Map<String, Object>
     */
    public static Map toMap(String json) {
        return JSON.parseObject(json, Map.class);
    }

    /**
     * 将字符串转换为Map<String, Class>
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
     */
    public static String formatJson(Object obj) {
        String json = JsonUtil.toStr(obj);
        return JsonUtil.formatJson(json);
    }

    /**
     * 格式化json字符串。增加制表符和回车，用于json字符串的打印
     */
    public static String formatJson(String json) {
        if (null == json || "".equals(json)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
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
                    sb.append(current);
                    break;
                case '{':
                case '[':
                    sb.append(current);
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent++;
                        addIndentBlank(sb, indent);
                    }
                    break;
                case '}':
                case ']':
                    if (!isInQuotationMarks) {
                        sb.append('\n');
                        indent--;
                        addIndentBlank(sb, indent);
                    }
                    sb.append(current);
                    break;
                case ',':
                    sb.append(current);
                    if (last != '\\' && !isInQuotationMarks) {
                        sb.append('\n');
                        addIndentBlank(sb, indent);
                    }
                    break;
                default:
                    sb.append(current);
            }
        }
        return sb.toString();
    }

    /**
     * formatJson用到的私有方法：添加制表符
     */
    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }
}
