package com.news24h.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {//đối tg SessionUtil được tạo ra từ httpRequest
    private static SessionUtil sessionUtil=null;

	public static SessionUtil getInstance() {
		if (sessionUtil == null) {
			sessionUtil = new SessionUtil();
		}
		return sessionUtil;
	}

	public void putValue(HttpServletRequest request,String key, Object value) {
		request.getSession().setAttribute(key, value);
		// co request để khởi tạo được session để get,set gtri
	}
    public Object getValue(HttpServletRequest request, String key) {
		return request.getSession().getAttribute(key);
    }
	
    public void removeValue(HttpServletRequest request,String key) {
         request.getSession().removeAttribute(key);
    }
}
