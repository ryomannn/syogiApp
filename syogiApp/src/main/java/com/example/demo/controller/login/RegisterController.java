package com.example.demo.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.RegisterForm;
import com.example.demo.entity.User;
import com.example.demo.service.RegisterService;



@Controller

public class RegisterController{

	@Autowired
	public RegisterForm registerForm;

	@Autowired
	public RegisterForm registerForm2;

	@Autowired
	private RegisterService registerService;

	//新規登録画面に移動

	@GetMapping("/register")
	public String getRegister(@ModelAttribute RegisterForm form, Model model) {

		return "login/register";

	}

	//登録した情報をformに格納してログイン画面に遷移（エラーがあると新規登録画面に遷移）

	@PostMapping("/register")
	public String postRegister(@ModelAttribute @Validated  RegisterForm form, BindingResult bindingResult, Model model) {

		User user1 = new User();
		User user2 = new User();

		if(bindingResult.hasErrors()) {

			 //bindingResult.rejectValue("userName", "javax.validation.constraints.NotBlank.message.userName");

			return getRegister(form, model);

		}

		System.out.println(form);



		user1 = registerService.setUser(form);

		registerService.insert(user1);

		user2 = registerService.selectUser(user1);

		registerForm2 = registerService.input(user2);

		System.out.println(registerForm2.getUserId());
		System.out.println(registerForm2.getUserName());




		return "redirect:/login";
	}

}