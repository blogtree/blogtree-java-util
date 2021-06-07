package org.blogtree.util.base;

import org.junit.Test;

import static org.junit.Assert.*;

public class BaseEnumTest extends BaseTest {

    @Test
    public void isEqual() {
        Integer type = 1;
        log.info("type1.isEqual {}", TestTypeEnum.type1.isEqual(type));
        log.info("type2.isEqual {}", TestTypeEnum.type2.isEqual(type));
        log.info("type1.isNotEqual {}", TestTypeEnum.type1.isNotEqual(type));
        log.info("type2.isNotEqual {}", TestTypeEnum.type2.isNotEqual(type));
    }
}