package com.voicetotextapi.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.voicetotextapi.repository.SpeechRecordsRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class DatabaseMaintainanceScheduler {

	private final SpeechRecordsRepository repository;

	/**
	 * Replace records in speech_records table every 24 hours
	 */
	@Scheduled(fixedRate = 86400000)
	@Transactional
	public void maintainDatabasePeriodically() {
		// Truncate table
		repository.truncateTable();

		// Insert sample data
		repository.insertFixedDateData(
				"As an illustration Australia has supported the view that the liberty of movement is a core in an eight human rights principal rather than a privilege thanks to this the country has prospered economically");
		repository.insertFixedDateData(
				"Most immigrants moved to foreign countries either for better employment opportunities and income or for an improved living environment.");
	}
}
