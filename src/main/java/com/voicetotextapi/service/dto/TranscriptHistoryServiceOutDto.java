package com.voicetotextapi.service.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TranscriptHistoryServiceOutDto {

	private Long id;

	private String transcript;

	private Date createdAt;

	private Date updatedAt;

}
