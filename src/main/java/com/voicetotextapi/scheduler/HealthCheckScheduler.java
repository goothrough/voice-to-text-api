package com.voicetotextapi.scheduler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * Health Check Scheduler to keep the application server and database active
 */
@Component
@Slf4j
public class HealthCheckScheduler {

	@Value("${spring.application.url}")
	private String APP_URL;

	/**
	 * Execute health check every five minutes
	 */
	@Scheduled(fixedRate = 300000)
	public void healthCheck() {
		RestTemplate restTemplate = new RestTemplate();
		String healthCheckUrl = APP_URL + "/health";
		restTemplate.getForObject(healthCheckUrl, String.class);
		log.info("Execute health check");
	}
}
