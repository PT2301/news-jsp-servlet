package com.news24h.service;

import java.util.List;

import com.news24h.model.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAll();
}
