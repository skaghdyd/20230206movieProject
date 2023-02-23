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
	public List<HashMap> selectAllProduct();
	
	@Insert("insert into product(product_id, product_name, product_price) "
			+ "values(0, #{product_name}, #{product_price})")
	public int addProduct(ProductDTO productDTO);
	
	@Delete("delete from product where product_id=#{product_id}")
	public int deleteProduct(int product_id);
	
	@Update("update product set product_name=#{product_name}, product_price=#{product_price} where product_id=#{product_id}")
	public int modifyProduct(ProductDTO productDTO);
	
	@Select("select * from product where product_id=#{product_id}")
	public ProductDTO selectOneProduct(int product_id);

	public List<HashMap> searchProduct(String product_name);
	
	public int sellProduct(
			@Param("sell_no") int sell_no, 
			@Param("product_id")int product_id, 
			@Param("user_id") String user_id, 
			@Param("product_num") int product_num, 
			@Param("sales_user_id") String sales_user_id, 
			@Param("sell_date") String sell_date,
			@Param("cusId") String cusId
			);
	
	@Select("select ifnull(max(sell_no)+1, 1) from product_sell")
	public int getMaxSellNo();
	
	public List<HashMap> selectAllSellProduct();
	
	public List<HashMap> selectSellProductDetails(int sell_no);
	
	@Delete("delete from product_sell where sell_no =#{sell_no}")
	public int sellProductDelete(int sell_no);
	
	@Select("SELECT ifnull(MAX(receiving_order)+1, 1) FROM product_receiving WHERE product_id=#{product_id}")
	public int getMaxReceivingOrder(int product_id);

	public int receivingProduct(
			@Param("product_id") int product_id, 
			@Param("receiving_order") int receiving_order, 
			@Param("product_num") int product_num, 
			@Param("receiving_user_id") String receiving_user_id,	
			@Param("receiving_date") String receiving_date);
	
	@Select("SELECT count(*) FROM product_receiving WHERE product_id = #{product_id}")
	public int receivingCheck(int product_id);
	
	public List<HashMap> selectAllReceivingProduct();

	public List<HashMap> selectReceivingProductDetails(int product_id);

	public int getCurrentProductStock(int product_id);

	public HashMap receivingProductModify(
			@Param("product_id") int product_id, 
			@Param("receiving_order") int receiving_order);

	public int receivingProductModifyAction(
			@Param("product_id") int product_id, 
			@Param("receiving_order") int receiving_orde, 
			@Param("receiving_num") int receiving_num);

	public void addCustomerPoint(
			@Param("cusId")String cusId, 
			@Param("sell_date")String sell_date, 
			@Param("point")double point, 
			@Param("res")String res);

	public List<HashMap> getCustomerInfo(
			@Param("cusId") String cusId,
			@Param("cusName") String cusName
			);

	public int useCoupon(String event_name);
}