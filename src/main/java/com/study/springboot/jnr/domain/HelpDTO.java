package com.study.springboot.jnr.domain;

import lombok.Data;

@Data
public class HelpDTO {
	private int help_id; //id
	private String help_title; //제목
	private String help_content; //내용
	private String help_writer; //작성자
	
}
