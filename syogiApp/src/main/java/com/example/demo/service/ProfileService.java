package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Profile;
import com.example.demo.entity.User;
import com.example.demo.repository.login.ProfileRepository;

@Service
public class ProfileService{


	@Autowired
	ProfileRepository profileRepository;

	public boolean insertOne(Profile profile){

		boolean result = false;

		int rowNumber = profileRepository.insertOne(profile);

		if(rowNumber >0) {

			result = true;

			System.out.println("insert成功");

		}
		else {
			System.out.println("insert失敗");
		}

		return result;

	}

	public List<User> selectFriends(){

		return profileRepository.selectFriends();
	}

}