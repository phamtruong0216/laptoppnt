package com.phamngoctruong.laptoppnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
 @GetMapping("/gioi-thieu")
	public String aboutView() {
		return "about";
		
	}
}
