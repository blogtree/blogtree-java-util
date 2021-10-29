package org.blogtree.util.api.result.error;

import java.text.MessageFormat;

/**
 * 通用的ErrorCode枚举接口，定义code和msg方法
 *
 * @author AlanGeeker
 */
public interface BaseError {

    /**
     * 获取 错误码
     *
     * @return 错误码
     */
    String getErrorCode();

    /**
     * 获取 错误信息 或 错误信息模版
     *
     * @return 错误信息 或 错误信息模版
     */
    String getErrorMsg();

    /**
     * 根据入参，拼接错误信息
     *
     * @param errorMsg  错误信息 或 错误信息模版
     * @param arguments 待拼接的入参，可能为空
     * @return 拼接好的错误信息
     */
    static String buildErrorMsg(String errorMsg, Object... arguments) {
        if (arguments == null || arguments.length == 0) {
            return errorMsg;
        } else {
            return MessageFormat.format(errorMsg, arguments);
        }
    }
}
