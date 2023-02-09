package com.study.springboot.hch.domain;

import lombok.Data;

//상영관 스케줄
@Data
public class ScreenScheduleDTO {

	String screenSchedule_date;
	String screenSchedule_time;
	String movie_code;
	String movieTheater_code;
	String screenTheater_code;
	String screenSchedule_reservedSeat;
}
