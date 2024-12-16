package com.voicetotextapi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.voicetotextapi.repository.SpeechRecordsRepository;
import com.voicetotextapi.repository.entity.SpeechRecord;
import com.voicetotextapi.service.TranscriptHistoryService;
import com.voicetotextapi.service.dto.TranscriptHistoryServiceOutDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TranscriptHistoryServiceImpl implements TranscriptHistoryService {

	private final SpeechRecordsRepository repository;

	@Override
	public List<TranscriptHistoryServiceOutDto> getTranscriptRecords() {

		// Select records from database
		List<SpeechRecord> speechRecords = repository.findAll(Sort.by(Sort.Direction.DESC, "createdAt"));

		List<TranscriptHistoryServiceOutDto> serviceOutDtos = new ArrayList<>();
		
		speechRecords.forEach(s -> {
			TranscriptHistoryServiceOutDto outDto = new TranscriptHistoryServiceOutDto();
			BeanUtils.copyProperties(s, outDto);
			serviceOutDtos.add(outDto);
		});

		return serviceOutDtos;
	}

}
