package com.voicetotextapi.service;

import java.util.List;

import com.voicetotextapi.service.dto.TranscriptHistoryServiceOutDto;

public interface TranscriptHistoryService {

	public List<TranscriptHistoryServiceOutDto> getTranscriptRecords();

}
