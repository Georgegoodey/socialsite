package com.example.mdbspringboot.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.mdbspringboot.model.Profile;

public interface ItemRepository extends MongoRepository<Profile, String> {
	
	@Query("{name:'?0'}")
	Profile findItemByName(String name);
	
	@Query(value="{category:'?0'}", fields="{'name' : 1, 'quantity' : 1}")
	List<Profile> findAll(String category);
	
	public long count();

}
