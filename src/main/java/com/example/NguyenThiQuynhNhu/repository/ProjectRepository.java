package com.example.NguyenThiQuynhNhu.repository;

import com.example.NguyenThiQuynhNhu.entity.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends MongoRepository<Project, String> {
}
