package com.example.demo.openId_connect;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //aici se seteaza metoda de authentificare si setarea autorizarii la nivel de endpoint
        http.oauth2ResourceServer(
                //acestea sunt cheile folosite de server pt a semna token-ul - tu vezi doar public key-ul -
                //serverul semneaza cu cheia lui privata iar tu ca app client doar validezi cu public key-ul
                j -> j.jwt().jwkSetUri("http://localhost:9000/certs")
        );
        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }
}
