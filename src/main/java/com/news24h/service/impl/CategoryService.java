package com.news24h.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.news24h.dao.ICategoryDAO;
import com.news24h.model.CategoryModel;
import com.news24h.service.ICategoryService;

public class CategoryService implements ICategoryService {
    @Inject
    private ICategoryDAO categoryDao;
	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
	

}
