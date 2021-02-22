package com.example.demo.controller.contents;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Room;
import com.example.demo.service.RoomService;

@Controller
public class RoomController{
	@Autowired
	RoomService roomService;


	@GetMapping("/room")
	public String getRoom(Model model) {

		List<Room> roomList = new ArrayList<>();

		roomList = roomService.getRoom();

		model.addAttribute("roomLists" , roomList);

		return "/contents/room";
	}

	@PostMapping("/createRoom")
	public String postCreateRoom(@ModelAttribute Room room, Model model) {

		return "/contents/roomInput";
	}

	@PostMapping("/roomInput")
	public String postRoomInput(@ModelAttribute Room room , Model model) {

		System.out.println(room);

		roomService.setRoom(room);
		
		//ここにスレッドを分ける処理を書く


		return "/chat/chat";
	}

	@PostMapping("/leaveRoom")
	public String postLeaveRoom(Model model) {

		roomService.leaveRoom();

		return "redirect:/findBattleType";

	}
}