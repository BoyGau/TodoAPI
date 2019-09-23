package com.dzung.TodoAPI.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dzung.TodoAPI.entity.Work;

@Repository
public class WorkDAOImpl implements WorkDAO {
	
	@Autowired
	private EntityManager em;
	
	@Transactional
	public void deleteWork(int id) {
		Work work = em.find(Work.class, id);
		
		em.remove(work);
	}
	
	@Transactional
	public void insertWork(Work work) {
		em.persist(work);
	}
	
	@Transactional
	public void updateWork(Work updateWork, int id) {
		Work work = em.find(Work.class, id);
		
		work.setName(updateWork.getName());
		work.setStartDate(updateWork.getStartDate());
		work.setEndDate(updateWork.getEndDate());
		work.setStatus(updateWork.getStatus());
		
		em.persist(work);
	}
	
	@Override
	public List<Work> getWorks(String sortBy, String orderBy, int limit, int offset) {
		Query query = em.createNativeQuery(
				"SELECT * FROM WORK ORDER BY " + sortBy + " " + orderBy + " LIMIT " + limit + " OFFSET " + offset);
		return query.getResultList();
	}
	
}
