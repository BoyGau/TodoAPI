package com.dzung.TodoAPI.service;

import java.util.List;

import com.dzung.TodoAPI.entity.Work;

public interface WorkService {
	public void addWork(Work work);
	
	public void editWork(Work work, int id);
	
	public void deleteWork(int id);
	
	public List<Work> getWorks(String sortBy, String orderBy, int limit, int offset);
}
