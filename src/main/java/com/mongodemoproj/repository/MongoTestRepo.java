package com.mongodemoproj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mongodemoproj.entity.Mongotest;

@Repository
public interface MongoTestRepo extends MongoRepository<Mongotest, String> {
	
	Mongotest findByAa(String aa);
	List<Mongotest> findByAaGreaterThan(String aa);

}
