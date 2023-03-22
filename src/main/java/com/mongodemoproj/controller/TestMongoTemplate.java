package com.mongodemoproj.controller;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodemoproj.entity.Mongotest;
import com.mongodemoproj.repository.MongoTestRepo;

@RestController
public class TestMongoTemplate {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	MongoTestRepo mongoTestRepo;
	
	@PostMapping("/setData/{num}")
	public JSONObject testMongo(@PathVariable String num) {
		
		JSONObject jsonObject = new JSONObject();
		jsonObject.putOpt("aa", "test"+num);
		jsonObject.putOpt("ss", "test"+num);
		jsonObject.putOpt("dd", "test"+num);
		jsonObject.putOpt("ff", "test"+num);
		System.err.println("DATA saved");

		mongoTemplate.save(jsonObject.toString(),"TEST_COLLECTION");
		return jsonObject;
		
	}
	
	@GetMapping("/getData/{aa}/{val}/{newval}")
	public String test1Mongo(@PathVariable String aa, @PathVariable String val,@PathVariable String newval) {
		
		Query query = new Query(Criteria.where(aa).is(val));
		Mongotest mongotest=mongoTemplate.findOne(query,Mongotest.class, "TEST_COLLECTION"); 
		
//		System.err.println(mongotest.getId());
		mongotest.setAa(newval);
		mongoTemplate.save(mongotest); 
		System.err.println(mongotest.toString());
		return null;
	}
	
	@GetMapping("/updateData/{aa}/{val}/{newval}")
	public String test2Mongo(@PathVariable String aa, @PathVariable String val,@PathVariable String newval) {
		
		//No need to give explicitely @Id in entity
		Query query = new Query(Criteria.where(aa).is(val));
		Update update = new Update().set(aa, newval);
		System.err.println(mongoTemplate.updateFirst(query, update, "TEST_COLLECTION")); // Check if the data was updated
																						//Successfully or not
		System.err.println("UPDATED");
		
		return null;
	}
	
	
	// USING THIS method ---------
	// EITHER keep the annotation --- @ID
	// OR keep the variable name as id for this to work---- varna ek naya document add ho jaayega
	
	@GetMapping("/getByRepo/{aa}/{val}")
	public String test3Mongo(@PathVariable String aa, @PathVariable String val) {
		
		Mongotest mongotest=mongoTestRepo.findByAa(val);
//		System.err.println(new JSONArray(mongotest));
		mongotest.setDd("TRUE");
		mongoTestRepo.save(mongotest);
		
		return null;
	}
	
}
