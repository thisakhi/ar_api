package com.sakthiit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sakthiit.binding.CitizenApp;
import com.sakthiit.service.ArService;

@RestController
public class ArRestController {
	
	@Autowired
	private ArService service;
	
	@PostMapping("/app")
	public ResponseEntity<String> CreateCitizenApp(@RequestBody CitizenApp app){
		
		Integer appId= service.CreateApplication(app);
		if(appId >0) {
			
			return new ResponseEntity<>("Application Created with App ID : "+appId, HttpStatus.OK);
			
		}else {
			return new ResponseEntity<>("Invalid SSN", HttpStatus.BAD_REQUEST);
		}
	}

}
