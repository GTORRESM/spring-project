package com.accenture.spring.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InitController {

	private static Logger LOGGER = LoggerFactory.getLogger(BookController.class);
	private String indexPage = "index";
	
	@GetMapping	
	@RequestMapping(value = {"/"})
	public String init() {
		LOGGER.info("Iniciando.");
		
		return indexPage;

	}
}
