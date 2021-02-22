package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.BattleType;
import com.example.demo.repository.BattleTypeRepository;

@Service
public class BattleTypeService{

	@Autowired
	BattleTypeRepository battleTypeRepository;

	public List<BattleType> selectMany(){

		return battleTypeRepository.selectMany();
	}
}