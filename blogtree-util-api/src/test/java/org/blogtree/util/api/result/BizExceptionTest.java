package org.blogtree.util.api.result;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.util.api.result.error.BizException;
import org.blogtree.util.api.result.error.CommonError;
import org.junit.Test;

@Slf4j
public class BizExceptionTest {

    @Test
    public void test() {
        log.info("test-start");
        if (true) {
            throw new BizException(CommonError.ERROR);
        }
        log.info("test-end");
    }
}
