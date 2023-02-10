package com.study.springboot.hch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.springboot.hch.domain.MovieDTO;
import com.study.springboot.hch.domain.MovieTheaterDTO;

@Mapper
public interface MovieTheaterMapper {
	
	@Insert("insert into movieTheater(movieTheater_name, movieTheater_place, movieTheater_tel) "
			+ "values(#{movieTheater_name}, #{movieTheater_place}, #{movieTheater_tel} )")
	int insertMovieTheater(MovieTheaterDTO MovieTheaterDTO);

	@Select("select movieTheater_code, movieTheater_name, movieTheater_place, movieTheater_tel from movieTheater")
	List<MovieTheaterDTO> selectMovieTheaterAll();
	

	@Select("select movieTheater_code, movieTheater_name, movieTheater_place, movieTheater_tel from movieTheater where movieTheater_code = #{ movieTheater_code }")
	List<MovieTheaterDTO> selectMovieTheater(int movieTheater_code);
	

	@Update("update movieTheater set "
			+ "movieTheater_name = #{movieTheater_name}, "
			+ "movieTheater_place = #{movieTheater_place}, "
			+ "movieTheater_tel = #{movieTheater_tel} "
			+ "where movieTheater_code = #{movieTheater_code}")
	int updateMovieTheater(MovieTheaterDTO movieDTO);
	

	@Delete("delete from movieTheater where movieTheater_code = #{movieTheater_code}")
	int deleteMovieTheater(int movieTheater_code);

	@Select("select movieTheater_name from movieTheater")
	List<MovieTheaterDTO> selectMovieTheaterNames();
}
