package com.xionglindong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xionglindong.bean.lib.User;
import com.xionglindong.mapper.BaseMapper;
import com.xionglindong.mapper.UserMapper;
import com.xionglindong.service.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public BaseMapper<User> getMapper() {
		return userMapper;
	}
	
	public List<User> queryListBy(User user){
		return userMapper.queryListBy(user);
	}
	
	public List<User> query(){
		return userMapper.query();
	}


}
