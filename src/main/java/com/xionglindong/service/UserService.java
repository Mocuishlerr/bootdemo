package com.xionglindong.service;

import java.util.List;

import com.xionglindong.bean.lib.User;


public interface UserService extends BaseService<User>{
	
	public List<User> queryListBy(User user);
	
	public List<User> query();

}
