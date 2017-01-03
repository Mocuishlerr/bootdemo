package com.xionglindong.mapper;

/**
 * 基础Mapper
 * @author xld
 * @Date 2016-12-16 11:39:00
 *
 * @param <T>
 */
public interface BaseMapper<T> {
	
	public Integer add(T t);
	
	public Integer update(T t);
	
	public Integer delete(Long id);

}
