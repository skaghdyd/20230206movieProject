package com.study.springboot.hch.domain;

import lombok.Data;

//영화
@Data
public class MovieDTO {
	String movie_Code;
	String movie_name;
	String movie_releaseDate;
	String movie_plot;
	String movie_genre;
}
