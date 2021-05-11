package org.blogtree.util.base;

import org.blogtree.util.json.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试类的父类，可以提供log、print、print2Json等基础方法
 */
public class BaseTest {

    protected Logger log = LoggerFactory.getLogger(BaseTest.class);

    protected void print(Object obj) {
        log.info("obj={}", obj);
    }

    protected void print2Json(Object obj) {
        log.info("obj={}", JsonUtil.formatJson(obj));
    }
}
