package com.example.demo.repository;

import org.springframework.dao.DataAccessException;

import com.example.demo.entity.User;


public interface UserDao{

	public int insertOne(User user)throws DataAccessException;
}