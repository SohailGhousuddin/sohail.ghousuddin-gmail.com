package com.mastercard.challenge;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "app")
public class AppProperties {

    private String pathInfo;

	public String getPathInfo() {
		return pathInfo;
	}

	public void setPathInfo(String pathInfo) {
		this.pathInfo = pathInfo;
	}
   
}
