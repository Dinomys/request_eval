package com.alight.request_eval.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public WebSecurityConfig(@Qualifier("dataSource") DataSource dataSource, PasswordEncoder passwordEncoder) {
        this.dataSource = dataSource;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("rodent@rodent.pl")
                .password(passwordEncoder.encode("grain"))
                .roles("ADMIN", "USER")
                .and()
                .withUser("user@rodent.pl")
                .password(passwordEncoder.encode("feed"))
                .roles("USER");
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT u.username, u.hash_password,1 FROM user u WHERE u.id=?")
                .authoritiesByUsernameQuery("SELECT u.id, r.role_name, 1 " +
                        "FROM user u " +
                        "INNER JOIN user_role ur ON ur.user_id = u.id " +
                        "INNER JOIN role r ON r.id = ur.roles_id " +
                        "WHERE u.username=?")
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole("USER")
                .antMatchers("/login").permitAll()
                .antMatchers("/administrator/**").hasRole("ADMIN")
                .antMatchers("/evaluator/**").hasRole("USER")
                .antMatchers("/reporting/***").hasRole("ADMIN")
                .anyRequest().permitAll()
                .and()
                .csrf().disable()
                .headers().frameOptions().disable().and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("lan")
                .passwordParameter("password")
                .loginProcessingUrl("/login-process")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error")
                .and()
                .logout().logoutSuccessUrl("/login");
    }
}
