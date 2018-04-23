package com.example.wordladder_hwk2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //inMemoryAuthentication 从内存中获取
        auth.inMemoryAuthentication().passwordEncoder(new MyPasswordEncoder()).withUser("admin").password("123").roles("ADMIN")
                .and().withUser("user1").password("user1").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()//配置安全策略
                .antMatchers("/","/hello").permitAll()//定义/请求不需要验证
                .anyRequest().authenticated()//其余的所有请求都需要验证
                .and()
                .logout()
                .permitAll()//定义logout不需要验证
                .and()
                .formLogin();//使用form表单登录
    }
}
