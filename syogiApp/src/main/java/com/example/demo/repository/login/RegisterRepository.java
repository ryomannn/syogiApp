package com.example.demo.repository.login;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.User;
import com.example.demo.repository.UserDao;


@Repository
public class RegisterRepository implements UserDao{

	@Autowired
	JdbcTemplate jdbc;

	//ログイン情報をusersテーブルに保存

	@Override
	public int insertOne(User user)throws DataAccessException{

		int rowNumber = jdbc.update("insert into syogi.users(name, address, password)"
				+ " values(?,?,?)", user.getUserName(), user.getUserAddress(), user.getPassword());

		return rowNumber;
	}

	public User selectUser(User user)throws DataAccessException{

		User users = new User();

		Map<String, Object> map = jdbc.queryForMap("select * from syogi.users where address=?",user.getUserAddress());

		users.setUserId((int)map.get("id"));
		users.setUserName((String)map.get("name"));

		return users;

	}



}