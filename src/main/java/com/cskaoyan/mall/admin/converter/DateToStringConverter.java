package com.cskaoyan.mall.admin.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateToStringConverter implements Converter<Date,String> {


	@Override
	public String convert(Date date) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String datetostring = simpleDateFormat.format(date);

		return datetostring;
	}
}
