package com.example.advice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.enums.EmBusinesError;
import com.example.exception.BusinessException;
import com.example.result.ResponseResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice //全局异常类
public class MyExceptionHandler {
	
	public static final String ERROR_VIEW = "error";
	
	public static final String ERROR_CODE = "errCode";
	
	public static final String ERROR_MSG = "errMsg";
	
	@ResponseBody
	@ExceptionHandler(value = Exception.class)  //拦截异常类型
	public Object errorHandler(HttpServletRequest request,HttpServletResponse response,
			Exception e) throws Exception {
		//异常
		e.printStackTrace();
		
		log.error(" url: " + request.getRequestURL() + " exception: " + e.toString());
		
		if(isAjax(request)) { //ajax
			if(e instanceof BusinessException) { //自定义异常
				BusinessException businessException = (BusinessException)e;
				return ResponseResult.resultError(businessException.getErrCode(), businessException.getErrMsg());
			}else { //未知异常
				return ResponseResult.resultError(EmBusinesError.UNKNOWN_ERROR.getErrCode(),EmBusinesError.UNKNOWN_ERROR.getErrMsg());
			}
		}else { //web
			ModelAndView view = new ModelAndView();
			if(e instanceof BusinessException) { //自定义异常
				BusinessException businessException = (BusinessException)e;
				view.addObject("url", request.getContextPath());
				view.addObject("exception", e);
				view.addObject(ERROR_CODE, businessException.getErrCode());
				view.addObject(ERROR_MSG, businessException.getErrMsg());
			}else { //未知异常
				view.addObject("url", request.getContextPath());
				view.addObject("exception", e);
				view.addObject(ERROR_CODE, EmBusinesError.UNKNOWN_ERROR.getErrCode());
				view.addObject(ERROR_MSG, EmBusinesError.UNKNOWN_ERROR.getErrMsg());
			}
			view.setViewName(ERROR_VIEW);
			return view;
		}
		
	}
	
	
	/**
	 * 	判断请求方式 WEB || AJAX
	 * @param httpRequest
	 * @return
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return (httpRequest.getHeader("X-Requested-With") != null  
					&& "XMLHttpRequest".equals( httpRequest.getHeader("X-Requested-With").toString()));
	}
	
	
	
}
