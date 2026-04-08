package com.codewithharshad01.service;

import java.util.List;
import java.util.Optional;

import com.codewithharshad01.entity.Project;

public interface ProjectService {
	
	public Project addProject (Project project);
	
	public Optional<Project> getProjectById(long id);

	public Optional<Project> updateProject(Project project, long id);

	public List<Project> getAllProject();

	public void deleteProject(long id);

}
