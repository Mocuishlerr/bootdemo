package com.xionglindong;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.xionglindong.web.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class UserTest {
	
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception{
		mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
	}
	
	@Test
	public void testUserController() throws Exception{
		RequestBuilder request = null;
		
		//get查一下user列表 ，应为空
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
		
		//post提交一个user
		request = post("/users/").param("id", "1").param("name", "栋爷").param("age", "18");
		mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(content().string(equalTo("success")));
		
		///get获取user列表，应该有刚刚插入数据
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content()
				.string(equalTo("[{\"id\":1,\"name\":\"栋爷\",\"age\":18}]")));
		
		//put修改id为1的user
		request = put("/users/1").param("name", "你大爷").param("age", "16");
		mvc.perform(request).andExpect(content().string(equalTo("success")));
		
		//get一个id为1的user
		request = get("/users/1");
		mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(content().string(equalTo("{\"id\":1,\"name\":\"你大爷\",\"age\":16}")));
		
		//delete删除id为1的user
		request = delete("/users/1");
		mvc.perform(request).andDo(MockMvcResultHandlers.print()).andExpect(content().string(equalTo("success")));
		
		//get查一下user列表 ，应为空
		request = get("/users/");
		mvc.perform(request).andExpect(status().isOk()).andExpect(content().string(equalTo("[]")));
				
	}

	
	
	
	
	
	
}
