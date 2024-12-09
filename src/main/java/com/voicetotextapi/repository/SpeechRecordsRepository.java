package com.voicetotextapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.voicetotextapi.repository.entity.SpeechRecord;

public interface SpeechRecordsRepository extends JpaRepository<SpeechRecord, Long> {

}
