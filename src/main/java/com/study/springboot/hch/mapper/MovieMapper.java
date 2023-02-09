package com.study.springboot.hch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.springboot.hch.domain.MovieDTO;

@Mapper
public interface MovieMapper {
	
	@Insert("insert into movie(movie_code, movie_name, movie_releaseDate, movie_plot, movie_genre) "
			+ "values(#{movie_code}, #{movie_name}, #{movie_releaseDate}, #{movie_plot}, #{movie_genre} )")
	int insertMovie(MovieDTO movieDTO);

	@Select("select movie_code, movie_name, movie_releaseDate, movie_plot, movie_genre from movie")
	List<MovieDTO> selectMovieAll();
	
	@Delete("delete from movie where movie_code = #{movie_code}")
	int deleteMovie(String movie_code);
	
	@Select("select movie_code, movie_name, movie_releaseDate, movie_plot, movie_genre from movie where movie_code = #{ movie_code }")
	List<MovieDTO> selectMovie(String movie_code);
	
	@Update("update movie set "
			+ "movie_name = #{movie_name}, "
			+ "movie_releaseDate = #{movie_releaseDate}, "
			+ "movie_plot = #{movie_plot}, "
			+ "movie_genre = #{movie_genre} "
			+ "where movie_code = #{movie_code}")
	int updateMovie(MovieDTO movieDTO);

}
