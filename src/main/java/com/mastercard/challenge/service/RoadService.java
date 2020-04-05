package com.mastercard.challenge.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.challenge.domain.RoadCities;

@Service
public class RoadService {
	
	 final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private RoadCities graph;
	
	public RoadService(){}
	
	public void initialize(String data)
	{
		LOGGER.info(data);
		graph.createGraph(data);	
		graph.printRoads();		
		
	}
	
	public String getConnection(String src, String dest) {
		return graph.getNeighbor(src,dest);
	}
	
	

}
