package org.blogtree.util.api.result.error;

import lombok.Getter;
import lombok.ToString;

/**
 * 业务异常类
 *
 * @author AlanGeeker
 */
@Getter
@ToString
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -1L;

    private String errorCode;
    private String errorMsg;

    /**
     * 常用
     * 从项目规范来说，应该全部为错误码枚举
     * 错误枚举类，应该使用 或 继承 BaseError
     */
    public BizException(BaseError baseError, Object... arguments) {
        this.errorCode = baseError.getErrorCode();
        this.errorMsg = BaseError.buildErrorMsg(baseError.getErrorMsg(), arguments);
    }

    /**
     * 优化处理：
     * fillInStackTrace内部 调用native的fillInStackTrace()方法去爬取线程堆栈信息，为运行时栈做一份快照，这一部分开销很大
     * 由于是自定义业务异常，无需再查询堆栈信息，所有直接返回this即可
     */
    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
