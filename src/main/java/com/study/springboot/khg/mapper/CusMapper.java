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
	//고객 Mapper
	//고객리스트 조회
	@Select("select * from customer")
	List<Cus> findAll();
	
	//고객가입
	@Insert("INSERT INTO customer(cusId, cusName, Birth, Phone) VALUES(#{aaa}, #{cusName}, #{Birth}, #{Phone}) on DUPLICATE KEY UPDATE cusId=cusId + 1")
	int save(Cus cus);
	
	//고객삭제
	@Delete("DELETE from customer where cusId = #{cusId}")
	int delete(String cusId);
	
	//고객정보수정
	@Update("UPDATE customer set cusId= #{cusId}, cusName= #{cusName}, Birth= #{Birth}, Phone= #{Phone} where cusId = #{cusId}")
	int modifyCus(Cus cus);
	
	//특정고객 정보수정페이지에 고객정보 조회
	@Select("select * from customer where cusId=#{cusId}")
	public Cus selectOneCus(String cusId);
	
	//고객검색
	@Select("select * from customer where cusId like #{cusId}")
	List<Cus> searchCusId(String cusId);
	
	
	//포인트쪽 Mapper
	//포인트 전체내역 조회
	@Select("select point.cusId as cusId, customer.cusName as cusName, point.pDate as pDate, point.getP as getP, point.res as res from customer, point where customer.cusId = point.cusId")
	List<Cus> pointFindAll();
	//신규가입시 5000포인트 추가
	@Insert("INSERT INTO point(cusId, pDate, getP, res) VALUES(#{aaa}, DATE_FORMAT(NOW(),'%Y-%m-%d %h:%i%p'), +5000, '신규가입')")
	int savePo(Cus cus);
	
	//포인트 삭제
	@Delete("DELETE from point where cusId = #{cusId}")
	int deletePo(String cusId);
	
	//포인트 수정
	@Update("UPDATE point set cusId= #{cusId}, pDate= DATE_FORMAT(NOW(),'%Y-%m-%d %h:%i%p'), getP= #{getP}, res= #{res} where cusId = #{cusId}")
	int modifyPo(Cus cus);
	
	//고객코드로 포인트수정페이지에 정보불러오기
	@Select("select point.cusId as cusId, customer.cusName as cusName, point.pDate as pDate, point.getP as getP, point.res as res from customer, point where customer.cusId = point.cusId and point.cusId = #{cusId}")
	public Cus selectOnePo(String cusId);
	
	//고객코드로 잔여포인트 검색
	@Select("select point.cusId as cusId, customer.cusName as cusName, point.pDate as pDate, point.getP as getP, point.res as res from customer, point where customer.cusId = point.cusId and point.cusId = #{cusId}")
	List<Cus> pSearch(String cusId);
}
