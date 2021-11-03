package com.phamngoctruong.laptoppnt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class LoginController {
@GetMapping ("/dang-nhap")
public String loginUser(Model model) {
	return "login";
	
}
}
