package com.hsl.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by huangshaolong on 2017/8/30.
 *
 */
@Configuration
@ComponentScan(basePackages = {"com.hsl.test"},
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
    })
public class RootConfig {

}

