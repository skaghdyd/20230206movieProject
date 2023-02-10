package com.study.springboot.hch.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//영화
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
	int movie_code;
	String movie_name;
	String movie_releaseDate;
	String movie_plot;
	String movie_genre;
}
