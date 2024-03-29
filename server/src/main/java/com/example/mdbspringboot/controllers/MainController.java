package com.example.mdbspringboot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.mdbspringboot.repository.ProfileService;
import com.example.mdbspringboot.model.Profile;

import java.net.URI;

@RestController
@RequestMapping(value = "/Profiles", produces = { MediaType.APPLICATION_JSON_VALUE })
public class MainController {

	// @ExceptionHandler(EventNotFoundException.class)
	// @ResponseStatus(HttpStatus.NOT_FOUND)
	// public String eventNotFoundHandler(EventNotFoundException ex, Model model) {
	// 	model.addAttribute("not_found_id", ex.getId());

	// 	return "not_found";
	// }

	private final MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
    @Autowired
	private final ProfileService ProfileService;

	MainController(ProfileService ProfileService) {
        this.ProfileService = ProfileService;
    }

	@GetMapping
	public Publisher<Profile> getAll() {
		return this.ProfileService.all();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Mono<Profile> addProfile(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "email", required = false) String email){
		Profile p = new Profile("0", name, email);
		return this.ProfileService.save(p);
	}

}
