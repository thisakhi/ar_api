package com.sakthiit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.sakthiit.binding.CitizenApp;
import com.sakthiit.enity.CitizenAppEntiry;
import com.sakthiit.repo.CitizenAppRepositery;

@Service
public class ArServiceImpl implements ArService {
	@Autowired
	CitizenAppRepositery appRepo;

	public Integer CreateApplication(CitizenApp app) {

		String endpointUrl = "https://ssa-web-api.herokuapp.com/ssn/{ssn}";
		/*
		 * Rest Call
		 * 
		 * 
		 * RestTemplate rt = new RestTemplate();
		
		ResponseEntity<String> resEntity =  rt.getForEntity(endpointUrl, String.class, app.getSsn());
		String stateName = resEntity.getBody();*/
		
		/* Web client Call*/
		WebClient webClient = WebClient.create();

		String stateName = webClient.get()
				.uri(endpointUrl, app.getSsn())
				.retrieve()
				.bodyToMono(String.class)
				.block();
		
		
		
		if("New Jersey".equals(stateName)) {
			
			CitizenAppEntiry entity = new CitizenAppEntiry();
			BeanUtils.copyProperties(app, entity);
			entity.setStatename(stateName);
			appRepo.save(entity);
			
			return entity.getAppid();
		}
		
		return 0;

	}

}
