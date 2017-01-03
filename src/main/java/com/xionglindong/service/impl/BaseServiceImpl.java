package com.xionglindong.service.impl;

import com.xionglindong.mapper.BaseMapper;
import com.xionglindong.service.BaseService;

/**
 * 基础service实现类
 * @author xld
 * @Date 2016-12-16 11:39:17
 *
 * @param <T>
 */
public abstract class BaseServiceImpl<T> implements BaseService<T> {
	
	public abstract BaseMapper<T> getMapper();

	@Override
	public Integer add(T t) {
		// TODO Auto-generated method stub
		return getMapper().add(t);
	}

	@Override
	public Integer update(T t) {
		// TODO Auto-generated method stub
		return getMapper().update(t);
	}

	@Override
	public Integer delete(Long id) {
		// TODO Auto-generated method stub
		return getMapper().delete(id);
	}

}
