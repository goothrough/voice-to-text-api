package com.voicetotextapi.controller;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

/**
 * Health Check Controller to keep the application server and database active
 */
@RestController
@RequiredArgsConstructor
public class HealthCheckController {

	private final JdbcTemplate jdbcTemplate;

	@GetMapping("/health")
	public void healthCheck() {

		jdbcTemplate.execute("SELECT 1");

	}
}
