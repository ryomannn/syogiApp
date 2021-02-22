package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.PostContents;
import com.example.demo.repository.PostRepository;

@Service
public class PostService{

	@Autowired
	PostRepository postRepository;

	public void SignUpContents(PostContents postContents) {


		int number = postRepository.SignUpContents(postContents);

		if(number > 0) {
			System.out.println("投稿内容登録成功");
		}
		else {
			System.out.println("投稿登録失敗");

		}
	}

	public List<PostContents> ShowContents() {

		List<PostContents> postsList = new ArrayList<>();

		postsList = postRepository.ShowContents();

		return postsList;
	}

}