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

	String screenSchedule_date;
	String screenSchedule_time;
	int movie_code;
	int movieTheater_code;
	int screenTheater_code;
	String screenSchedule_reservedSeat;
}
