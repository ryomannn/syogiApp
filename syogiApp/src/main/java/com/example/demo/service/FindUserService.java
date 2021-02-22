package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Profile;
import com.example.demo.repository.FindUserRepository;


@Service
public class FindUserService{

	@Autowired
	FindUserRepository findUserRepository;

	public Profile selectOne(int userId) {

		return  findUserRepository.selectOne(userId);

	}

	public void followOne() {

		int rowNumber = findUserRepository.followOne();

		if(rowNumber>0) {

			System.out.println("友達登録成功");

		}
		else {

			System.out.println("友達登録成功");

		}
	}

	public List UserList() {

		 return findUserRepository.UserList();
	}

}

