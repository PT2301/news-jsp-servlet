package com.news24h.service.impl;

import javax.inject.Inject;

import com.news24h.dao.IUserDAO;
import com.news24h.model.UserModel;
import com.news24h.service.IUserService;

public class UserService implements IUserService{
	@Inject
	private IUserDAO userDAO;

	@Override
	public UserModel findByUserNameAndPasswordAndSTatus(String userName, String password, Integer status) {
		return userDAO.findByUserNameAndPasswordAndSTatus(userName, password, status);
	}

}
