package com.voicetotextapi.service;

import com.voicetotextapi.service.dto.TranscriptConvertionServiceInDto;
import com.voicetotextapi.service.dto.TranscriptConvertionServiceOutDto;

public interface TranscriptConvertionService {

	public TranscriptConvertionServiceOutDto convertAudioDataToTranscript(
			TranscriptConvertionServiceInDto serviceInDto);

}
