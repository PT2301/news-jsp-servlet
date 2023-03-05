package com.news24h.utils;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
//mapping data vao model
public class FormUtil {
	@SuppressWarnings("unchecked")
	//mapping tu cac parametr vao cao thuoc tinh cua doi tg 
	public static <T>T toModel(Class<T> clazz,HttpServletRequest request){
		T object=null;
		try {
			object=clazz.newInstance();
		    BeanUtils.populate(object,request.getParameterMap());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return object;
		
	}
}
