package com.example.demo.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class Profile{
	@NotNull
	@Length(max=255)
	int user_id;

	@NotNull
	@Length(max=1)
	int gender;

	@NotBlank
	@Length(max=255)
	String hobby;
	@NotBlank
	@Length(max=255)
	String grade;
	@NotBlank
	@Length(max=255)
	int history;
	@NotBlank
	@Length(max=255)
	String fav_battleType;
	@NotBlank
	@Length(max=255)
	String comment;

}