package com.xionglindong.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.xionglindong.bean.ErrorInfo;

/**
 * 统一异常处理
 * <p>创建全局异常处理 使用@ControllerAdvice定义统一的异常处理类</p>
 * 
 * <p>
 *   @ExceptionHandler用来定义函数针对的异常类型，
 *   最后将Exception对象和请求URL映射到error.html中
 * </p>
 * @author xld
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	public static final String DEAFAUL_ERROR_VIEW = "error";
	
	@ExceptionHandler(value = Exception.class)
	public ModelAndView deafulErrorHandler(HttpServletRequest request, Exception e) 
			throws Exception{
		ModelAndView view = new ModelAndView();
		view.addObject("exception",e);
		view.addObject("url",request.getRequestURI());
		view.setViewName(DEAFAUL_ERROR_VIEW);
		return view;
	}
	
	//返回json格式的数据错误
	@ExceptionHandler(value = MyException.class)
	@ResponseBody
	public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MyException e) 
			throws Exception{
		ErrorInfo<String> info = new ErrorInfo<>();
		info.setMessage(e.getMessage());
		info.setCode(ErrorInfo.IS_ERROR);
		info.setUrl(request.getRequestURI().toString());
		info.setDate("SOME DATA");
		return info;
	}
	
	
	
	

}
