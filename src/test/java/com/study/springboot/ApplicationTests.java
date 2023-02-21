package com.study.springboot;

import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.study.springboot.hch.domain.ScreenScheduleDTO;
import com.study.springboot.hch.mapper.ScreenScheduleMapper;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@Log4j2
class ApplicationTests {
	
	@Autowired
	ScreenScheduleMapper screenScheduleMapper;

	@Test
	void contextLoads() {
	}
	
	@Test
	@Disabled
	void selectScreenNames() {
		List<HashMap> lst = screenScheduleMapper.selectScreenNames();
		log.info(lst);
		log.info(lst.get(0).get("fstm"));
		
	}

}
