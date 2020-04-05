package com.mastercard.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mastercard.challenge.service.RoadService;

@RestController
public class ConnectedController {
	@Autowired
	private RoadService roadService;
	
	@GetMapping(value="/connected")
	public String conected(@RequestParam String origin,@RequestParam String destination)	
	{
		return roadService.getConnection(origin, destination);

	}

}
