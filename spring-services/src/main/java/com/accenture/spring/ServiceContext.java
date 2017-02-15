package com.accenture.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.accenture.dao.PersistenceContext;

@Configuration
@Import(PersistenceContext.class)
@ComponentScan(basePackages = "com.accenture.spring.service")
public class ServiceContext {

}
