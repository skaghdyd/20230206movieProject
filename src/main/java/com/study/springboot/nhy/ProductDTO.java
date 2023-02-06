package com.study.springboot.nhy;

import lombok.Data;

@Data
public class ProductDTO {
	private int product_id;
	private String product_name;
	private int product_price;
	private int product_stock;
}
