package com.study.springboot.hch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//영화관
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieTheaterDTO {

	String movieTheater_code;
	String movieTheater_name;
	String movieTheater_place;
	String movieTheater_tel;
}
