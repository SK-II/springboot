package com.example.error;

/**
 * 	异常数据结构接口
 */
public interface CommonError {
	
	/**
	 * 	error_code
	 * @return
	 */
    public int getErrCode();

    /**
     * 	error_msg
     * @return
     */
    public String getErrMsg();

    /**
     *	自定义error_msg
     * @param errMsg
     * @return
     */
    public CommonError setErrMsg(String errMsg);

}
