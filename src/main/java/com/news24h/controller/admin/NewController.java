package com.news24h.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.news24h.constant.SystemConstant;
import com.news24h.model.NewModel;
import com.news24h.paging.PageRequest;
import com.news24h.paging.Pageble;
import com.news24h.service.ICategoryService;
import com.news24h.service.INewService;
import com.news24h.sort.Sorter;
import com.news24h.utils.FormUtil;
import com.news24h.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-new"})
public class NewController extends HttpServlet {
	
	private static final long serialVersionUID = 2686801510274002166L;
	
	@Inject
	private INewService newService;
	@Inject
	private ICategoryService categoryService;
	//hien thi danh sach news
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NewModel model=FormUtil.toModel(NewModel.class, request);
		String view=null;
		if(model.getType().equals(SystemConstant.LIST)) {
			Pageble pageble=new PageRequest(model.getPage(),model.getMaxPageItem(),new Sorter(model.getSortName(),model.getSortBy()));
			model.setListResult(newService.findAll(pageble));
			model.setTotalItem(newService.getTotalItem());
			model.setTotalPage((int) Math.ceil((double)model.getTotalItem()/model.getMaxPageItem()));
			
			view="/views/admin/new/list.jsp";
		//them or sua bai
		}else if(model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId()!=null) {
				model=newService.findOne(model.getId());	
			}
			request.setAttribute("categorys",categoryService.findAll());
			view="/views/admin/new/edit.jsp";
		}
		MessageUtil.showMessage(request);         
		request.setAttribute(SystemConstant.MODEL,model);
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
