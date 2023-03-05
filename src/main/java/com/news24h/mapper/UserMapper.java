package com.news24h.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.news24h.model.NewModel;
import com.news24h.model.RoleModel;
import com.news24h.model.UserModel;

public class UserMapper implements RowMapper<UserModel>{

	@Override
	public UserModel mapRow(ResultSet resultSet) {
		
		try {
			UserModel user=new UserModel();
			user.setId(resultSet.getLong("id"));
			user.setFullName(resultSet.getString("fullname"));
			user.setUserName(resultSet.getString("username"));
			user.setPassword(resultSet.getString("password"));
			user.setStatus(resultSet.getInt("status"));
			user.setRoleId(resultSet.getLong("roleid"));
			user.setCreatedBy(resultSet.getString("createdby"));
			user.setCreatedDate(resultSet.getTimestamp("createddate"));
			if(resultSet.getString("modifiedby")!=null) {
				user.setModifiedBy(resultSet.getString("modifiedby"));
			}
			if(resultSet.getTimestamp("modifieddate")!=null) {
				user.setModifiedDate(resultSet.getTimestamp("modifieddate"));	
			}
			RoleModel role=new RoleModel();
			role.setCode(resultSet.getString("code"));
			role.setName(resultSet.getString("name"));
			user.setRole(role);
			
			return user;
		} catch (SQLException e) {
			return null;
		}
		
	}

}
