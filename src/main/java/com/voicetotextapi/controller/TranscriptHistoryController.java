package com.voicetotextapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voicetotextapi.controller.dto.TranscriptHistoryResponse;
import com.voicetotextapi.service.TranscriptHistoryService;
import com.voicetotextapi.service.dto.TranscriptHistoryServiceOutDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class TranscriptHistoryController {

	private final TranscriptHistoryService service;

	@CrossOrigin
	@GetMapping("/getTranscriptRecords")
	public List<TranscriptHistoryResponse> convertAudioDataToTranscript() {

		List<TranscriptHistoryServiceOutDto> outDtos = service.getTranscriptRecords();
		List<TranscriptHistoryResponse> response = new ArrayList<>();

		BeanUtils.copyProperties(outDtos, response);

		outDtos.forEach(s -> {
			TranscriptHistoryResponse res = new TranscriptHistoryResponse();
			BeanUtils.copyProperties(s, res);
			response.add(res);
		});

		return response;

	}

}
