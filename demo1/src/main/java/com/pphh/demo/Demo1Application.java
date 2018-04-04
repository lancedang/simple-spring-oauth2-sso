/*
 * Copyright 2018 peipeihh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * limitations under the License.
 */
package com.pphh.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * Created by huangyinhuang on 3/8/2018.
 */
@SpringBootApplication
@RestController
@EnableOAuth2Sso
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String sayHello() {

        return "hello, world. this is demo1.";
    }

    @RequestMapping(value = "/me", method = RequestMethod.GET)
    public Authentication getUserInfo(Authentication me){
        System.out.println("this interface is protected by spring security.");
        return me;
    }

    @RequestMapping(value = "/me2", method = RequestMethod.GET)
    public Principal getUserInfo(Principal me){
        System.out.println("this interface is protected by spring security.");
        return me;
    }


}
