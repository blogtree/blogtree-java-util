package org.blogtree.util.api.result.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 通用的业务异常枚举。
 * 实际业务系统，可参考此类，自行继承BaseError类。
 *
 * @author AlanGeeker
 */
@Getter
@AllArgsConstructor
public enum CommonError implements BaseError {

    // ===== ===== ===== ===== 通用 - 入参校验异常 ===== ===== ===== =====
    PARAM_NOT_NULL("PARAM_NOT_NULL", "{0}不能为NULL"),
    STRING_NOT_EMPTY("STRING_NOT_EMPTY", "{0}不能为NULL或空字符串"),
    NUMBER_NOT_EMPTY("NUMBER_NOT_EMPTY", "{0}不能为NULL或0"),
    DATE_NOT_EMPTY("DATE_NOT_EMPTY", "{0}不能为NULL或0"),
    LIST_NOT_EMPTY("LIST_NOT_EMPTY", "{0}不能为NULL或空数组"),
    NUMBER_NOT_LTE("NUMBER_NOT_LTE", "{0}不能大于{1}"),

    // ===== ===== ===== ===== 通用 - 数据库异常 ===== ===== ===== =====
    DB_NOT_EXIST("DB_NOT_EXIST", "数据不存在"),

    // ===== ===== ===== ===== 终极异常 ===== ===== ===== =====
    ERROR("ERROR", "系统异常"),

    // 占位
    ;

    private String errorCode;
    private String errorMsg;
}
