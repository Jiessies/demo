package com.example.demo.config.druid;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by huangmingjie on 2018/5/10.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
  
        /*if("dev".equals(env)){ //如果需要在开发服中免登录
            http.authorizeRequests().antMatchers("*","filters").permitAll();
            http.csrf().disable();
            http.httpBasic();
            return;
        }*/
        
        http
                .authorizeRequests()
                .antMatchers("/test/**")
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/**").authenticated();
        http.csrf().disable();
        http.httpBasic();

    }
    
    /*@Autowired //也可以在application.yml文件中配置登录账号密码：security.user.name/password
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser("admin").password("admin").roles("USER");
    }*/
}
