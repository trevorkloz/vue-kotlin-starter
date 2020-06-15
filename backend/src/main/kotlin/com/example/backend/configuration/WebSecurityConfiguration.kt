package com.example.backend.configuration

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration
@EnableWebSecurity
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {
    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().httpBasic()
            .and().authorizeRequests()
                .antMatchers("/api/greeting").permitAll()
                .antMatchers("/api/order/**").permitAll()
                .antMatchers("/api/idiomatic/**").permitAll()
                .antMatchers("/api/secured").authenticated()
            .and().csrf().disable()
    }

}