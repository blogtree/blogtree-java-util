package org.blogtree.util.bean.reflect.copy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * 反射工具类
 *
 * @author AlanGeeker
 */
public class ReflectUtil {

    /**
     * 获得基类的第1个参数类型
     *
     * @param clazz 子类类型
     */
    public static Class getClassGenricType(final Class clazz) {
        return getClassGenricType(clazz, 0);
    }

    /**
     * 根据索引，获得基类的某个参数类型
     *
     * @param clazz 子类类型
     * @param index 索引(从0开始)
     */
    public static Class getClassGenricType(final Class clazz, final int index) {
        Type genType = clazz.getGenericSuperclass();
        if (!(genType instanceof ParameterizedType)) {
            return Object.class;
        }
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        if (index >= params.length || index < 0) {
            return Object.class;
        }
        if (!(params[index] instanceof Class)) {
            return Object.class;
        }
        return (Class) params[index];
    }

    /**
     * 获取各字段的注解
     *
     * @param clz     包含字段的类
     * @param annoClz 注解类
     */
    public static Map<String, Object> getFields(final Class clz, final Class annoClz) {
        Field[] fields = clz.getDeclaredFields();
        Map<String, Object> fieldAnnoMap = new HashMap();
        for (Field field : fields) {
            // 判断是否存在入参中的注解类
            Object fieldAnno = field.getAnnotation(annoClz);
            if (fieldAnno == null) {
                fieldAnnoMap.put(field.getName(), null);
            } else {// 如果存在则获取这个映射类
                fieldAnnoMap.put(field.getName(), fieldAnno);
            }
        }
        return fieldAnnoMap;
    }

    /**
     * 得到类上面的注解信息
     *
     * @param scannerClass
     * @param allowInjectClass
     * @return
     */
    public static <A extends Annotation> A getClassAnnotation(Class<?> scannerClass, Class<A> allowInjectClass) {
        if (!scannerClass.isAnnotationPresent(allowInjectClass)) {
            return null;
        }
        return scannerClass.getAnnotation(allowInjectClass);
    }

}
