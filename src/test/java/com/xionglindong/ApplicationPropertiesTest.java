package com.xionglindong;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xionglindong.bean.BlogProperties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(BootDemoApplication.class)
public class ApplicationPropertiesTest {
	
	private static final Log log = LogFactory.getLog(ApplicationPropertiesTest.class);
	
	@Autowired
	private BlogProperties blogProperties;
	
	@Test
	public void getProperties() throws Exception{
		Assert.assertEquals(new String(blogProperties.getName().getBytes("ISO-8859-1"),"UTF-8"), "你爸爸");
//		Assert.assertEquals(blogProperties.getType(), "程序员");
		
		log.info(new String(blogProperties.getName().getBytes("ISO-8859-1"),"UTF-8"));
		log.info(new String(blogProperties.getType().getBytes("ISO-8859-1"),"UTF-8"));
		log.info(new String(blogProperties.getDesc().getBytes("ISO-8859-1"),"UTF-8"));
		log.info("随机数输出："+blogProperties.getValue());
		log.info("随机数子输出："+blogProperties.getNum());
		log.info("随机数输出："+blogProperties.getRandomTen());
		log.info("随机数输出："+blogProperties.getRandomTest());
	}

}
