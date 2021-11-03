package org.blogtree.util.api.page;


import lombok.extern.slf4j.Slf4j;
import org.blogtree.util.api.page.manager.BizManager;
import org.blogtree.util.api.page.vo.BizQueryDto;
import org.blogtree.util.api.page.vo.BizQueryVo;
import org.junit.Test;

@Slf4j
public class PageTest {

    @Test
    public void testQuery() {

        BizQueryDto dto = new BizQueryDto();
        dto.setId(1001L).setPageNo(1).setPageSize(10);

        BizManager bizManager = new BizManager();
        PageVo<BizQueryVo> page = bizManager.getPage(dto);
        log.info("page={}", page);
    }
}