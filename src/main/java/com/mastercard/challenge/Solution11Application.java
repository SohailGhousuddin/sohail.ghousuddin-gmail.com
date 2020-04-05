package com.mastercard.challenge;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;

import com.mastercard.challenge.service.RoadService;

@SpringBootApplication
public class Solution11Application implements CommandLineRunner {
	
	  final Logger LOGGER = LoggerFactory.getLogger(getClass());
	  
	@Autowired
    private AppProperties appProperties;
	
	@Autowired
	private RoadService roadService;

	public static void main(String[] args) {
		SpringApplication.run(Solution11Application.class, args);
	}
	
	
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Resource resource = new ClassPathResource(appProperties.getPathInfo());
        InputStream inputStream = resource.getInputStream();
        System.out.println("file name:" + appProperties.getPathInfo());
        try {
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            String data = new String(bdata, StandardCharsets.UTF_8);
            roadService.initialize(data);
        
        } catch (IOException e) {
            LOGGER.error("IOException", e);
        }
		
		
	}

}
