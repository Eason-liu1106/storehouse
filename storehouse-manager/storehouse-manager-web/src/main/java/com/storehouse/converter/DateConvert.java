package com.storehouse.converter;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

public class DateConvert implements Converter<String, Date> {

//	 public Date convert(String stringDate) {
//		 //SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy",Locale.US);
//	        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	   
//	        	
//	        	System.out.println(stringDate);
//	            
//	            try {
//					return simpleDateFormat.parse(stringDate);
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        	
//	      
//	        return null;
//	    }
	
	/** date format 格式*/
    private static final String[] PATTERNS = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "HH:mm:ss"};
    @Override
    public Date convert(String s) {
        if(!StringUtils.isBlank(s)) {
            try {
                return DateUtils.parseDateStrictly(s, PATTERNS);
            } catch (ParseException e) {
                //异常时参数绑定失败
            }
        }
        return null;
    }

}
