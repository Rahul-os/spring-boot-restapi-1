package com.restapi.demo.repo;

import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.restapi.demo.entity.StudentEntity;

public interface StudentRepository extends MongoRepository<StudentEntity, Integer> {

}
