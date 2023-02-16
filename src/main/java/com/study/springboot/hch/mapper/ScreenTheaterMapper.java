package com.study.springboot.hch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.springboot.hch.domain.ScreenTheaterDTO;

@Mapper
public interface ScreenTheaterMapper {
	
	@Insert("insert into screenTheater(movieTheater_name, screenTheater_name, screenTheater_price) "
			+ "values(#{movieTheater_name}, #{screenTheater_name}, #{screenTheater_price} )")
	int insertScreenTheater(ScreenTheaterDTO screenTheaterDTO);

	@Select("select screenTheater_code, movieTheater_name, screenTheater_name, screenTheater_price from screentheater")
	List<ScreenTheaterDTO> selectScreenTheaterAll();
	
	@Delete("delete from screenTheater where screenTheater_code = #{screenTheater_code}")
	int deleteScreenTheater(int screenTheater_code);
	
//	수정중
	@Select("select screenTheater_name from screenTheater where movieTheater_name = #{ movieTheaName }")
	List<ScreenTheaterDTO> selectCategoryName(@Param("movieTheaName") String movTheaName);
	
//	x
	@Update("update emp_temp set "
			+ "ename = #{ename}, "
			+ "job = #{job}, "
			+ "sal = #{sal} "
			+ "where empno = #{empno}")
	int updateMovie(ScreenTheaterDTO screenTheaterDTO);
	

}
