package com.study.springboot.hch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//상영관
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreenTheaterDTO {

	int screenTheater_code;
	String screenTheater_name;
	int screenTheater_price;
}
