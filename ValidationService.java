package com.target.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {

	public boolean validateContent(String input)
	{
		Boolean isAllowed = true;
		InputStream inputFile = null;
		Properties prop = new Properties();
		try {
		inputFile = new FileInputStream("/Target/src/com/target/main/keyword.properties");
		prop.load(inputFile);
		
		String objectionalWords = prop.getProperty("stopWords");
		
		String[] objectionalWord = objectionalWords.split("|");
		
		String[] inputWords = input.split(" ");
		
		for(String s : objectionalWord)
		{
			if(input.contains(s))
				isAllowed = false;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isAllowed;
	}
}
