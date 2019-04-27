/**
 * 
 */
package com.sudhir.securityconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author sudhirk
 *
 */
@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("user1").password("123").roles("user")
		.and()
		.withUser("admin1").password("123")
		.roles("user","admin");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		.antMatchers("/student/**")
		.hasRole("user")
		.antMatchers("/greeting").authenticated()
		.antMatchers("/**").hasRole("admin")
		.and()
		.csrf().disable().headers().frameOptions().disable();
	}
	
}
