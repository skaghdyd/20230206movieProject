package com.study.springboot.nhy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.nhy.domain.ProductDTO;
import com.study.springboot.nhy.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductService productService;
	
	//상품목록페이지
	@GetMapping("/list")
	public String selectAll(Model model) {
		List<ProductDTO> list = productService.selectAllProduct();
		model.addAttribute("list", list);
		return "nhy/productList";
	}
	
	//상품등록페이지
	@GetMapping("/add")
	public String addProduct() {
		return "nhy/addProduct";
	}
	
	//상품등록
	@ResponseBody
	@PostMapping("/add")
	public int addProduct(ProductDTO productDTO) {
		int result = productService.addProduct(productDTO);
		return result;
	}
	
	//상품삭제
	@ResponseBody
	@PostMapping("/delete")
	public int deleteProduct(@RequestParam(value="selectedColumns[]") List<Integer> selectedColumns) {
		int result = productService.deleteProduct(selectedColumns);
		return result;
	}
	
	//상품수정페이지
	@GetMapping("/modify")
	public String modifyProduct(int product_id, Model model) {
		ProductDTO productDTO = productService.selectOneProduct(product_id);
		model.addAttribute("productDTO", productDTO);
		return "nhy/modifyProduct";
	}
	
	//상품수정
	@ResponseBody
	@PostMapping("/modify")
	public int modifyProduct(ProductDTO productDTO) {
		int result = productService.modifyProduct(productDTO);
		return result;
	}
}
