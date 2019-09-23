package com.dzung.TodoAPI.dao;

import java.util.List;

import com.dzung.TodoAPI.entity.Work;

public interface WorkDAO {
	public void insertWork(Work work);
	
	public void updateWork(Work work, int id);
	
	public void deleteWork(int id);
	
	public List<Work> getWorks(String sortBy, String orderBy, int limit, int offset);
}
