package com.example.demo.Controller;

import com.example.demo.model.LoginModel;
import com.example.demo.service.Login01Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/login")
public class Login01Controller {
	@Autowired
	private Login01Service Login01Service;
	


	@PostMapping("/login")
	public List<LoginModel> login(@RequestBody LoginModel model) {
		System.out.println(Login01Service.login(model));
		return Login01Service.login(model);
	}



}