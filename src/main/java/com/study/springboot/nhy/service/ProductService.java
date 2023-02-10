package com.study.springboot.nhy.service;

import java.util.List;

import com.study.springboot.nhy.domain.ProductDTO;

public interface ProductService {
	public List<ProductDTO> selectAllProduct();
	
	public int addProduct(ProductDTO productDTO);
	
	public int deleteProduct(List<Integer> selectedColumns);
	
	public int modifyProduct(ProductDTO productDTO);

	public ProductDTO selectOneProduct(int product_id);

	public List<ProductDTO> searchProduct(String product_name);
	
	public int sellProduct(List product_list, String user_id, String sales_user_id);
}
