package com.xionglindong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
//开启Spring Security的功能
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * authorizeRequests()定义哪些URL需要被保护、哪些不需要被保护。
	 * 例如以上代码指定了/和/home不需要任何认证就可以访问，
	 * 其他的路径都必须通过身份验证。
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
/*		http.authorizeRequests().antMatchers("/","/home","/user/queryListBy").permitAll()
		    .anyRequest().authenticated()
		    .and()
		    .formLogin()
		    .loginPage("/hello")
		    .permitAll()
		    .and()
		    .logout()
		    .permitAll();*/
	}
	
	@Autowired
	public void configGlobal(AuthenticationManagerBuilder builder) throws Exception{
/*		builder.inMemoryAuthentication()
		       .withUser("user").password("password")
		       .roles("USER");*/
	}

}
