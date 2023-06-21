package com.example.mdbspringboot.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import com.example.mdbspringboot.model.Profile;

@Service
public class ProfileService {
	
    private final ApplicationEventPublisher publisher; 
    private final ProfileRepository profileRepository; 

    ProfileService(ApplicationEventPublisher publisher, ProfileRepository profileRepository) {
        this.publisher = publisher;
        this.profileRepository = profileRepository;
    }

	public Flux<Profile> all() {	
		return profileRepository.findAll();
	}

    public Mono<Profile> save(Profile p){
        return profileRepository.save(p);
    }

}
