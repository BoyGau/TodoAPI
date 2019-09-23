package com.dzung.TodoAPI.service;

import java.util.List;

import com.dzung.TodoAPI.entity.Work;

public interface WorkService {
	public void addWork(Work work);
	
	public void editWork(Work work);
	
	public void deleteWork(Work work);
	
	public List<Work> getWorks();
}
