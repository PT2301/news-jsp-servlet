package com.news24h.service;

import com.news24h.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPasswordAndSTatus(String userName, String password, Integer status);
}
