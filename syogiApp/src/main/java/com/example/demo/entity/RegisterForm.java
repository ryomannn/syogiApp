package com.example.demo.entity;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import lombok.Data;


//ログイン時の情報を格納するクラス

@Data
@Component
@Scope(value="session" ,proxyMode=ScopedProxyMode.TARGET_CLASS)

public class RegisterForm implements Serializable{

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Email
	private String userAddress;

	@NotBlank
	@Length(min=4,max=100)
	@Pattern(regexp="^[a-zA-Z0-9]*$")
	private String password;

	@NotBlank
	private String userName;

	private int userId;

}