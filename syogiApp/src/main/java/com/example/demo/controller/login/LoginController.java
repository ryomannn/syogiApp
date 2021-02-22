
package com.example.demo.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class LoginController{

	@Autowired
	RegisterController registerController;


	//ログイン画面移行

	@GetMapping("/login")
	public String getLogin(Model model) {

		System.out.println(registerController.registerForm2.getUserId());
		System.out.println(registerController.registerForm2.getUserName());

		return "login/login";

	}

	//profile画面に遷移

	@PostMapping("/login")
		public String postLogin(Model model) {

			return "redirect:/profile";
		}

}