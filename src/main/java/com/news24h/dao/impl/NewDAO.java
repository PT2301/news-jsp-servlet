	package com.news24h.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.news24h.dao.INewDAO;
import com.news24h.mapper.NewMapper;
import com.news24h.model.NewModel;
import com.news24h.paging.Pageble;

public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

	@Override
	public List<NewModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT*FROM news WHERE categoryId=?";
		return query(sql, new NewMapper(), categoryId);
	}

	@Override
	public Long save(NewModel newModel)  {
		String sql="insert into news(title,content,categoryid,thumbnail,shortdescription,createdby,createddate) values(?,?,?,?,?,?,?)";
		return insert(sql, newModel.getTitle(),newModel.getContent(),newModel.getCategoryId(),newModel.getThumbnail()
				,newModel.getShortDescription(),newModel.getCreatedBy(),newModel.getCreatedDate());
		
	}

	@Override
	public void update(NewModel updateNew) {
		StringBuilder sql=new StringBuilder("UPDATE news SET title=?,content=?,categoryid=?,thumbnail=?,shortdescription=?,");
		sql.append("createddate=?,createdby=?,modifiedby=?,modifieddate=? WHERE id=?");
		update(sql.toString(),updateNew.getTitle(),updateNew.getContent(),updateNew.getCategoryId(),
				updateNew.getThumbnail(),updateNew.getShortDescription(),updateNew.getCreatedDate(),
				updateNew.getCreatedBy(),updateNew.getModifiedBy(),updateNew.getModifiedDate(), updateNew.getId());
		
		
	}

	@Override
	public void delete(long id) {
		String sql="DELETE FROM news WHERE id=?";
		delete(sql,id);
		
	}

	@Override
	public NewModel findOne(long id) {
		String sql = "SELECT * FROM news WHERE id = ?";
		List<NewModel> news = query(sql, new NewMapper(), id);
		return news.isEmpty() ? null : news.get(0);
	}

	

	@Override
	public int getTotalItem() {
	String sql="SELECT count(*) FROM news";
		return count(sql);
	}

	@Override
	public List<NewModel> findAll(Pageble pageble) {
		StringBuilder sql =new StringBuilder("SELECT*FROM news");
		if(pageble.getSorter()!=null&& StringUtils.isNotBlank(pageble.getSorter().getSortName())&&StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
			sql.append(" ORDER BY "+pageble.getSorter().getSortName()+" "+pageble.getSorter().getSortBy()+"");
		}
		if(pageble.getOffset()!=null&&pageble.getLimit()!=null) {
			sql.append(" LIMIT "+pageble.getOffset()+","+pageble.getLimit()+"");
		}
		return query(sql.toString(), new NewMapper());
	}
}
