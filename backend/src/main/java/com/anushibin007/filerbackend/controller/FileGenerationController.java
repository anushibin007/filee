package com.anushibin007.filerbackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.anushibin007.filerbackend.service.FileGenerationService;

@RestController
@RequestMapping("/api/v1")
public class FileGenerationController {

	@Autowired
	FileGenerationService nullFileGenerationService;

	@GetMapping("/getFile")
	public ResponseEntity<StreamingResponseBody> getFile(@RequestParam long sizeInBytes) {

		// Set the required headers to serve the file as a binary content
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", nullFileGenerationService.generateFileName(sizeInBytes));
		headers.setContentLength(sizeInBytes);

		// Set the stream to return the file to the client
		StreamingResponseBody stream = out -> nullFileGenerationService.writeToFileStream(sizeInBytes, out);

		return ResponseEntity.ok().headers(headers).body(stream);
	}

}
