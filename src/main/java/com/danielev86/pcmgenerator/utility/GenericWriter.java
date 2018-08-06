package com.danielev86.pcmgenerator.utility;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GenericWriter {

	public void writeOnFile(String outFile, List<String> queries) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(outFile)));
		for (String query: queries) {
			writer.append(query);
			writer.newLine();
		}
		writer.close();
	}
	
}
