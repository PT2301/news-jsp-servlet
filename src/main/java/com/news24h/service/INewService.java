package com.news24h.service;

import java.util.List;

import com.news24h.model.NewModel;
import com.news24h.paging.Pageble;

public interface INewService {
List<NewModel>findByCategoryId(Long categoryId);
NewModel save(NewModel newModel );
NewModel update(NewModel updateNew);
void delete(long[] ids);
int getTotalItem();
List<NewModel> findAll(Pageble pageble);
NewModel findOne(Long id);

}
