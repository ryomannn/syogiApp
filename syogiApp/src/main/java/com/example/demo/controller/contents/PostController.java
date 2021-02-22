package com.example.demo.controller.contents;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.controller.login.RegisterController;
import com.example.demo.entity.PostContents;
import com.example.demo.service.PostService;

@Controller
public class PostController{

	@Autowired
	PostService postService;

	@Autowired
	RegisterController registerController;

	@GetMapping("/postInput")
	public String getPostInput(@ModelAttribute PostContents contents, Model model) {

		return "/contents/postInput";
	}
	@PostMapping("/post")
	public String postPostInput(@ModelAttribute PostContents contents, Model model) {

		List<PostContents> postsList = new ArrayList<>();

		System.out.println(contents);

		postService.SignUpContents(contents);

		postsList = postService.ShowContents();



		model.addAttribute("postContents", postsList);


		return "/contents/postHistory";
	}

}