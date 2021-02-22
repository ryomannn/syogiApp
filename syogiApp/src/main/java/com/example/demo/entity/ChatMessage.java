package com.example.demo.entity;

import lombok.Data;

@Data
public class ChatMessage{

	private String content;
	private String sender;
	private MessageType type;

	public enum MessageType{
		CHAT,LEABE,JOIN
	}

}