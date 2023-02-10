package com.study.springboot.khg.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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
	
	
	//포인트
	@Select("select * from point where cusId=#{cusId}")
	List<Cus> pointFindAll();
	
	@Insert("INSERT INTO point(pDate, getP, res) VALUES(#{DateTime}, #{getP}, #{res})")
	int savePo(Cus cus);
	
	@Delete("DELETE from point where cusId = #{cusId}")
	int deletePo(int cusId);
	
	@Update("UPDATE point set cusId= #{cusId}, pDate= #{pDate}, getP= #{getP}, res= #{res} where cusId = #{cusId}")
	int modifyPo(Cus cus);
	
	@Select("select * from point where cusId=#{cusId} ORDER BY cusId ASC")
	List<Cus> findPo(int cusId);
	
	@Select("select * from point where cusId=#{cusId}")
	public Cus selectOnePo(int cusId);
}
