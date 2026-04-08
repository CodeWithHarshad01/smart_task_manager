package com.codewithharshad01.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithharshad01.entity.Project;

public interface ProjectRepo extends JpaRepository<Project,Long> {

}
