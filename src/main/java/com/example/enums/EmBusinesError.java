package com.example.enums;

import com.example.error.CommonError;

/**
 * 	枚举异常集
 */
public enum EmBusinesError implements CommonError{
    UNKNOWN_ERROR(500,"未知错误"),
    ;

    private int errCode;

    private String errMsg;

    private EmBusinesError(int errCode,String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
       this.errMsg = errMsg;
       return this;
    }
}
