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
import com.example.mdbspringboot.model.GroceryItem;

import java.net.URI;

@RestController
@RequestMapping(value = "/profiles", produces = { MediaType.APPLICATION_JSON_VALUE })
public class MainController {

	// @ExceptionHandler(EventNotFoundException.class)
	// @ResponseStatus(HttpStatus.NOT_FOUND)
	// public String eventNotFoundHandler(EventNotFoundException ex, Model model) {
	// 	model.addAttribute("not_found_id", ex.getId());

	// 	return "not_found";
	// }

	private final MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
    @Autowired
	private final ProfileService profileService;

	MainController(ProfileService profileService) {
        this.profileService = profileService;
    }

	@GetMapping
	public Publisher<GroceryItem> getAll() {
		// model.addAttribute("eventsPast", eventService.findAllPast());
		// model.addAttribute("eventsUpcoming", eventService.findAllUpcoming());
		return this.profileService.all();
	}

}
