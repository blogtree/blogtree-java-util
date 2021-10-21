package org.blogtree.util.api.common;

import org.blogtree.util.api.base.enums.UserTypeEnum;
import org.junit.Test;

public class EnumUtilTest {

    @Test
    public void getEnumByCode() {
        int code = UserTypeEnum.Admin.getCode();
        assert code == EnumUtil.getEnumByCode(code, UserTypeEnum.values()).getCode();
    }

    @Test
    public void contain() {
        int code = UserTypeEnum.Admin.getCode();
        assert EnumUtil.contain(code, UserTypeEnum.values());
        assert !EnumUtil.contain(3, UserTypeEnum.values());
    }
}