package com.dzung.TodoAPI.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dzung.TodoAPI.entity.Work;
import com.dzung.TodoAPI.service.WorkService;
import com.dzung.TodoAPI.utility.StringConverter;

@RestController
@RequestMapping("/api")
public class WorkController {
	
	@Autowired
	private WorkService workService;
	
	// Add new work entry
	@PostMapping("/todo")
	public String addWork(@RequestBody Work work) {
		workService.addWork(work);
		
		return "Entry added!" ;
	}
	
	// Update entry by id
	@PutMapping("/todo/{id}")
	public String editWork(@RequestBody Work work, @PathVariable int id) {
		if (id == 0) {
			// TODO: thow exception because there are no record with ID = 0
			
		}
		workService.editWork(work, id);
		
		return "Entry updated!" ;
	}
	
	// Delete entry by id
	@DeleteMapping("/todo/{id}")
	public String deleteWork(@PathVariable int id) {
		if (id == 0) {
			// TODO: thow exception because there are no record with ID = 0
		}
		workService.deleteWork(id);
		
		return "Entry deleted!";
	}
	
	// Fetch list of work entries
	@GetMapping("/todo")
	public List<Work> getWork(@RequestParam(defaultValue = "endDate", value = "sort_by") String sortBy, 
			@RequestParam(defaultValue = "asc", value = "order_by") String orderBy,
			@RequestParam(defaultValue = "100", value = "limit") int limit, 
			@RequestParam(defaultValue = "0", value = "offset") int offset) {
		
		return workService.getWorks(StringConverter.convertCamelToUnderScore(sortBy), 
				StringConverter.convertCamelToUnderScore(orderBy), 
				limit, 
				offset);
	}
	
}