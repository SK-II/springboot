package com.example.exception;

import com.example.error.CommonError;

/**
 * 	自定义业务异常
 */
public class BusinessException extends Exception implements CommonError {

    
	private static final long serialVersionUID = 1L;
	
	private CommonError commonError;

    /**
     * BusinessException构造业务异常
     */
    public BusinessException(CommonError commonError) {
        super();
        this.commonError = commonError;
    }

    /**
     *	自定义errmsg构造业务异常
     */
    public BusinessException(CommonError commonError,String errMsg) {
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);
    }

    
    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
