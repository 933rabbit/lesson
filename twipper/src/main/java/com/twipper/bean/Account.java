package com.twipper.bean;

import lombok.Data;

@Data
public class Account {

	private String user_id;

	private String pass;

	private Integer user_lock;

	private Integer mng;

}