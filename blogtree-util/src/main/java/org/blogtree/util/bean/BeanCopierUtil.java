package org.blogtree.util.bean;

import lombok.extern.slf4j.Slf4j;
import net.sf.cglib.beans.BeanCopier;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 基于 BeanCopier 的类拷贝
 * <p>
 * 注意：
 * 1. BeanCopier是基于 public void setXXX() 方法来赋值的，
 * ___当遇到目标对象有lombok的注释 @Accessors(chain = true)时，会赋值失效，
 * ___这种情况，建议改用 BeanUtils.copyProperties。
 *
 * @author AlanGeeker
 * @see <a href="https://github.com/cglib/cglib">cglib - GitHub</a>
 * @see <a href="https://github.com/cglib/cglib/wiki">cglib - wiki - GitHub</a>
 * @see <a href="https://blog.csdn.net/u011195313/article/details/112555290">解决加了Lombok的@Accessors(chain=true)后无法使用cglib的beanCopier拷贝复制bean的问题</a>
 */
@Slf4j
public class BeanCopierUtil {

    /**
     * 存储BeanCopier的Map
     */
    private static Map<String, BeanCopier> beanCopierMap = new HashMap<>(1000);

    /**
     * 复制单个实体（不需要先创建target）
     *
     * @param source      原对象
     * @param targetClass 目标对象类型
     * @param <E>         目标对象类型
     * @return 目标对象
     */
    public static <E> E copy(Object source, Class<E> targetClass) {
        return BeanCopierUtil.copy(source, null, targetClass);
    }

    /**
     * 复制单个实体（需要先创建target）
     *
     * @param source 原对象
     * @param target 目标对象
     * @param <E>    目标对象类型
     */
    public static <E> void copy(Object source, E target) {
        BeanCopierUtil.copy(source, target, null);
    }

    /**
     * 复制一个列表
     *
     * @param sources     原对象列表
     * @param targetClass 目标对象类型
     * @param <E>         目标对象类型
     * @return 目标对象列表
     */
    public static <E> List<E> copyList(List sources, Class<E> targetClass) {
        if (sources == null || sources.size() == 0 || targetClass == null) {
            return null;
        } else {
            List<E> targets = new ArrayList<E>(sources.size());
            for (Object source : sources) {
                E target = BeanCopierUtil.copy(source, null, targetClass);
                targets.add(target);
            }
            return targets;
        }
    }

    /**
     * 私有方法：底层bean拷贝方法
     * 注：target 和 targetClass 有且只能有一个
     *
     * @param source      源对象
     * @param target      目标对象
     * @param targetClass 目标类型
     * @return 返回目标对象
     */
    private static <E> E copy(Object source, E target, Class<E> targetClass) {
        if (source == null || (target == null && targetClass == null)) {
            //入参不全，则直接退出
            return null;
        }
        if (target == null) {
            try {
                target = targetClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                log.error("BeanCopierUtil-copy-error,source={},targetClass={}", source, targetClass, e);
                return null;
            }
        }
        // 根据两个类名生成key
        String beanKey = generateKey(source.getClass(), target.getClass());
        BeanCopier copier = beanCopierMap.get(beanKey);
        if (copier == null) {
            copier = BeanCopier.create(source.getClass(), target.getClass(), false);
            beanCopierMap.put(beanKey, copier);
        }
        copier.copy(source, target, null);
        return target;
    }

    /**
     * 私有方法：根据类名，生成key
     *
     * @param sourceClass 源类
     * @param targetClass 目标类
     * @return map中的key
     */
    private static String generateKey(Class<?> sourceClass, Class<?> targetClass) {
        return MessageFormat.format("{0}_{1}", sourceClass.toString(), targetClass.toString());
    }
}
