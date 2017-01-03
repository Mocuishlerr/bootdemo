package com.xionglindong.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.xionglindong.bean.lib.User;
import com.xionglindong.service.UserService;

@Controller
@RequestMapping("/user")
public class UserLibController {
	
	private Gson gson = new Gson();
	
	private Logger log = Logger.getLogger(UserLibController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/queryListBy")
	public ModelAndView queryListBy(User user,HttpServletRequest request,HttpServletResponse response) throws Exception{
		Map<String,Object> map = new HashMap<String,Object>();
		try {
			List<User> dataList = userService.queryListBy(user);
			map.put("dataList", dataList);
			response.getWriter().write(gson.toJson(map));
			return null;
		} catch (Exception e) {
			throw new Exception("发生异常");
		}
	}
	
	@RequestMapping("/query/{page}/{pageSize}")
	public ModelAndView query(@PathVariable Integer page, @PathVariable Integer pageSize,HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		try {
			if (page != null && pageSize != null) {
				PageHelper.startPage(page, pageSize);
			}
			List<User> dataList = userService.query();
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("dataList", dataList);
			map.put("aaa", request.getParameter("aaa"));
			response.getWriter().write(gson.toJson(map));
			return null;
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	

}
