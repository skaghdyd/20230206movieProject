package com.study.springboot.nhy.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.nhy.domain.ProductDTO;
import com.study.springboot.nhy.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductMapper productMapper;
	
	@Override
	public List<HashMap> selectAllProduct() {
		List<HashMap> list = productMapper.selectAllProduct();
		return list;
	}

	@Override
	public int addProduct(ProductDTO productDTO) {
		int result = productMapper.addProduct(productDTO);
		return result;
	}

	@Override
	public int deleteProduct(List<Integer> selectedColumns) {
		
		//입고 내역 체크
		for(int i=0; i<selectedColumns.size(); i++) {
			int product_id = selectedColumns.get(i);
			int result = productMapper.receivingCheck(product_id);
			if(result!=0) {
				return -1;
			}
		}
		
		int result = 0;
		
		for(int i=0; i<selectedColumns.size(); i++) {
			int product_id = selectedColumns.get(i);
			result += productMapper.deleteProduct(product_id);			
		}
		
		if(selectedColumns.size()==result) {
			return 1;
		}
		
		return 0;		
	}

	@Override
	public int modifyProduct(ProductDTO productDTO) {
		int result = productMapper.modifyProduct(productDTO);
		return result;
	}

	@Override
	public ProductDTO selectOneProduct(int product_id) {
		ProductDTO productDTO = productMapper.selectOneProduct(product_id);
		return productDTO;
	}

	@Override
	public List<HashMap> searchProduct(String product_name) {
		List<HashMap> list = productMapper.searchProduct("%"+product_name+"%");
		return list;
	}

	@Override
	public int sellProduct(List product_list, String user_id, String sales_user_id) {
		
		//현재재고 체크
		for(int i=0; i<product_list.size(); i++) {
			Map product_map = (Map)product_list.get(i);
			int product_id = Integer.parseInt((String) product_map.get("product_id"));
			int currentStock = productMapper.getCurrentProductStock(product_id);
			int product_num = Integer.parseInt((String) product_map.get("product_num"));
			
			if (product_num > currentStock) {
				return -1;
			}
		}
		
		int result = 0;
		
		//현재날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();
		String sell_date = sdf.format(c1.getTime());
		
		int sell_no = productMapper.getMaxSellNo();
		for(int i=0; i<product_list.size(); i++) {
			Map product_map = (Map)product_list.get(i);
			int product_id = Integer.parseInt((String) product_map.get("product_id"));
			int product_num = Integer.parseInt((String) product_map.get("product_num"));
			result += productMapper.sellProduct(sell_no, product_id, user_id, product_num, sales_user_id, sell_date);
		}
		
		if(product_list.size()==result) {
			return 1;
		}
		
		return 0;
	}
	
	@Override
	public List<HashMap> selectAllSellProduct() {
		List<HashMap> list = productMapper.selectAllSellProduct();
		return list;
	}

	@Override
	public List<HashMap> selectSellProductDetails(int sell_no) {
		List<HashMap> list = productMapper.selectSellProductDetails(sell_no);
		return list;
	}

	@Override
	public int sellProductModify(List product_list, String user_id, String sales_user_id, int sell_no, String sell_date) {
		//1. 삭제
		productMapper.sellProductDelete(sell_no);
		//2. 추가
		int result = 0;
		for(int i=0; i<product_list.size(); i++) {
			Map product_map = (Map)product_list.get(i);
			int product_id = Integer.parseInt((String) product_map.get("product_id"));
			int product_num = Integer.parseInt((String) product_map.get("product_num"));
			result += productMapper.sellProduct(sell_no, product_id, user_id, product_num, sales_user_id, sell_date);
		}
		
		if(product_list.size()==result) {
			return 1;
		}
		
		return result;
	}

	@Override
	public int sellProductDelete(int sell_no) {
		return productMapper.sellProductDelete(sell_no);
	}

	@Override
	public int receivingProduct(List product_list, String receiving_user_id) {
		int result = 0;
		
		//현재날짜
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar c1 = Calendar.getInstance();
		String receiving_date = sdf.format(c1.getTime());
		for(int i=0; i<product_list.size(); i++) {
			Map product_map = (Map)product_list.get(i);
			int product_id = Integer.parseInt((String) product_map.get("product_id"));
			int receiving_order = productMapper.getMaxReceivingOrder(product_id);
			int product_num = Integer.parseInt((String) product_map.get("product_num"));
			result += productMapper.receivingProduct(product_id, receiving_order, product_num, receiving_user_id, receiving_date);
		}
		
		if(product_list.size()==result) {
			return 1;
		}
		
		return 0;
	}

	@Override
	public List<HashMap> selectAllReceivingProduct() {
		List<HashMap> list = productMapper.selectAllReceivingProduct();
		return list;
	}

	@Override
	public List<HashMap> selectReceivingProductDetails(int product_id) {
		List<HashMap> list = productMapper.selectReceivingProductDetails(product_id);
		return list;
	}

	@Override
	public HashMap receivingProductModify(int product_id, int receiving_order) {
		HashMap map = productMapper.receivingProductModify(product_id, receiving_order);
		return map;
	}

	@Override
	public int receivingProductModify(Map params) {
		int product_id = Integer.parseInt((String) params.get("product_id"));
		int receiving_order = Integer.parseInt((String) params.get("receiving_order"));
		int receiving_num = Integer.parseInt((String) params.get("receiving_num"));
		int result = productMapper.receivingProductModifyAction(product_id, receiving_order, receiving_num);
		return result;
	}

}
