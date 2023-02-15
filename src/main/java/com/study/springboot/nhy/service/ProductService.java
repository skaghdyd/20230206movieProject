package com.study.springboot.nhy.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.study.springboot.nhy.domain.ProductDTO;

public interface ProductService {
	public List<HashMap> selectAllProduct();
	
	public int addProduct(ProductDTO productDTO);
	
	public int deleteProduct(List<Integer> selectedColumns);
	
	public int modifyProduct(ProductDTO productDTO);

	public ProductDTO selectOneProduct(int product_id);

	public List<HashMap> searchProduct(String product_name);
	
	public int sellProduct(List product_list, String user_id, String sales_user_id);

	public List<HashMap> selectAllSellProduct();

	public List<HashMap> selectSellProductDetails(int sell_no);

	public int sellProductModify(List product_list, String user_id, String sales_user_id, int sell_no, String sell_date);

	public int sellProductDelete(int sell_no);

	public int receivingProduct(List product_list, String receiving_user_id);

	public List<HashMap> selectAllReceivingProduct();

	public List<HashMap> selectReceivingProductDetails(int product_id);

	public HashMap receivingProductModify(int product_id, int receiving_order);
	
	public int receivingProductModify(Map params);
}
