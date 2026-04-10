package com.codewithharshad01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codewithharshad01.entity.Project;
import com.codewithharshad01.service.ProjectService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@PostMapping("/addProject")
	public ResponseEntity<Project> addProject(@Valid @RequestBody Project project) {
		Project project2 = projectService.addProject(project);
		return ResponseEntity.ok(project2);
	}

	@GetMapping("/getProjectById/{id}")
	public ResponseEntity<Project> getProjectById(@PathVariable long id) {
		Project project = projectService.getProjectById(id);
		return ResponseEntity.ok(project);
	}

	@PutMapping("/updateProject/{id}")
	public ResponseEntity<Project> updateProject(@Valid @RequestBody Project project, @PathVariable long id) {
		Project updateProject = projectService.updateProject(project, id);
		return ResponseEntity.ok(updateProject);
	}

	@GetMapping("/getAllProject")
	public ResponseEntity<List<Project>> getAllProject() {
		List<Project> allProject = projectService.getAllProject();
		return ResponseEntity.ok(allProject);
	}
	
	@DeleteMapping("/deleteProject/{id}")
		public ResponseEntity<?>deleteProject(@PathVariable long id){
		projectService.deleteProject(id);
		return ResponseEntity.ok("project deleted succesfully");
		}
	}

