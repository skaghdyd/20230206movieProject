package com.study.springboot.lby.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.ui.Model;

import com.study.springboot.lby.domain.EventDTO;

@Mapper
public interface EventMapper {
	
	@Insert("insert into event(event_name, event_price, event_count ) "
			+ "values(#{event_name}, #{event_price}, #{event_count} )")
		int insertEvent(EventDTO eventDTO);
	
	@Select("select event_name, event_price, event_count from event ")
	List<EventDTO> selectEventAll();

	public List<EventDTO> findAllEventDTO
	(@Param("search") String search,
	 @Param("type") String type);	

}
