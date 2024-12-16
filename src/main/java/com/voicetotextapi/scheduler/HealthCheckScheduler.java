package com.voicetotextapi.scheduler;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Health Check Scheduler to keep the application server and database active
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class HealthCheckScheduler {

	private final JdbcTemplate jdbcTemplate;

	/**
	 * Execute health check every five minutes
	 */
	@Scheduled(fixedRate = 300000)
	public void healthCheck() {
		jdbcTemplate.execute("SELECT 1");
		log.info("Execute health check");
	}
}
