package com.xionglindong.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.xionglindong.exception.MyException;

@RestController
public class HelloController {
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() throws Exception{
		throw new Exception("温馨提示：您访问的地址不存在！");
	}
	
	@RequestMapping("/json")
	public String json() throws MyException{
		throw new MyException("你麻痹，又出错啦！");
	}
	
	@RequestMapping("/login")
	public String login() throws Exception{
		return "login";
	}
	
}
