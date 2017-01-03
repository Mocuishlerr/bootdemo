package com.xionglindong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xionglindong.bean.lib.User;
import com.xionglindong.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(BootDemoApplication.class)
public class LibUserApplicationTest {
	
	private static final Log log = LogFactory.getLog(LibUserApplicationTest.class);

	@Autowired
	private UserMapper userMapper;
	
	@Test
	@Rollback
	public void testFindByName() throws Exception{
		User user = userMapper.findByName("admin");
		log.info(user.getName()+","+user.getLoginName()+","+user.getGroup()+","+user.getCreateTime());
	}
}
