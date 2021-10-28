package org.blogtree.util.api.result;

import lombok.extern.slf4j.Slf4j;
import org.blogtree.util.api.result.error.BizException;
import org.blogtree.util.api.result.error.CommonError;
import org.blogtree.util.api.vo.UserVo;
import org.junit.Test;

@Slf4j
public class BizResultTest {

    @Test
    public void buildSuccess() {
        BizResult bizResult1 = BizResult.buildSuccess();
        log.info("bizResult1 = {}", bizResult1);

        UserVo userVo = new UserVo(1L, "UserName");
        BizResult bizResult2 = BizResult.buildSuccess(userVo);
        log.info("bizResult2 = {}", bizResult2);

        BizResult bizResult3 = BizResult.buildError(CommonError.ERROR);
        log.info("bizResult3 = {}", bizResult3);

        BizResult bizResult4 = BizResult.buildError(CommonError.PARAM_NOT_NULL, "userId");
        log.info("bizResult4 = {}", bizResult4);

        BizException bizException1 = new BizException(CommonError.ERROR);
        BizResult bizResult5 = BizResult.buildError(bizException1);
        log.info("bizResult5 = {}", bizResult5);

        BizException bizException2 = new BizException(CommonError.PARAM_NOT_NULL, "userId");
        BizResult bizResult6 = BizResult.buildError(bizException2);
        log.info("bizResult6 = {}", bizResult6);
    }
}