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

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by huangyinhuang on 3/8/2018.
 */
@Component
@ConfigurationProperties(prefix = "demo", ignoreUnknownFields = true)
public class AppProperties {

    private String hello;
    private Integer port;

    public String[] getStrings() {
        return strings;
    }

    public void setStrings(String[] strings) {
        this.strings = strings;
    }

    private String[] strings;

    public String getHello() {
        return hello;
    }

    public Integer getPort() {
        return port;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}
