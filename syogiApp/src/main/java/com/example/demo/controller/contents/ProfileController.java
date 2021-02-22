package com.example.demo.controller.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.service.ProfileService;

@Controller
public class ProfileController{

	@Autowired
	ProfileService profileService;


	@GetMapping("/profile")
	public String getProfile(Model model){

		return "/contents/profile";

	}

	@GetMapping("/friendList")
	public String getFriendList(Model model){

		profileService.selectFriends();

		return "/contents/friendList";

	}


}