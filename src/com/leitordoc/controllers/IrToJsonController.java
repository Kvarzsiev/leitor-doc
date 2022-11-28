package com.leitordoc.controllers;

import com.google.gson.Gson;
import com.leitordoc.models.DeclaracaoIR;
import com.leitordoc.services.BoletoToJsonService;
import com.leitordoc.services.IrToJsonService;
import com.leitordoc.validators.IRValidator;

import java.io.File;  
import java.io.IOException; 
import java.io.FileWriter;   

public class IrToJsonController {

	public static void convert(String inputFilePath) {
		IRValidator irv = IrToJsonService.convert(inputFilePath);

		String JSONString = new Gson().toJson(irv.getDir());
		
		//Pega o nome do arquivo e adiciona .json
		String outputFileName = inputFilePath.split("Desktop[\\\\]{1}")[1];
		outputFileName = (outputFileName.split("\\.pdf")[0]) + ".json";
		String outputFilePath = "./files/json/ir/";
		if (!irv.isValido()) {
			outputFilePath = "./files/json/ir/falha/";
		}
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