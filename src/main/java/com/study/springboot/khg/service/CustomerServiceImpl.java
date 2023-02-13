package com.study.springboot.khg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.khg.domain.Cus;
import com.study.springboot.khg.mapper.CusMapper;
import com.study.springboot.nhy.domain.ProductDTO;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CusMapper cusMapper;
	
	
	@Override
	public List<Cus> findAll() {
		List<Cus> list = cusMapper.findAll();
		return list;
	}

	@Override
	public int modifyCus(Cus cus) {
		int result = cusMapper.modifyCus(cus);
		return result;
	}
	
	@Override
	public Cus selectOneCus(int cusId) {
		Cus cus = cusMapper.selectOneCus(cusId);
		return cus;
	}

	@Override
	public int insert(Cus cus) {
		int res = cusMapper.save(cus);
		return res;
	}

	@Override
	public int deleteCus(List<Integer> selectedColumns) {
int result = 0;
		
		for(int i=0; i<selectedColumns.size(); i++) {
			int cusId = selectedColumns.get(i);
			result += cusMapper.delete(cusId);			
		}
		
		if(selectedColumns.size()==result) {
			return 1;
		}
		
		return 0;
		
	}
	
	@Override
	public List<Cus> searchCusId(String cusId) {
		List<Cus> list = cusMapper.searchCusId("%"+cusId+"%");
		return list;
	}
	
	//포인트
	@Override
	public Cus selectOnePo(int cusId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cus> pointFindAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertPo(Cus cus) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deletePo(List<Integer> selectedColumns) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyPo(Cus cus) {
		// TODO Auto-generated method stub
		return 0;
	}

	


	

	

}
