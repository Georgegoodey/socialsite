package com.example.mdbspringboot.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.mdbspringboot.model.GroceryItem;

interface ProfileRepository extends ReactiveMongoRepository<GroceryItem, String> {
}