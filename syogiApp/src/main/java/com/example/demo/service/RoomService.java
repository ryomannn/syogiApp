package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Room;
import com.example.demo.repository.RoomRepository;

@Service
public class RoomService{

	@Autowired
	RoomRepository roomRepository;

	public void setRoom(Room room) {

		int number = roomRepository.setRoom(room);

		if(number >0) {

			System.out.println("insert成功");
		}
		else {
			System.out.println("insert失敗");
		}


	}

	public List<Room> getRoom() {

		List<Room> roomList = new ArrayList<>();

		roomList = roomRepository.getRoom();


		return roomList;
	}

	public void leaveRoom() {

		int number2 =roomRepository.leaveRoom();


		if(number2 >0) {

			System.out.println("insert成功");
		}
		else {
			System.out.println("insert失敗");
		}
	}
	
	

}