package org.blogtree.util.api.page.manager;

import org.blogtree.util.api.page.PageVo;
import org.blogtree.util.api.page.vo.BizQueryDto;
import org.blogtree.util.api.page.vo.BizQueryVo;

import java.util.ArrayList;
import java.util.List;

public class BizManager {

    public PageVo<BizQueryVo> getPage(BizQueryDto dto) {
        // query count
        int count = 100;
        // if count > 0, query list
        List<BizQueryVo> list = new ArrayList<>();
        return new PageVo<>(count, list);
    }
}
