package com.example.demo.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.controller.contents.ChooseBattleTypeController;
import com.example.demo.controller.login.RegisterController;
import com.example.demo.entity.Room;

@Repository
public class RoomRepository{


	@Autowired
	JdbcTemplate jdbc;

	@Autowired
	 ChooseBattleTypeController chooseBattleTypeController;

	@Autowired
	RegisterController registerController;

	//作ったルームをDB登録
	public int setRoom(Room room) {
		int rowNumber = jdbc.update("insert into syogi.room (user_id,name,battleType,in_flg) values(?,?,?,?);",registerController.registerForm2.getUserId(), room.getRoomName(), chooseBattleTypeController.battleType2.getName(), 1);


		return  rowNumber;
	}


	//作られたルーム名一覧取得
	public List<Room> getRoom() {


		List<Map<String,Object>> getList = jdbc.queryForList("select * from syogi.room where in_flg = 1 and name=?", chooseBattleTypeController.battleType2.getName());

		List<Room> roomList = new ArrayList<>();

		for(Map<String,Object> map : getList) {

			Room room = new Room();

			room.setRoomName((String)map.get("name"));

			roomList.add(room);
			System.out.println(room.getRoomName());

		}
		System.out.println("room一覧select成功");
		return roomList;

	}

	//退室時にルームの破棄
	public int leaveRoom() {

		int rowNumber2 = jdbc.update("update syogi.room set in_flg=2 where user_id = ?", registerController.registerForm2.getUserId());

		return rowNumber2;

	}
}