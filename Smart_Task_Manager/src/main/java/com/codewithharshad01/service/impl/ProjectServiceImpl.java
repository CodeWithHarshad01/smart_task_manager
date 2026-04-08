package com.codewithharshad01.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithharshad01.entity.Project;
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
	public Optional<Project> getProjectById(long id) {
		Optional<Project> optional = projectRepo.findById(id);
		return optional;
	}

	@Override
	public Optional<Project> updateProject(Project project, long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Project> getAllProject() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProject(long id) {
		// TODO Auto-generated method stub

	}

}
