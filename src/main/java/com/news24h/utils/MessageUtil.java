package com.news24h.utils;

import javax.servlet.http.HttpServletRequest;

import com.news24h.constant.SystemConstant;

public class MessageUtil {
	public static void showMessage(HttpServletRequest request) {
		if (request.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = request.getParameter("message");
			if (message.equals(SystemConstant.INSERT_SUCCESS)) {
				messageResponse = "Insert_success";
				alert = "success";
			} else if (message.equals(SystemConstant.UPDATE_SUCCESS)) {
				messageResponse = "Update_success";
				alert = "success";
			} else if (message.equals("delete_success")) {
				messageResponse = "Delete_success";
				alert = "success";
			} else if (message.equals("error_success")) {
				messageResponse = "Error_success";
				alert = "danger";
			}
			request.setAttribute("messageResponse",messageResponse);
			request.setAttribute("alert",alert);
		}

	}
}
