package com.anushibin007.filerbackend.service;

import java.io.IOException;
import java.io.OutputStream;

import com.anushibin007.filerbackend.util.Constants;

/**
 * This class generates a file filled with null bytes inside it.
 * 
 * @author anushibin007
 *
 */
public class NullFileGenerationService implements FileGenerationService {

	/**
	 * Create a file with its body as null bytes
	 */
	public void writeToFileStream(long sizeInBytes, OutputStream out) throws IOException {
		byte[] buffer = new byte[Constants.BUFFER_SIZE];
		long remaining = sizeInBytes;

		while (remaining > 0) {
			int chunkSize = (int) Math.min(buffer.length, remaining);
			out.write(buffer, 0, chunkSize);
			remaining -= chunkSize;
		}
	}

	@Override
	public String generateFileName(long sizeInBytes) {
		return "filer-null-filled-" + sizeInBytes + ".bin";
	}
}
