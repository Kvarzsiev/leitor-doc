package com.leitordoc.controllers;

import com.google.gson.Gson;
import com.leitordoc.models.BoletoBancario;
import com.leitordoc.services.BoletoToJsonService;
import java.io.File;  
import java.io.IOException; 
import java.io.FileWriter;  

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
			  // Referencia arquivo (local e nome especificados no outputFilePath)
		      File myObj = new File(outputFilePath);
		      // Cria arquivo se não existe
		      if (myObj.createNewFile()) {
		        System.out.println("Criado: " + myObj.getName());
		      } else {
		        System.out.println("Arquivo existente.");
		      }
		} catch (IOException e) {
		      System.out.println("Ocorreu um erro.");
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