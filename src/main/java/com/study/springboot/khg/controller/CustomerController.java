package com.study.springboot.khg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.khg.domain.Cus;
import com.study.springboot.khg.mapper.CusMapper;
import com.study.springboot.khg.service.CustomerService;

import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/customer")
@Log4j2
public class CustomerController {

	// 필요한 의존 객체의 “타입"에 해당하는 빈을 찾아 주입한다.
	@Autowired
	private CusMapper cusMapper;

	@Autowired
	CustomerService customerService;

	@GetMapping("/main")
	public String main() {
		return "khg/main";
	}

	// 고객가입 페이지로 넘어가기
	@GetMapping("/signup")
	public String insert() {
		return "khg/signup";
	}

	// 고객가입 정보입력 고객코드는 번호뒷자리 + 난수
	@PostMapping("/signup")
	@ResponseBody
	public int insert(Cus cus, Model model) {
		String Phone = cus.getPhone();
		String aaa = Phone.substring(9);
		int num = (int) (Math.random() * 10);
		aaa += num;
		cus.setAaa(aaa);
		int result = cusMapper.save(cus);
		int result1 = cusMapper.savePo(cus);
		return result;
	}

	// Get방식으로 고객정보 불러오기
	@GetMapping("/list")
	public String list(Model model) {
		List<Cus> list = cusMapper.findAll();
		model.addAttribute("list", list);
		return "khg/customerList";
	}

	// 고객삭제
	@PostMapping("/delete")
	@ResponseBody
	public int deleteCus(@RequestParam(value = "selectedColumns[]") List<String> selectedColumns) {
		int result = customerService.deleteCus(selectedColumns);
		return result;
	}

	// 고객정보수정페이지로 넘어가기
	@GetMapping("/modify")
	public String update(String cusId, Model model) {
		Cus cus = customerService.selectOneCus(cusId);
		model.addAttribute("cus", cus);
		return "khg/modifyCus";
	}

	// 고객정보수정
	@ResponseBody
	@PostMapping("/modify")
	public int modifyCus(Cus cus) {
		int result = customerService.modifyCus(cus);
		return result;
	}

	// 고객검색
	@ResponseBody
	@PostMapping("/search")
	public List<Cus> searchCusId(@RequestParam(value = "search_cusId") String cusId) {
		List<Cus> list = customerService.searchCusId(cusId);
		return list;
	}

	// 포인트리스트
	@GetMapping("/pointList")
	public String pointList(Model model) {
		List<Cus> plist = cusMapper.pointFindAll();
		model.addAttribute("plist", plist);
		return "khg/pointList";
	}

	// 포인트 검색
	@ResponseBody
	@PostMapping("/pSearch")
	public List<Cus> pSearch(@RequestParam(value = "search_point_name_modal") String cusId) {
		List<Cus> plist = cusMapper.pSearch(cusId);
		return plist;
	}
	

	// 포인트수정페이지로 넘어가기
	@GetMapping("/modifyPo")
	public String pupdate(String cusId, Model model) {
		Cus cus = customerService.selectOnePo(cusId);
		model.addAttribute("cus", cus);
		return "khg/modifyPoint";
	}

	// 포인트정보수정
	@ResponseBody
	@PostMapping("/modifyPo")
	public int modifyPo(Cus cus) {
		int result = customerService.modifyPo(cus);
		return result;
	}

	// 포인트삭제
	@PostMapping("/deletePo")
	@ResponseBody
	public int deletePo(@RequestParam(value = "selectedColumns[]") List<String> selectedColumns) {
		int result = customerService.deletePo(selectedColumns);
		return result;
	}
	
	

}
