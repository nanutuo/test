package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController1 {
@RequestMapping("/test/info")
@ResponseBody
public String getInfo(){
	return "This is spring boot demo app.";
}
}
