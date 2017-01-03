package com.xionglindong.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xionglindong.bean.lib.User;

@Mapper
public interface UserMapper extends BaseMapper<User>{
	
//	@Select("select * from user")
//	List<User> findByList();
	
	@Select("select * from user where name=#{name}")
	User findByName(@Param("name") String name);
	
	@Insert("insert into user values(#{id},#{login_name},#{password},#{name},#{group},#{create_time},#{user_status})")
	int insert(@Param("id") Long id,@Param("loginName") String loginName,
			@Param("password") String password,@Param("name") String name,
			@Param("group") Integer group,@Param("createTime") Date createTime,
			@Param("userStatus") String userStatus);
	
	public List<User> queryListBy(User user);
	
	public List<User> query();

}
