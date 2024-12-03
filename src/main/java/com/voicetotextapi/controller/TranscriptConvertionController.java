package com.voicetotextapi.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.voicetotextapi.controller.dto.TranscriptConvertionResponse;
import com.voicetotextapi.service.TranscriptConvertionService;
import com.voicetotextapi.service.dto.TranscriptConvertionServiceInDto;
import com.voicetotextapi.service.dto.TranscriptConvertionServiceOutDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TranscriptConvertionController {

	private final TranscriptConvertionService service;

	@CrossOrigin
	@PostMapping("/convertAudioDataToTranscript")
	public TranscriptConvertionResponse convertAudioDataToTranscript(@RequestParam("file") MultipartFile req) {

		TranscriptConvertionServiceInDto serviceInDto = new TranscriptConvertionServiceInDto();
		serviceInDto.setAudiofile(req);

		TranscriptConvertionServiceOutDto serviceOutDto = service.convertAudioDataToTranscript(serviceInDto);

		TranscriptConvertionResponse res = new TranscriptConvertionResponse();
		res.setTranscriptText(serviceOutDto.getTranscriptText());

		return res;

	}

}
