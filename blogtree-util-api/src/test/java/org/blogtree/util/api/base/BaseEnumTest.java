package org.blogtree.util.api.base;

import org.blogtree.util.api.base.enums.UserTypeEnum;
import org.junit.Test;

public class BaseEnumTest {

    @Test
    public void isEqualByCode() {
        int codeAdmin = UserTypeEnum.Admin.getCode();
        int codeUser = UserTypeEnum.User.getCode();
        assert UserTypeEnum.Admin.isEqualByCode(codeAdmin);
        assert !UserTypeEnum.Admin.isEqualByCode(codeUser);
    }

    @Test
    public void isEqualByName() {
        assert UserTypeEnum.Admin.isEqualByName("Admin");
        assert !UserTypeEnum.Admin.isEqualByName("User");
    }

}