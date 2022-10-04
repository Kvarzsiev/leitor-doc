package com.leitordoc.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DocumentsUtils {

	public static String[] getDocs(String documento) {
		// Regex que acha cpf ou cnpj
		Pattern pattern = Pattern.compile("(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})|(\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2})");
		Matcher matcher = pattern.matcher(documento);
		// Esse array vai conter apenas 2 documentos, o primeiro sendo do beneficiário e o segundo do pagador
		String[] docs = new String[2];
		int i = 0;
		while (matcher.find() && i < 2) {
			// Pega o primeiro documento
			if (i == 0) {
				docs[i] = matcher.group();
				i++;
			}
			// Se o primeiro documento não for igual ao documento atual do matcher, insere o atual na array
			if (!docs[i-1].contentEquals(matcher.group())) {
				docs[i] = matcher.group();
				i++;
			}
        }
		return docs;
	}
	
	public static String getLinhaDigitavel(String documento) {
		// Regex que acha linha digitavel
		Pattern pattern = Pattern.compile("(\\d{9}\\.\\d{1} \\d{10}\\.\\d{1} \\d{10}\\.\\d{1} \\d{1} \\d{14})");
		Matcher matcher = pattern.matcher(documento);
		String linhaDigitavel = "";
		if (matcher.find()) {
			linhaDigitavel = matcher.group();
		}
		return linhaDigitavel;
	}
	
	public static String getValor(String documento) {
		// Regex que acha valor
		Pattern pattern = Pattern.compile("(^|\\s)(R\\$)?(\\d{1,3}(\\.\\d{3})*|\\d+)(\\,\\d{2}){1}($|\\s)", Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(documento);
		String valor = "";
		if (matcher.find()) {
			valor = matcher.group();
		}
		return valor;
	}
	
	public static Date[] getDatas(String documento) {
		// Regex que acha datas
		Pattern pattern = Pattern.compile("(\\d{2}\\/){2}\\d{4}");
		Matcher matcher = pattern.matcher(documento);
		// Esse array vai conter apenas 2 datas
		String[] datas = new String[2];
		int i = 0;
		while (matcher.find() && i < 2) {
			// Pega a primeira data
			if (i == 0) {
				datas[i] = matcher.group();
				i++;
			}
			// Se a primeira data não for igual à data atual do matcher, insere a data atual na array
			if (!datas[i-1].contentEquals(matcher.group())) {
				datas[i] = matcher.group();
					i++;
			}
		}
		// Transforma as strings em Date
		Date data1 = null;
		Date data2 = null;
		try {
			data1 = DateUtils.stringToDate(datas[0]);
			data2 = DateUtils.stringToDate(datas[1]);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Date[] dateDatas = new Date[2];
		dateDatas = DateUtils.chronologizeDates(data1, data2);
		return dateDatas;
	}
	
	public static String getCodBanco(String documento) {
		// Regex que acha valor
		Pattern pattern = Pattern.compile("(^|\\s)\\d{3}-\\d{1}($|\\s)", Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(documento);
		String codBanco = "";
		if (matcher.find()) {
			codBanco = matcher.group();
		}
		return codBanco;
	}
}
