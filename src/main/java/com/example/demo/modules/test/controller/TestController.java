package com.example.demo.modules.test.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.modules.test.entity.City;
import com.example.demo.modules.test.entity.Country;
import com.example.demo.modules.test.service.TestService;
import com.example.demo.modules.test.vo.ApplicationConfigTestBean;

@Controller
@RequestMapping("/test")
public class TestController {
	@Value("${server.port}")
	private int port;
	
	@Value("${com.test.name}")
	private String name;
	
	@Value("${com.test.age}")
	private int age;
	
	@Value("${com.test.description}")
	private String description;
	
	@Value("${com.test.random}")
	private String random;
	
	private final static Logger LOGGER=LoggerFactory.getLogger(TestController.class);
	
	@Autowired
	private ApplicationConfigTestBean configTestBean;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/config")
	@ResponseBody
	public String getConfig(){
		StringBuffer sBuffer =new StringBuffer();
		sBuffer.append(configTestBean.getName())
		.append("----").append(configTestBean.getAge())
		.append("----").append(configTestBean.getDescription())		
		.append("----").append(configTestBean.getRandom())
		.append("</br>")
		.append(port)
		.append("----").append(name)
		.append("----").append(age)
		.append("----").append(description)
		.append("----random").append(random);
		return sBuffer.toString();

	}

	@RequestMapping("/logTest")
	@ResponseBody
	public String logTest(){
		LOGGER.trace("This is trace log.");
		LOGGER.debug("This is debug log.");
		LOGGER.info("This is info log.");
		LOGGER.warn("This is warn log.");
		LOGGER.error("This is error log.");
		
		return "This is log Test";
	}
	@RequestMapping("/country")
	@ResponseBody
	public Country getCountryByName(@RequestParam String countryName) {
		return testService.getCountryByName(countryName);
	}
	
	@RequestMapping("/country/{countryId}")
	@ResponseBody
	public Country getCountry(@PathVariable int countryId) {
		return testService.getCountry(countryId);
	}
	
	@RequestMapping("/cities/{countryId}")
	@ResponseBody
	public List<City> getCities(@PathVariable int countryId){
		return testService.getCities(countryId);
	}
	
	@PostMapping("/post")
	@ResponseBody
	public String postTest() {
		return "This is post test.";
	}
	
}
