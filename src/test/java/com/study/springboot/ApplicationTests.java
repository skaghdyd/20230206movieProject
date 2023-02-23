package com.study.springboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.jnr.domain.HelpDTO;
import com.study.springboot.jnr.mapper.HelpMapper;
import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ApplicationTests {
	
	@Autowired
	HelpMapper helpMapper;

	@Test
	void contextLoads() {
	}

	@Test
	public void testMyBatisFindAll() {
		List<HelpDTO> list 
		= helpMapper.selectHelpAll();
		log.info(list);
	}
	
}
