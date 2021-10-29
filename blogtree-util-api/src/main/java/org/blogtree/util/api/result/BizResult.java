package org.blogtree.util.api.result;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.blogtree.util.api.result.error.BaseError;
import org.blogtree.util.api.result.error.BizException;

import java.io.Serializable;

/**
 * 业务层 公用的返回值
 *
 * @author AlanGeeker
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BizResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 返回的业务对象
     * success=true时，为具体业务对象
     * success=false时，为null
     */
    private T data;

    /**
     * 错误码
     * success=true时，为null
     * success=false时，为具体错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String errorMsg;

    /**
     * 构造函数
     */
    public BizResult(boolean success, T data, String errorCode, String errorMsg) {
        this.success = success;
        this.data = data;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * 请求成功的返回值（data = null）
     */
    @SuppressWarnings("unchecked")
    private static BizResult EMPTY_SUCCESS_RES = new BizResult(true, null, null, null);

    /**
     * 请求成功的返回值（data = null）
     */
    public static BizResult buildSuccess() {
        return EMPTY_SUCCESS_RES;
    }

    /**
     * 请求成功的返回值（data != null）
     */
    public static <T> BizResult<T> buildSuccess(T data) {
        return new BizResult<>(true, data, null, null);
    }

    /**
     * 请求失败的返回值
     */
    public static BizResult buildError(BizException bizExc) {
        return new BizResult<>(false, null, bizExc.getErrorCode(), bizExc.getErrorMsg());
    }


    /**
     * 请求失败的返回值
     */
    public static BizResult buildError(BaseError baseError, Object... arguments) {
        return new BizResult<>(false, null,
                baseError.getErrorCode(),
                BaseError.buildErrorMsg(baseError.getErrorMsg(), arguments));
    }
}
