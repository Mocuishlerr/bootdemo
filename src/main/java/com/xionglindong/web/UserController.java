package com.xionglindong.web;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xionglindong.bean.User;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {
	
	static Map<Long,User> users = Collections.synchronizedMap(new HashMap<Long,User>());
	
//	@ApiOperation(value="获取用户列表",notes="")
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<User> getUserList(){
		List<User> listData = new ArrayList<User>(users.values());
		return listData;
	}
	
//	@ApiOperation(value="创建用户",notes="根据user对象创建用户")
//	//@ApiImplicitParam给参数增加说明
//	@ApiImplicitParam(name="user",value="用户实体bean",required=true,dataType="User")
	@RequestMapping(value="/",method=RequestMethod.POST)
	public String postUser(@ModelAttribute User user){
		//除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
		users.put(user.getId(), user);
		return "success";
	}
	
//	@ApiOperation(value="获取用户详细信息",notes="根据id来获取指定对象")
//	@ApiImplicitParam(name="id",value="用户id",required=true,dataType="Long")
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public User getUser(@PathVariable Long id){
		//url中的id课通过@PathVariable绑定到函数的参数中
		return users.get(id);
	}
	
//	@ApiOperation(value="更新用户详细信息",notes="根据指定id进行修改")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name="id",value="用户id",required=true,dataType="Long"),
//		@ApiImplicitParam(name="user",value="用户实体bean",required=true,dataType="User")
//	})
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public String putUser(@PathVariable Long id,@ModelAttribute User user){
		User u=users.get(id);
		u.setName(user.getName());
		u.setAge(user.getAge());
		users.put(id, u);
		return "success";
	}

//	@ApiOperation(value="删除用户",notes="根据id删除指定的user")
//	@ApiImplicitParam(name="id",value="用户id",required=true,dataType="Long")
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public String deleteUser(@PathVariable Long id) {
		// 处理"/users/{id}"的DELETE请求，用来删除User
		users.remove(id);
		return "success";
	}

}
