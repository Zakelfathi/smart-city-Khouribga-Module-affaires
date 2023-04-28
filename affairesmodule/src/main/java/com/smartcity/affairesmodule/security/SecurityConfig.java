package com.smartcity.affairesmodule.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user1").password("{noop}0000").roles("USER");
        auth.inMemoryAuthentication().withUser("user2").password("{noop}1234").roles("USER","EDITOR");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("USER","EDITOR","ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
        http.authorizeRequests().antMatchers("/editor/**").hasRole("EDITOR");
        http.authorizeRequests().anyRequest().permitAll();
    }

    @Autowired
    private LoginSuccessHandler loginSuccessHandlerr;
}
