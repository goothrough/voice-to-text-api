package com.voicetotextapi.service.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class TranscriptConvertionServiceInDto {

	private MultipartFile audiofile;

}
