package com.study.springboot.nhy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.study.springboot.nhy.domain.ProductDTO;

@Mapper
public interface ProductMapper {
	@Select("select * from product")
	List<ProductDTO> selectAllProduct();
	
	@Insert("insert into product(product_id, product_name, product_price, product_stock) "
			+ "values(0, #{product_name}, #{product_price}, 0)")
	int addProduct(ProductDTO productDTO);
	
	@Delete("delete from product where product_id=#{product_id}")
	int deleteProduct(int product_id);
}
