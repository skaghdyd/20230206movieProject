package com.study.springboot.jnr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.springboot.jnr.domain.HelpDTO;

@Mapper
public interface HelpMapper {
	
	public List<HelpDTO> findAllHelp 
	( @Param("helpSearch") String helpSearch,
		@Param("type") String type);

	
	@Insert("insert into help( help_title, help_content, help_writer)"
			+ "values( #{help_title}, #{help_content}, #{help_writer})")
	int insertHelp(HelpDTO helpDTO);
	
	@Delete("delete from help where help_id = #{help_id}")
	int deleteHelp(int help_id);
	
	@Update("update help set "
			+ "help_title=#{help_title}, "
			+ "help_content=#{help_content}, "
			+ "help_writer=#{help_writer} "
			+ "where help_id=#{help_id}")
    int updateMovie(HelpDTO helpDTO);
	
	@Select("select help_id, help_title, help_content, help_writer from help")
	List<HelpDTO> selectHelpAll();
	
	@Select("select help_id, help_title, help_content, help_writer from help where help_id =#{ help_id }")
	List<HelpDTO> selectHelp(int help_id);
	
}
