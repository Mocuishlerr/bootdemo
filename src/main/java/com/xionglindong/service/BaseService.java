package com.xionglindong.service;

/**
 * 基础service
 * @author xld
 * @Date 2016-12-16 11:39:10
 *
 * @param <T>
 */
public interface BaseService<T> {

	public Integer add(T t);
	
	public Integer update(T t);
	
	public Integer delete(Long id);
}
