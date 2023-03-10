package com.news24h.dao;

import java.util.List;

import com.news24h.model.CategoryModel;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
	 List<CategoryModel> findAll();
	 CategoryModel findOne(long id);
	 CategoryModel findOneByCode(String code);
	}
