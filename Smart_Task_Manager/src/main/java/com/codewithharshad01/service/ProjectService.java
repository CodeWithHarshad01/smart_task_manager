package com.codewithharshad01.service;

import java.util.List;

import com.codewithharshad01.entity.Project;

public interface ProjectService {
	
	public Project addProject (Project project);
	
	public Project getProjectById(long id);

	public Project updateProject(Project project, long id);

	public List<Project> getAllProject();

	public void deleteProject(long id);

}
