package com.voicetotextapi.controller.dto;

import java.util.Date;

import lombok.Data;

@Data
public class TranscriptHistoryResponse {

	private Long id;

	private String transcript;

	private Date createdAt;

	private Date updatedAt;
}
