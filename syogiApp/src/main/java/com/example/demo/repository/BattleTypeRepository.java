package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.BattleType;

@Repository
public class BattleTypeRepository{

	@Autowired
	JdbcTemplate jdbc;

	public List<BattleType> selectMany() throws DataAccessException{

		List<Map<String, Object>> getList = jdbc.queryForList("select * from syogi.battleTypes");

		List<BattleType> battleList = new ArrayList<>();

		for(Map<String, Object> map : getList) {

			BattleType battleType = new BattleType();

			battleType.setName((String)map.get("name"));

			battleList.add(battleType);
		}

		return battleList;

	}
}