package com.study.springboot.nhy.service;

import java.util.List;

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

}
