package com.study.springboot.hch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.springboot.hch.domain.MovieDTO;
import com.study.springboot.hch.domain.ScreenScheduleDTO;

@Mapper
public interface ScreenScheduleMapper {
	
	@Insert("insert into screenSchedule(screenSchedule_date , screenSchedule_time, "
			+ "movie_code , movieTheater_code , screenTheater_code, screenSchedule_reservedSeat) "
			+ "values(#{screenSchedule_date}, #{screenSchedule_time}, #{movie_code}, "
			+ "#{movieTheater_code}, #{screenTheater_code}, #{screenSchedule_reservedSeat} )")
	int insertScreenSchedule(ScreenScheduleDTO screenScheduleDTO);

//	x
	@Select("select empno, ename, job, sal from emp_temp")
	List<MovieDTO> findMovieAll();
	
//	x
	@Select("select empno, ename, job, sal from emp_temp where empno = #{ empno }")
	List<MovieDTO> selectEmpTemp(int empno);
	
//	x
	@Update("update emp_temp set "
			+ "ename = #{ename}, "
			+ "job = #{job}, "
			+ "sal = #{sal} "
			+ "where empno = #{empno}")
	int updateMovie(MovieDTO movieDTO);
	
//	x
	@Delete("delete from emp_temp where empno = #{empno}")
	int deleteEmpTemp(int empno);
}
