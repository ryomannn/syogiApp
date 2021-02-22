package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.login.RegisterController;
import com.example.demo.entity.PostContents;

@Repository
public class PostRepository{

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	RegisterController registerController;

	public int SignUpContents(PostContents postContents){

		System.out.println(postContents.getContents());

		int rowNumber = jdbc.update("insert into syogi.posts(user_id, contents) values(?,?)"
				,registerController.registerForm2.getUserId(), postContents.getContents());



		return rowNumber;
	}

	public List<PostContents> ShowContents() {

		List<Map<String, Object>> getList = jdbc.queryForList("select * from syogi.posts where user_id=?", registerController.registerForm2.getUserId());

		List<PostContents> postsList = new ArrayList<>();

		for(Map<String, Object> map:getList) {

			PostContents postContents = new PostContents();

			postContents.setContents((String)map.get("contents"));
			//postContents.setCreated_at((Date)map.get("created_at"));

			postsList.add(postContents);
			System.out.println(postsList);

		}

		return postsList;

	}
}