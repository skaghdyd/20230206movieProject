package com.study.springboot.khg.domain;

import lombok.Data;

@Data
public class Cus {
	private String cusId;
	private String cusName;
	private String Birth;
	private String Phone;
	private String Aaa;//Phone 뒷 4자리를 담는다.
	private String pDate;
	private String getP;
	private String res;
	private String point;
}
