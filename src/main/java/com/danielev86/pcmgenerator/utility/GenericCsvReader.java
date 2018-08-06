package com.danielev86.pcmgenerator.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GenericCsvReader {

	public List<Object[]> readCsvFile(String path, String split) throws IOException{
		List<Object[]> lstResult = new ArrayList<>();
		
		File file = new File(path);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		
		String lineReader;
		
		while ( (lineReader = reader.readLine()) != null ) {
			Object[] objs = lineReader.split(split);
			lstResult.add(objs);
		}
		
		reader.close();
		return lstResult;
	}
	
}
