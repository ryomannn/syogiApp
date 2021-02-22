package com.example.demo.repository.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.login.RegisterController;
import com.example.demo.entity.Profile;
import com.example.demo.entity.User;

@Repository
public class ProfileRepository {

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	RegisterController registerController;


	public int insertOne(Profile profile)throws DataAccessException{

	int rowNumber = jdbc.update("insert into syogi.profile (user_id, gender, hobby, history, grade, fav_battleType, comment) values(?,?,?,?,?,?,?)"
			,registerController.registerForm.getUserId(),profile.getGender(), profile.getHobby(), profile.getGrade(), profile.getHistory(), profile.getFav_battleType(), profile.getComment());

	return rowNumber;

	}

	public List<User> selectFriends()throws DataAccessException{

		List<Map<String, Object>>getList=jdbc.queryForList("select * from syogi.friend ");

		List<User> friendList = new ArrayList<>();

		for(Map<String, Object> map:getList) {

			User user = new User();

			user.setUserId((int)map.get("user_id"));

			user.setUserName((String)map.get("user_name"));

			friendList.add(user);

		}

		return  friendList;

	}

}


