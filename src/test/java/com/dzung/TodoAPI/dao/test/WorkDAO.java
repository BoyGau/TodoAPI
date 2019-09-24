package com.dzung.TodoAPI.dao.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dzung.TodoAPI.entity.Work;

@Repository
public class WorkDAO {

	@Autowired
	private EntityManager em;

	@Transactional
	public void truncateTable() {
		Query query = em.createNativeQuery("TRUNCATE TABLE WORK");
		em.joinTransaction();
		query.executeUpdate();
		em.flush();
	}


	public List<Work> getWorkLists() {
		Query query = em.createNativeQuery("SELECT * FROM WORK", Work.class);

		List<Work> workList = query.getResultList();

		return workList;
	}
} 