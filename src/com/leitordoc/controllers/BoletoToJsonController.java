package com.leitordoc.controllers;

import com.leitordoc.services.BoletoToJsonService;
import com.leitordoc.repositories.SaveJsonRepository;

public class BoletoToJsonController {

	public static void convert(String inputFilePath, String outputFilePath) {
		BoletoToJsonService.convert(inputFilePath);
		
//		SaveJsonRepository.save(outputFilePath, JSONString)
	}
}
