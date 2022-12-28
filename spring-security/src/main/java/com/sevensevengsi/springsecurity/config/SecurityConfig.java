package com.sevensevengsi.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean(name = "pwdEncoder")
    public PasswordEncoder getPasswordEncoder() {
        DelegatingPasswordEncoder delPasswordEncoder = (DelegatingPasswordEncoder) PasswordEncoderFactories
                .createDelegatingPasswordEncoder();
        BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
        delPasswordEncoder.setDefaultPasswordEncoderForMatches(bcryptPasswordEncoder);
        return delPasswordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()


                .antMatchers("/page/owner").hasRole("OWNER")
                .antMatchers("/page/user").hasRole("USER")
                .antMatchers("/page/employee").hasRole("EMPLOYEE")
                .antMatchers("/page/customer").hasRole("CUSTOMER")
                .antMatchers("/page/manager").hasRole("MANAGER")
                .antMatchers("/page/admin").hasAnyRole("ADMIN","OWNER", "CUSTOMER", "MANAGER", "USER")

                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied");
    }
}


//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//        User.UserBuilder users = User.withDefaultPasswordEncoder();
//
//        auth.inMemoryAuthentication()
//                .withUser(users.username("franco").password("test123").roles("EMPLOYEE"))
//                .withUser(users.username("leo").password("test123").roles("MANAGER"))
//                .withUser(users.username("mark").password("test123").roles("ADMIN"))
//                .withUser(users.username("aldrin").password("test123").roles("EMPLOYEE","MANAGER","ADMIN"));
//    }