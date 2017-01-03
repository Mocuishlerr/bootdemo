package com.xionglindong.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 自定义属性的加载
 * 
 * <p>目标文件application.properties中通过@Value("${属性名}")注解来加载对应的配置属性</p>
 * 
 * @author xld
 *
 */
@Component
public class BlogProperties {
	
	@Value("${com.xionglindong.name}")
	private String name;
	@Value("${com.xionglindong.type}")
	private String type;
	@Value("${com.xionglindong.desc}")
	private String desc;
	@Value("${com.xionglindong.value}")
	private String value;
	@Value("${com.xionglindong.num}")
	private int num;
	@Value("${com.xionglindong.randomTen}")
	private int randomTen;
	@Value("${com.xionglindong.randomTest}")
	private int randomTest;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getRandomTen() {
		return randomTen;
	}
	public void setRandomTen(int randomTen) {
		this.randomTen = randomTen;
	}
	public int getRandomTest() {
		return randomTest;
	}
	public void setRandomTest(int randomTest) {
		this.randomTest = randomTest;
	}
	

}
