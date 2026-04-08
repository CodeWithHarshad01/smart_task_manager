package com.codewithharshad01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithharshad01.entity.Project;
import com.codewithharshad01.exception.ResourceNotFoundException;
import com.codewithharshad01.service.ProjectService;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@PostMapping("/addProject")
	public ResponseEntity<Project> addProject(@RequestBody Project project) {
		 Project project2 = projectService.addProject(project);
		return ResponseEntity.ok(project2);
	}

	@GetMapping("/getProjectById/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable long id) {

		Project project = projectService.getProjectById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));

		return ResponseEntity.ok(project);
	}
}
