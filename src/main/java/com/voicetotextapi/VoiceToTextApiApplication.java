package com.voicetotextapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VoiceToTextApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VoiceToTextApiApplication.class, args);
	}

}
