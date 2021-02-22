package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.login.RegisterController;
import com.example.demo.entity.Profile;





@Repository
public class FindUserRepository {

	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	RegisterController registerController;

	Profile profile = new Profile();

	//ユーザー検索
	public Profile selectOne(int userId)throws DataAccessException{

		Map<String,Object> map = jdbc.queryForMap("select * from syogi.profile where user_id=?", userId);



		profile.setUser_id((int)map.get("user_id"));
		profile.setGender((int)map.get("gender"));
		profile.setHobby(String.valueOf(map.get("hobby")));
		profile.setGrade(String.valueOf(map.get("grade")));
		profile.setHistory((int)map.get("history"));
		profile.setFav_battleType(String.valueOf(map.get("fav_battleType")));
		profile.setComment(String.valueOf(map.get("comment")));

		System.out.println(profile);

		return profile;

	}


	//友達登録
	public int followOne()throws DataAccessException{

		int rowNumber = jdbc.update("insert into syogi.friends (follow_id, follower_id) values(?, ?)", registerController.registerForm.getUserId(), profile.getUser_id());//引数に自分のIDと友達追加するIDを書く。

		return rowNumber;

	}

	//友達一覧表示
	public List UserList()throws DataAccessException{

		List profileList = new ArrayList();

	  //=	("select"
			// 	+" fr.follow_id ,fr.follower_id"
			 //	+" from syogi.friends as fr"
			 //	+" where user_id = ?  and fr.follow_id in(select fr2.user_id from syogi.friends as fr2 where fr2.follow_id ");

		return profileList;

	}
}
