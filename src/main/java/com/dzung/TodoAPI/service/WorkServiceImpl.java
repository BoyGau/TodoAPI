package com.dzung.TodoAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dzung.TodoAPI.dao.WorkDAO;
import com.dzung.TodoAPI.entity.Work;

@Service
public class WorkServiceImpl implements WorkService {
	
	@Autowired
	private WorkDAO workDao;
	
	@Override
	public void addWork(Work work) {
		workDao.insertWork(work);
	}
	
	@Override
	public void deleteWork(int id) {
		workDao.deleteWork(id);
	}
	
	@Override
	public void editWork(Work work, int id) {
		workDao.updateWork(work, id);
	}
	
	@Override
	public List<Work> getWorks(String sortBy, String orderBy, int limit, int offset) {
		return workDao.getWorks(sortBy, orderBy, limit, offset);
	}
}
