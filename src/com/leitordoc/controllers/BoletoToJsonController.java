package com.leitordoc.controllers;

import com.google.gson.Gson;
import com.leitordoc.models.BoletoBancario;
import com.leitordoc.services.BoletoToJsonService;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class BoletoToJsonController {

	public static void convert(String inputFilePath) {
		BoletoBancario bb = BoletoToJsonService.convert(inputFilePath);

		String JSONString = new Gson().toJson(bb);
		
		//Pega o nome do arquivo e adiciona .json
		String outputFileName = inputFilePath.split("Desktop[\\\\]{1}")[1];
		outputFileName = (outputFileName.split("\\.pdf")[0]) + ".json";
		
		String outputFilePath = "./files/json/boleto";
		save(outputFilePath + outputFileName, JSONString);
	}
	
	public static void save(String outputFilePath, String JSONString) {
		try {
			  // Cria arquivo (local e nome especificados no outputFilePath)
		      File myObj = new File(outputFilePath);
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		} catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		try {
			  //Escreve o JSON do pdf inputado no arquivo recém criado
		      FileWriter myWriter = new FileWriter(outputFilePath);
		      myWriter.write(JSONString);
		      myWriter.close();	  
		} catch (IOException e) {

		      e.printStackTrace();
		}
	}
}