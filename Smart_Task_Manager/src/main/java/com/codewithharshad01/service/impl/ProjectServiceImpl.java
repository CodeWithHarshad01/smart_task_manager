package com.codewithharshad01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithharshad01.entity.Project;
import com.codewithharshad01.exception.ResourceNotFoundException;
import com.codewithharshad01.repo.ProjectRepo;
import com.codewithharshad01.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepo projectRepo;

	@Override
	public Project addProject(Project project) {
		Project save = projectRepo.save(project);
		return save;
	}

	@Override
	public Project getProjectById(long id) {
		Project optional = projectRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("project not found with id :" + id));
		return optional;
	}

	@Override
	public Project updateProject(Project project, long id) {
		Project project2 = projectRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("project not found with id :"+id));
		project2.setName(project.getName());
		project2.setDescription(project.getDescription());
		Project save = projectRepo.save(project2);
		return save;
	}

	@Override
	public List<Project> getAllProject() {
		List<Project> all = projectRepo.findAll();
		return all;
	}

	@Override
	public void deleteProject(long id) {
		Project project = projectRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("project not found with id :"+id));
		projectRepo.delete(project);

	}

}
