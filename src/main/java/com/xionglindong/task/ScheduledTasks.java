package com.xionglindong.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 创建定时任务 test
 */
@Component
public class ScheduledTasks {
	
//	@Scheduled(fixedRate = 5000) ：上一次开始执行时间点之后5秒再执行
//	@Scheduled(fixedDelay = 5000) ：上一次执行完毕时间点之后5秒再执行
//	@Scheduled(initialDelay=1000, fixedRate=5000) ：第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
//	@Scheduled(cron="*/5 * * * * *") ：通过cron表达式定义规则
	private static final Logger log = Logger.getLogger(ScheduledTasks.class);
	
	//5秒输出一下当前时间
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/*@Scheduled(fixedRate = 50000000)
	public void showCurrentTime(){
		log.info("===============现在时间："+sdf.format(new Date())+"===================");
	}*/

}
