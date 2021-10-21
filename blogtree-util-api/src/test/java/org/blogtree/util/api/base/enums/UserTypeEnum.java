package org.blogtree.util.api.base.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.blogtree.util.api.base.BaseEnum;

@Getter
@AllArgsConstructor
public enum UserTypeEnum implements BaseEnum {

    Admin(1, "Admin"),
    User(2, "User"),
    //
    ;

    Integer code;
    String text;

}
