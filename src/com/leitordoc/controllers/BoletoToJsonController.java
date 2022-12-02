package com.leitordoc.controllers;

import com.google.gson.Gson;
import com.leitordoc.models.BoletoBancario;
import com.leitordoc.services.BoletoToJsonService;
import com.leitordoc.validators.BoletoBancarioValidator;

import java.io.File;  
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;  

public class BoletoToJsonController {

	public static void convert(String inputFilePath) {
		BoletoBancarioValidator bbv = BoletoToJsonService.convert(inputFilePath);

		String JSONString = new Gson().toJson(bbv.getBoleto());
		
		Pattern pattern = Pattern.compile("(?<=(\\\\))[\\w\\s,à-úÀ-Ú.%()/\\-º:]+(?=(\\.pdf))");
		Matcher matcher = pattern.matcher(inputFilePath);
		String outputFileName = "";
		if (matcher.find())
		{
			outputFileName = matcher.group();
		}
		outputFileName = outputFileName + ".json";
		
		String outputFilePath = "./files/json/boleto/";
		if (!bbv.isValido()) {
			outputFilePath = "./files/json/boleto/falha/";
		}
		
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