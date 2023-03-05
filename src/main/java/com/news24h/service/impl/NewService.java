package com.news24h.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.news24h.dao.ICategoryDAO;
import com.news24h.dao.INewDAO;
import com.news24h.model.CategoryModel;
import com.news24h.model.NewModel;
import com.news24h.paging.Pageble;
import com.news24h.service.INewService;


public class NewService implements INewService{

	
	@Inject
	private INewDAO newDAO;
	@Inject
	private ICategoryDAO categoryDAO;
	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		
		return newDAO.findByCategoryId(categoryId);
	}
	@Override
	public NewModel save(NewModel newModel) {
		newModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category=categoryDAO.findOneByCode(newModel.getCategoryCode());
		newModel.setCategoryId(category.getId());
		Long newId=newDAO.save(newModel);
		return newDAO.findOne(newId);
	}
	@Override
	public NewModel update(NewModel updateNew) {
		NewModel oldNew=newDAO.findOne(updateNew.getId());
		updateNew.setCreatedDate(oldNew.getCreatedDate());
		updateNew.setCreatedBy(oldNew.getCreatedBy());
		updateNew.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		CategoryModel category=categoryDAO.findOneByCode(updateNew.getCategoryCode());
		updateNew.setCategoryId(category.getId());
		newDAO.update(updateNew);
		return newDAO.findOne(updateNew.getId());
	}
	@Override
	public void delete(long[] ids) {
		for(long id:ids) {
			newDAO.delete(id);
		}
		
	}
	@Override
	public int getTotalItem() {
		return newDAO.getTotalItem();
	}
	@Override
	public List<NewModel> findAll(Pageble pageble) {
		return newDAO.findAll(pageble);
	}
	@Override
	public NewModel findOne(Long id) {
		NewModel newModel=newDAO.findOne(id);
		CategoryModel categoryModel=categoryDAO.findOne(newModel.getCategoryId());
		newModel.setCategoryCode(categoryModel.getCode());
		return newModel;
	}

}