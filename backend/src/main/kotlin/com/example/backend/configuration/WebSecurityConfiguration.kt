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
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // No session will be created or used by spring security
            .and()
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/api/greeting").permitAll()
            .antMatchers("/api/order/**").permitAll() // allow every URI, that begins with '/api/user/'
            .antMatchers("/api/secured").authenticated() //.anyRequest().authenticated() // protect all other requests
            .and()
            .csrf().disable() // disable cross site request forgery, as we don't use cookies - otherwise ALL PUT, POST, DELETE will get HTTP 403!
    }

}