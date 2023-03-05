 package com.news24h.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.news24h.model.NewModel;
import com.news24h.model.UserModel;
import com.news24h.service.INewService;
import com.news24h.utils.HttpUtil;
import com.news24h.utils.SessionUtil;
@WebServlet(urlPatterns = {"/api-admin-new"})
public class NewAPI extends HttpServlet {
	 @Inject
	 private INewService newService;

	private static final long serialVersionUID = 1L;
	//create new
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		request.setCharacterEncoding("UT-8");//dữ liệu utf-8  gửi lên k bị lỗi phông
		response.setContentType("application/json");//định dạng dữ liệu nhận vào (json)
		NewModel newModel=HttpUtil.of(request.getReader()).toModel(NewModel.class);// mapping data với model
		//lay ten ng tao bai
		UserModel userModel= (UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL");
		newModel.setCreatedBy(userModel.getUserName());
		
		newModel= newService.save(newModel);
		mapper.writeValue(response.getOutputStream(),newModel);	//convert từ model sang kiểu dữ liệu trả về (json)
	
	}
	//update new
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel updateNew=HttpUtil.of(request.getReader()).toModel(NewModel.class);
		updateNew.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(request, "USERMODEL")).getUserName());
		updateNew=newService.update(updateNew);
		mapper.writeValue(response.getOutputStream(),updateNew);	
		
	}
	//delete new
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper=new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		NewModel newModel=HttpUtil.of(request.getReader()).toModel(NewModel.class);
		newService.delete(newModel.getIds());
		
		mapper.writeValue(response.getOutputStream(),"{}");
		
	}
}
