package com.study.springboot.nhy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface ProductMapper {
	@Select("select * from product")
	List<ProductDTO> selectAll();
}
