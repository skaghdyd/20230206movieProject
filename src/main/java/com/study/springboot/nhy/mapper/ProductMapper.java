package com.study.springboot.nhy.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.springboot.nhy.domain.ProductDTO;

@Mapper
public interface ProductMapper {
	@Select("select * from product")
	public List<ProductDTO> selectAllProduct();
	
	@Insert("insert into product(product_id, product_name, product_price, product_stock) "
			+ "values(0, #{product_name}, #{product_price}, 0)")
	public int addProduct(ProductDTO productDTO);
	
	@Delete("delete from product where product_id=#{product_id}")
	public int deleteProduct(int product_id);
	
	@Update("update product set product_name=#{product_name}, product_price=#{product_price} where product_id=#{product_id}")
	public int modifyProduct(ProductDTO productDTO);
	
	@Select("select * from product where product_id=#{product_id}")
	public ProductDTO selectOneProduct(int product_id);

	@Select("select * from product where product_name like #{product_name}")
	public List<ProductDTO> searchProduct(String product_name);
	
	public int sellProduct(
			@Param("sell_no") int sell_no, 
			@Param("product_id")int product_id, 
			@Param("user_id") String user_id, 
			@Param("product_num") int product_num, 
			@Param("sales_user_id") String sales_user_id, 
			@Param("sell_date") String sell_date
			);
	
	@Select("select ifnull(max(sell_no)+1, 1) from product_sell")
	public int getMaxSellNo();
	
	public List<HashMap> selectAllSellProduct();
	
	public List<HashMap> selectSellProductDetails(int sell_no);
}
