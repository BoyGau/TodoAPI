package com.dzung.TodoAPI.test;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.dzung.TodoAPI.dao.test.WorkDAO;
import com.dzung.TodoAPI.entity.Work;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoApiApplicationTests {

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@LocalServerPort
	private int port;

	@Autowired
	private WorkDAO workDao;

	@Test
	public void testAddWork() throws ParseException {
		// before test
		workDao.truncateTable();

		// prepare insert data

		String name1 = "Test work";

		SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy/MM/dd");
		isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));

		Date startDate1 = isoFormat.parse("2018/01/10");
		Date endDate1 = isoFormat.parse("2019/02/20");
		int status1 = Work.STATUS_PLANNING;

		String name2 = "Test work 2";
		Date startDate2 = isoFormat.parse("2017/03/15");
		Date endDate2 = isoFormat.parse("2020/02/10");
		int status2 = Work.STATUS_COMPLETED;

		// given
		Work work1 = new Work();
		work1.setName(name1);
		work1.setStartDate(startDate1);
		work1.setEndDate(endDate1);
		work1.setStatus(status1);

		Work work2 = new Work();
		work2.setName(name2);
		work2.setStartDate(startDate2);
		work2.setEndDate(endDate2);
		work2.setStatus(status2);

		// when
		// 1st
		HttpEntity<Work> entity1 = new HttpEntity<Work>(work1);

		ResponseEntity<String> response1 = restTemplate.exchange(
				createURLWithPort("/api/todo"), 
				HttpMethod.POST, 
				entity1, String.class);

		// 2nd
		HttpEntity<Work> entity2 = new HttpEntity<Work>(work2);

		ResponseEntity<String> response2 = restTemplate.exchange(
				createURLWithPort("/api/todo"), 
				HttpMethod.POST, 
				entity2, String.class);

		// then
		// Response http status
		assertEquals(HttpStatus.OK, response1.getStatusCode());
		assertEquals(HttpStatus.OK, response2.getStatusCode());

		// database insertion test

		List<Work> workList = workDao.getWorkLists();

		assertEquals(workList.size(), 2);

		Work result1 = workList.get(0);
		Work result2 = workList.get(1);

		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy/MM/dd");

		assertEquals(1, result1.getId());
		assertEquals(name1, result1.getName());
		assertEquals(sdf.format(startDate1), sdf.format(result1.getStartDate()));
		assertEquals(sdf.format(endDate1), sdf.format(result1.getEndDate()));
		assertEquals(status1, result1.getStatus());

		assertEquals(2, result2.getId());
		assertEquals(name2, result2.getName());
		assertEquals(sdf.format(startDate2), sdf.format(result2.getStartDate()));
		assertEquals(sdf.format(endDate2), sdf.format(result2.getEndDate()));
		assertEquals(status2, result2.getStatus());

	}



	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}