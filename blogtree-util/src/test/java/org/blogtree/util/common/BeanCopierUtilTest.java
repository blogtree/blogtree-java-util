package org.blogtree.util.common;

import org.blogtree.util.base.BaseTest;
import org.blogtree.util.bean.BeanCopierUtil;
import org.blogtree.util.vo.UserPo;
import org.blogtree.util.vo.UserVo;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BeanCopierUtilTest extends BaseTest {

    @Test
    public void copy() {
        UserPo userPo = new UserPo(1L, "Michael", 20);
        UserVo userVo = BeanCopierUtil.copy(userPo, UserVo.class);
        print(userVo);
        print2Json(userVo);
    }

    @Test
    public void copy1() {
        UserPo userPo = new UserPo(1L, "Michael", 20);
        UserVo userVo = new UserVo();
        BeanCopierUtil.copy(userPo, userVo);
        print(userVo);
        print2Json(userVo);
    }


    @Test
    public void copy2() {
        UserPo userPo = new UserPo(1L, "Michael", 20);
        UserVo userVo = new UserVo(2L, "Ada");
        BeanCopierUtil.copy(userPo, userVo);
        print(userVo);
        print2Json(userVo);
    }


    @Test
    public void copyList() {
        List<UserPo> poList = new ArrayList<>();
        poList.add(new UserPo(1L, "Michael", 20));
        poList.add(new UserPo(2L, "Ada", 22));
        poList.add(new UserPo(3L, "Leon", 23));

        List<UserVo> voList = BeanCopierUtil.copyList(poList, UserVo.class);
        print(voList);
        print2Json(voList);
    }

    @Test
    public void deepCopyList() {
    }
}