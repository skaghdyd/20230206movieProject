package com.study.springboot.nhy.controller;

import java.util.HashMap;
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
		List<HashMap> list = productService.selectAllProduct();
		System.out.println(list);
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
	public List<HashMap> searchProduct(@RequestParam(value="search_product_name_modal") String product_name) {
		List<HashMap> list = productService.searchProduct(product_name);
		return list;
	}
	
	//상품판매등록
	@ResponseBody
	@PostMapping("/sellProduct")
	public int sellProduct(
			@RequestBody Map params,
			HttpServletRequest request
			) 
	{
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
	
	//상품판매내역페이지
	@GetMapping("/sellProductList")
	public String sellProductList(Model model) {
		List<HashMap> list = productService.selectAllSellProduct();
		model.addAttribute("list", list);
		return "nhy/sellProductList";
	}
	
	//상품판매내역상세
	@ResponseBody
	@PostMapping("/sellProductDetails")
	public List<HashMap> sellProductDetails(@RequestParam("sell_no") int sell_no, Model model) {
		List<HashMap> list = productService.selectSellProductDetails(sell_no);
		model.addAttribute("list", list);
		return list;
	}
	
	//상품판매수정페이지
	@GetMapping("/sellProductModify")
	public String sellProductModify(int sell_no, String sell_date, Model model) {
		List<HashMap> list = productService.selectSellProductDetails(sell_no);
		model.addAttribute("list", list);
		model.addAttribute("sell_no", sell_no);
		model.addAttribute("sell_date", sell_date);
		return "nhy/sellProductModify";
	}
	
	//상품판매수정페이지
	@ResponseBody
	@PostMapping("/sellProductModify")
	public int sellProductModify(
			@RequestBody Map params,
			HttpServletRequest request
			) 
	{
		HttpSession session = request.getSession();
		String sales_user_id = (String)session.getAttribute("userId");
		if(sales_user_id==null) {
			sales_user_id = "admin";			
		}
		
		String user_id = (String)params.get("userId");
		List product_list = (List)params.get("selectedProductsArray");
		int sell_no = Integer.parseInt((String)params.get("sell_no"));
		String sell_date = (String)params.get("sell_date");
		int result = productService.sellProductModify(product_list, user_id, sales_user_id, sell_no, sell_date);
		
		return result;
	}
	
	//상품판매삭제
	@ResponseBody
	@PostMapping("/sellProductDelete")
	public int sellProductModify(
			@RequestBody Map params
			) 
	{
		int sell_no = Integer.parseInt((String)params.get("sell_no"));
		int result = productService.sellProductDelete(sell_no);		
		return result;
	}
	
	//상품입고페이지
	@GetMapping("/receivingProduct")
	public String receivingProduct() {
		return "nhy/receivingProduct";
	}
	
	//상품입고등록
	@ResponseBody
	@PostMapping("/receivingProduct")
	public int receivingProduct(
			@RequestBody Map params,
			HttpServletRequest request
			) 
	{
		HttpSession session = request.getSession();
		String receiving_user_id = (String)session.getAttribute("userId");
		if(receiving_user_id==null) {
			receiving_user_id = "admin";			
		}
		
		List product_list = (List)params.get("selectedProductsArray");
		int result = productService.receivingProduct(product_list, receiving_user_id);
		
		return result;
	}
	
	//상품입고내역페이지
	@GetMapping("/receivingProductList")
	public String receivingProductList(Model model) {
		List<HashMap> list = productService.selectAllReceivingProduct();
		model.addAttribute("list", list);
		return "nhy/receivingProductList";
	}
	
	//상품입고내역상세
	@ResponseBody
	@PostMapping("/receivingProductDetails")
	public List<HashMap> receivingProductDetails(@RequestParam("receiving_order") int receiving_order, Model model) {
		List<HashMap> list = productService.selectReceivingProductDetails(receiving_order);
		model.addAttribute("list", list);
		return list;
	}
}