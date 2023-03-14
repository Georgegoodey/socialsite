package com.example.mdbspringboot.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.mdbspringboot.model.Profile;

interface ProfileRepository extends ReactiveMongoRepository<Profile, String> {
}