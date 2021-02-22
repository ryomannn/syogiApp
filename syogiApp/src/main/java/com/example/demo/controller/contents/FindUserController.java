package com.example.demo.controller.contents;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.service.FindUserService;

@Controller
public class FindUserController{
	@Autowired
	FindUserService findUserService;

	@GetMapping("/findUser")
	public String getFindUser(@ModelAttribute User user, Model model){

		return "/contents/findUser";

}

	@PostMapping("/findUser")
	public String postFindUser(@ModelAttribute User user ,Model model) {

		Profile profile = new Profile();

		int userId = user.getUserId();

		profile = findUserService.selectOne(userId);


		model.addAttribute("user_id", profile.getUser_id());
		model.addAttribute("gender", profile.getGender());
		model.addAttribute("grade", profile.getGrade());
		model.addAttribute("hisotry", profile.getHistory());
		model.addAttribute("hobby", profile.getHobby());
		model.addAttribute("fav_battleType", profile.getFav_battleType());
		model.addAttribute("comment", profile.getComment());



		return "/contents/friendProfile";

	}

	@PostMapping("/RegiterFriend")

	public String postRegisterFriend(Model model) {

		findUserService.followOne();

		return "redirect:/findUser";

	}

	@PostMapping("FriendList")
	public String postFriendList(Model model) {

		List<Profile> profileList = new ArrayList();

		 profileList = findUserService.UserList();

		return "/contents/friendList";


	}

}