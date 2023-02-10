package com.study.springboot.nhy.service;

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
	public List<ProductDTO> selectAllProduct() {
		List<ProductDTO> list = productMapper.selectAllProduct();
		return list;
	}

	@Override
	public int addProduct(ProductDTO productDTO) {
		int result = productMapper.addProduct(productDTO);
		return result;
	}

	@Override
	public int deleteProduct(List<Integer> selectedColumns) {
		
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
	public List<ProductDTO> searchProduct(String product_name) {
		List<ProductDTO> list = productMapper.searchProduct("%"+product_name+"%");
		return list;
	}

	@Override
	public int sellProduct(List product_list, String user_id, String sales_user_id) {
		int result = 0;
		
		int sell_no = productMapper.getMaxSellNo();
		for(int i=0; i<product_list.size(); i++) {
			Map product_map = (Map)product_list.get(i);
			int product_id = Integer.parseInt((String) product_map.get("product_id"));
			int product_num = Integer.parseInt((String) product_map.get("product_num"));
			result += productMapper.sellProduct(sell_no, product_id, user_id, product_num, sales_user_id);
		}
		
		if(product_list.size()==result) {
			return 1;
		}
		
		return 0;
	}

}
