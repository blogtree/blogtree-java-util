package org.blogtree.util.util;

import org.blogtree.util.api.util.EnumUtil;
import org.blogtree.util.base.BaseTest;
import org.blogtree.util.base.TestTypeEnum;
import org.junit.Test;

public class EnumUtilTest extends BaseTest {

    @Test
    public void getEnumByValue() {
        TestTypeEnum typeEnum = EnumUtil.getEnumByValue(2, TestTypeEnum.values());
        log.info("typeEnum={}", typeEnum);
    }

    @Test
    public void getTextByValue() {
        String text = EnumUtil.getTextByValue(2, TestTypeEnum.values());
        log.info("text={}", text);
    }

    @Test
    public void isInclude() {
        Integer value1 = 1;
        log.info("contain value1: {}", EnumUtil.contain(value1, TestTypeEnum.values()));
        Integer value5 = 5;
        log.info("contain value5: {}", EnumUtil.contain(value5, TestTypeEnum.values()));
    }
}