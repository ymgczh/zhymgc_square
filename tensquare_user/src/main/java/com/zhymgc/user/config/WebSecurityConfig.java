package com.zhymgc.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Administrator on 2020-4-1.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //authorizeRequests 所有security全注解配置实现的开端，表示开始说明需要的权限
        //需要的权分为两部分，1 是拦截的路径，2 是访问该路径需要的权限
        //antMatchers 表示拦截的路径，permitAll表示全面同行，任何权限都可以访问
        //anyRequest任何的请求
        //authenticated认证后才能访问
        //and().csrf().disable()固定写法，让csrf拦截失效
        http.authorizeRequests().antMatchers("/**").permitAll().anyRequest()
                .authenticated().and().csrf().disable();
    }
}
