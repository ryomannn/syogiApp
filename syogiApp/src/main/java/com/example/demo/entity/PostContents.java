package com.example.demo.entity;

import java.util.Date;

import lombok.Data;

@Data
public class PostContents{
	private String contents;
	private Date created_at;
}