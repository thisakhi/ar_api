package com.sakthiit.service;

import org.springframework.stereotype.Service;

import com.sakthiit.binding.CitizenApp;

@Service
public interface ArService {
	
	public Integer CreateApplication(CitizenApp  app);
}
