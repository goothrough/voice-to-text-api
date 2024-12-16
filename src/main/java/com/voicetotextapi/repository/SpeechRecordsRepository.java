package com.voicetotextapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.voicetotextapi.repository.entity.SpeechRecord;

public interface SpeechRecordsRepository extends JpaRepository<SpeechRecord, Long> {

	@Modifying
	@Transactional
	@Query(value = "TRUNCATE TABLE speech_records RESTART IDENTITY", nativeQuery = true)
	void truncateTable();

	// To insert sample data
	@Modifying
	@Transactional
	@Query(value = "INSERT INTO speech_records (transcript, created_at, updated_at) VALUES (:transcript, now(), now())", nativeQuery = true)
	void insertFixedDateData(@Param("transcript") String transcript);

}
