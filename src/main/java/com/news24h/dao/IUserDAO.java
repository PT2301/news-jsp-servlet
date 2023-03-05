package com.news24h.dao;

import com.news24h.model.UserModel;
public interface IUserDAO extends GenericDAO<UserModel> {
 UserModel findByUserNameAndPasswordAndSTatus(String userName,String password,Integer status);
}

