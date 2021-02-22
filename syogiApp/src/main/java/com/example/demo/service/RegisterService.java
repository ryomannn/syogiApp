package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.RegisterForm;
import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;
import com.example.demo.repository.login.RegisterRepository;

@Service
public class RegisterService{

	@Autowired
	UserDao dao;

	@Autowired
	RegisterRepository registerRepository;

	@Autowired
	RegisterForm registerForm;


	public User setUser(RegisterForm form) {

		User user = new User();

		user.setPassword(form.getPassword());
		user.setUserAddress(form.getUserAddress());
		user.setUserName(form.getUserName());

		return user;
	}

	public boolean insert(User user) {


		int rowNumber = dao.insertOne(user);

		boolean result = false;

		if(rowNumber >0) {

			result=true;
		}


		if(result ==true) {
			System.out.println("insert成功");
		}
		else {
			System.out.println("insert失敗");
		}

		return result;

	}

	public RegisterForm input(User user) {

		registerForm.setUserId((int)user.getUserId());
		registerForm.setUserName((String)user.getUserName());

		return registerForm;

	}

	public User selectUser(User user) {

		return registerRepository.selectUser(user);
	}



}