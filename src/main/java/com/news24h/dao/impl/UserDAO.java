package com.news24h.dao.impl;

import java.util.List;

import com.news24h.dao.IUserDAO;
import com.news24h.mapper.UserMapper;
import com.news24h.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPasswordAndSTatus(String userName, String password, Integer status) {
		StringBuilder sql = new StringBuilder ("SELECT * FROM user AS u");
		sql.append(" INNER JOIN role AS r ON r.id=u.roleid");
		sql.append(" WHERE username=? AND password=? AND status=?");
		List<UserModel>user=query(sql.toString(), new UserMapper(),userName,password,status);
		return user.isEmpty()?null:user.get(0);
	}
}
