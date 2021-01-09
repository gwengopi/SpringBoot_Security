package com.singtel.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/mgmt")
public class UserLoginController {

	@PreAuthorize("hasRole('user')")
	@GetMapping("/login")
	public String userLogin() {
		return "Success";
	}
	
	@PreAuthorize("hasRole('admin')")
	@GetMapping("/admin")
	public String adminLogin() {
		return "<h1>Admin login Success</h1>";
	}
	
	@PreAuthorize("hasRole('admin')")
	@PostMapping("/usercreate")
	public String creatUser() {
		return "<h1>User creation Success</h1>";
	}
}
