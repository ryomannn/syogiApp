package com.example.demo.controller.contents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Profile;
import com.example.demo.service.ProfileService;

@Controller
public class ProfileInputController{

	@Autowired
	ProfileService profileService;

	@GetMapping("/profileInput")

	public String getProfileInput(@ModelAttribute Profile profile, Model model){

		return "/contents/profileInput";

	}

	@PostMapping("/profileInput")
	public String postProfileInput(@ModelAttribute Profile profile , Model model ) {

		System.out.println(profile);

		profileService.insertOne(profile);

		return "/contents/profile";

	}

}