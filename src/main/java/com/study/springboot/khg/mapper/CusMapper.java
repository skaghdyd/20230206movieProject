package com.study.springboot.khg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.study.springboot.khg.domain.Cus;
import com.study.springboot.nhy.domain.ProductDTO;





@Mapper
public interface CusMapper {
	@Select("select * from customer")
	List<Cus> findAll();
	
	@Insert("INSERT INTO customer(cusId, cusName, Birth, Phone) VALUES(#{aaa}, #{cusName}, #{Birth}, #{Phone}) on DUPLICATE KEY UPDATE cusId=cusId + 1")
	int save(Cus cus);
	
	@Delete("DELETE from customer where cusId = #{cusId}")
	int delete(int cusId);
	
	@Update("UPDATE customer set cusId= #{cusId}, cusName= #{cusName}, Birth= #{Birth}, Phone= #{Phone} where cusId = #{cusId}")
	int modifyCus(Cus cus);
	
	@Select("select * from customer where cusId=#{cusId} ORDER BY cusId ASC")
	List<Cus> find(int cusId);
	
	@Select("select * from customer where cusId=#{cusId}")
	public Cus selectOneCus(int cusId);
	
	@Select("select * from customer where cusId like #{cusId}")
	public List<Cus> searchCusId(String cusId);
	
	
	//포인트
	@Select("select point.cusId as cusId, customer.cusName as cusName, point.pDate as pDate, point.getP as getP, point.res as res from customer, point where customer.cusId = point.cusId")
	List<Cus> pointFindAll();
	
	@Insert("INSERT INTO point(cusId, pDate, getP, res) VALUES(#{aaa}, DATE_FORMAT(NOW(),'%Y-%m-%d %h:%i%p'), +5000, '신규가입')")
	int savePo(Cus cus);
	
	@Delete("DELETE from point where cusId = #{cusId}")
	int deletePo(int cusId);
	
	@Update("UPDATE point set cusId= #{cusId}, pDate= DATE_FORMAT(NOW(),'%Y-%m-%d %h:%i%p'), getP= #{getP}, res= #{res} where cusId = #{cusId}")
	int modifyPo(Cus cus);
	
	@Select("select point.cusId as cusId, customer.cusName as cusName, point.pDate as pDate, point.getP as getP, point.res as res from customer, point where customer.cusId = point.cusId and point.cusId like '%${cusId}%'")
	List<Cus> pSearch(String cusId);
	
	@Select("select point.cusId as cusId, customer.cusName as cusName, point.pDate as pDate, point.getP as getP, point.res as res from customer, point where customer.cusId = point.cusId")
	public Cus selectOnePo(int cusId);
	
	@Select("select SUM(getP) FROM point WHERE cusId = #{cusId}")
	int sumPo(int cusId);
}
