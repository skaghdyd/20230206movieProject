package com.study.springboot.nhy.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.nhy.domain.ProductDTO;
import com.study.springboot.nhy.service.ProductService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

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
	
	//상품판매페이지
	@GetMapping("/sell")
	public String sellProduct() {
		return "nhy/sellProduct";
	}
	
	//상품검색
	@ResponseBody
	@PostMapping("/search")
	public List<ProductDTO> searchProduct(@RequestParam(value="search_product_name_modal") String product_name) {
		List<ProductDTO> list = productService.searchProduct(product_name);
		return list;
	}
	
	@ResponseBody
	@PostMapping("/sellProduct")
	public int sellProduct(
			@RequestBody Map params,
			HttpServletRequest request
			) 
	{
		System.out.println(params);
		HttpSession session = request.getSession();
		String sales_user_id = (String)session.getAttribute("userId");
		if(sales_user_id==null) {
			sales_user_id = "admin";			
		}
		
		String user_id = (String)params.get("userId");
		List product_list = (List)params.get("selectedProductsArray");
		int result = productService.sellProduct(product_list, user_id, sales_user_id);
		
		return result;
	}
	
	@GetMapping("/test")
	public String test(Model model) {
		model.addAttribute("ttt","test입니돠~~~ㅓ!~*!~*!*");
		return "nhy/test";
	}
}
