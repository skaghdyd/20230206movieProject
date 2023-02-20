package com.study.springboot.khg.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.khg.domain.Cus;
import com.study.springboot.khg.mapper.CusMapper;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CusMapper cusMapper;

	// 고객리스트
	@Override
	public List<Cus> findAll() {
		List<Cus> list = cusMapper.findAll();
		return list;
	}

	// 고객정보수정
	@Override
	public int modifyCus(Cus cus) {
		int result = cusMapper.modifyCus(cus);
		return result;
	}

	// 고객선택
	@Override
	public Cus selectOneCus(String cusId) {
		Cus cus = cusMapper.selectOneCus(cusId);
		return cus;
	}

	// 고객가입
	@Override
	public int insert(Cus cus) {
		int res = cusMapper.save(cus);
		return res;
	}

	// 고객삭제
	@Override
	public int deleteCus(List<String> selectedColumns) {
		int result = 0;

		for (int i = 0; i < selectedColumns.size(); i++) {
			String cusId = selectedColumns.get(i);
			result += cusMapper.delete(cusId);
		}

		if (selectedColumns.size() == result) {
			return 1;
		}

		return 0;

	}

	// 고객검색
	@Override
	public List<Cus> searchCusId(String cusId) {
		List<Cus> list = cusMapper.searchCusId("%"+cusId+"%");
		return list;
	}

	// 포인트 고객선택후 수정
	@Override
	public Cus selectOnePo(String cusId) {
		Cus cus = cusMapper.selectOnePo(cusId);
		return cus;
		
	}
	//포인트 검색
		@Override
		public List<Cus> pSearch(String cusId) {
			List<Cus> plist = cusMapper.pSearch("+cusId+");
			return plist;
		}
		
	@Override
	public List<Cus> pointFindAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	//신규가입 포인트
	@Override
	public int savePo(Cus cus) {
		// 현재날짜
		DateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date nowDate = new Date();
		String today = sdFormat.format(nowDate);
		int res1 = cusMapper.savePo(cus);
		return res1;
	}
	//포인트삭제
	@Override
	public int deletePo(List<String> selectedColumns) {
		int result = 0;

		for (int i = 0; i < selectedColumns.size(); i++) {
			String cusId = selectedColumns.get(i);
			result += cusMapper.deletePo(cusId);
		}

		if (selectedColumns.size() == result) {
			return 1;
		}

		return 0;
	}
	//포인트수정
	@Override
	public int modifyPo(Cus cus) {
		int result = cusMapper.modifyPo(cus);
		return result;
	}

	
	
	

}
