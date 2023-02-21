package com.study.springboot.hch.mapper;

import java.util.HashMap;
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
	
	@Insert("insert into screenSchedule(screenSchedule_date , movieTheater_code, screenTheater_code , "
			+ "firstMovie_code , secondMovie_code, thirdMovie_code, fourthMovie_code, "
			+ "firstMovie_time , secondMovie_time, thirdMovie_time, fourthMovie_time "
			+ ") "
			+ "values(#{screenSchedule_date}, #{movieTheater_code,}, #{screenTheater_code}, "
			+ "#{firstMovie_code}, #{secondMovie_code}, #{thirdMovie_code}, #{fourthMovie_code}, "
			+ "#{firstMovie_time}, #{secondMovie_time}, #{thirdMovie_time}, #{fourthMovie_time} )")
	int insertScreenSchedule(ScreenScheduleDTO screenScheduleDTO);

	@Select("SELECT \r\n"
			+ "screenSchedule_code, \r\n"
			+ "screenSchedule_date, \r\n"
			+ "movieTheater_code, \r\n"
			+ "screenTheater_code, \r\n"
			+ "firstMovie_code, \r\n"
			+ "secondMovie_code, \r\n"
			+ "thirdMovie_code, \r\n"
			+ "fourthMovie_code, \r\n"
			+ "firstMovie_time, \r\n"
			+ "secondMovie_time, \r\n"
			+ "thirdMovie_time, \r\n"
			+ "fourthMovie_time, \r\n"
			+ "ifnull(firstMovie_reservedSeat,'없음') AS firstMovie_reservedSeat, \r\n"
			+ "ifnull(secondMovie_reservedSeat,'없음') AS secondMovie_reservedSeat, \r\n"
			+ "ifnull(thirdMovie_reservedSeat,'없음') AS thirdMovie_reservedSeat, \r\n"
			+ "ifnull(fourthMovie_reservedSeat,'없음') AS fourthMovie_reservedSeat, \r\n"
			+ "(SELECT movieTheater_name FROM movietheater WHERE movieTheater_code = screenschedule.movieTheater_code) AS movieTheater_name, \r\n"
			+ "(SELECT screenTheater_name FROM screentheater WHERE screenTheater_code = screenschedule.screenTheater_code) AS screenTheater_name, \r\n"
			+ "(SELECT movie_name FROM movie WHERE movie_code = screenschedule.firstmovie_code) AS fstm, \r\n"
			+ "(SELECT movie_name FROM movie WHERE movie_code = screenschedule.secondmovie_code) AS scdm, \r\n"
			+ "(SELECT movie_name FROM movie WHERE movie_code = screenschedule.thirdmovie_code) AS trdm, \r\n"
			+ "(SELECT movie_name FROM movie WHERE movie_code = screenschedule.fourthmovie_code) AS frhm \r\n"
			+ "from screenschedule")
	List<HashMap> findscreenScheduleAll();
	
	@Select("SELECT "
			+ "(SELECT movie_name FROM movie WHERE movie_code = ss.firstmovie_code) AS fstm, "
			+ "(SELECT movie_name FROM movie WHERE movie_code = ss.secondmovie_code) AS scdm, "
			+ "(SELECT movie_name FROM movie WHERE movie_code = ss.thirdmovie_code) AS trdm, "
			+ "(SELECT movie_name FROM movie WHERE movie_code = ss.fourthmovie_code) AS frhm "
			+ "FROM screenschedule ss")
	List<HashMap> selectScreenNames();
	
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
