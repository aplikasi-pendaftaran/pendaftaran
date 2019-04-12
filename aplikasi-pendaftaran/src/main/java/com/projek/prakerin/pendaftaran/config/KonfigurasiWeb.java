package com.projek.prakerin.pendaftaran.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class KonfigurasiWeb extends WebMvcConfigurerAdapter {
    
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/templates/index").setViewName("/index");
        registry.addViewController("/templates/tatacara").setViewName("/tatacara");


    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ThymeleafLayoutInterceptor());
    }
 }
