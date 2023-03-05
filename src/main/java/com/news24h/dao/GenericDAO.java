package com.news24h.dao;

import java.util.List;

import com.news24h.mapper.RowMapper;
import com.news24h.model.NewModel;

public interface GenericDAO<T> {

<T>List<T>query(String sql,RowMapper<T> rowMapper ,Object...parameters);
void update (String sql, Object...parameter);
Long insert (String sql, Object...parameter);
void delete (String sql,Object...parameter);
int count(String sql,Object...parameter);

}
