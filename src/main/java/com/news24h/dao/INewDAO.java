package com.news24h.dao;

import java.util.List;

import com.news24h.model.NewModel;
import com.news24h.paging.PageRequest;
import com.news24h.paging.Pageble;
public interface INewDAO extends GenericDAO<NewModel> {
NewModel findOne(long id);
List<NewModel>findByCategoryId(Long categoryId);
Long save(NewModel newModel);
void update(NewModel newModel);
void delete(long id) ;

int getTotalItem();
List<NewModel>findAll(Pageble pageble);
}

