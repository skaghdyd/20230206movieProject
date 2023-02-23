package com.study.springboot.hch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//상영관 스케줄
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ScreenScheduleDTO {

	int screenSchedule_code;
	String screenSchedule_date;
	int movieTheater_code;
	int screenTheater_code;
	int firstMovie_code;
	int secondMovie_code;
	int thirdMovie_code;
	int fourthMovie_code;
	String firstMovie_time;
	String secondMovie_time;
	String thirdMovie_time;
	String fourthMovie_time;
	String firstMovie_reservedSeat;
	String secondMovie_reservedSeat;
	String thirdMovie_reservedSeat;
	String fourthMovie_reservedSeat;
}
