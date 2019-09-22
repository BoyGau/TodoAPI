package com.dzung.TodoAPI.dao;

import java.util.List;

import com.dzung.TodoAPI.entity.Work;

public interface WorkDAO {
	public void insertWork(Work work);
	
	public void updateWork(Work work);
	
	public void deleteWork(Work work);
	
	public List<Work> getWorks();
}
