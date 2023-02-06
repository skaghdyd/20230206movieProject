package com.study.springboot.nhy;

import java.util.List;

import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductMapper productMapper;
	
	@GetMapping("/list")
	public String selectAll(Model model) {
		List<ProductDTO> list = productMapper.selectAll();
		for (ProductDTO productDTO : list) {
			System.out.println(productDTO);
		}
		model.addAttribute("list", list);
		return "nhy/list";
	}
}
