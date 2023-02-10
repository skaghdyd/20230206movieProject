package com.study.springboot.khg.service;

import java.util.List;

import com.study.springboot.khg.domain.Cus;



public interface CustomerService {
	
	//고객관리
	public List<Cus> findAll();	
	
	public Cus selectOneCus(int cusId);

	public int insert(Cus cus);

	public int deleteCus(List<Integer> selectedColumns);

	public int modifyCus(Cus cus);
	
	//포인트
	public List<Cus> pointFindAll();
	
	public Cus selectOnePo(int cusId);
	
	public int insertPo(Cus cus);

	public int deletePo(List<Integer> selectedColumns);
	
	public int modifyPo(Cus cus);
	
}
