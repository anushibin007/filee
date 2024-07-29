package com.anushibin007.filerbackend.service;

import java.io.IOException;
import java.io.OutputStream;

/**
 * The service interface that needs to be extended by other implementations to
 * generate files of different types.
 * 
 * @author ajosephr
 *
 */
public interface FileGenerationService {
	public void writeToFileStream(long sizeInBytes, OutputStream out) throws IOException;

	public String generateFileName(long sizeInBytes);
}
