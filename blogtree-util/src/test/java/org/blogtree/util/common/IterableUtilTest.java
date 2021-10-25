package org.blogtree.util.common;

import org.blogtree.util.base.BaseTest;
import org.blogtree.util.vo.UserVo;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class IterableUtilTest extends BaseTest {

    @Test
    public void forEach() {
        List<UserVo> list = new LinkedList<>();
        list.add(new UserVo(11L, "User11"));
        list.add(new UserVo(12L, "User12"));
        list.add(new UserVo(13L, "User13"));
        list.add(new UserVo(14L, "User14"));
        list.add(new UserVo(15L, "User15"));

        IterableUtil.forEach(list, (index, userVo) -> {
            log.info("index = {}, userVo = {}", index, userVo);
        });
    }
}