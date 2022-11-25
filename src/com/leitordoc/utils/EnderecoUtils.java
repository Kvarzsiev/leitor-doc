package com.leitordoc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.Endereco;

public class EnderecoUtils {
	
	public static Endereco mountEndereco(String page1) {
		String rua = getRua(page1);
		String numero = getNumero(page1);
		String complemento = getComplemento(page1);
		String bairro = getBairro(page1);
		String municipio = getMunicipio(page1);
		String uf = getUf(page1);
		String cep = getCep(page1);
		Endereco e = new Endereco(rua, numero, complemento, bairro, municipio, uf, cep);
		return e;
	}
//	private String rua;
	public static String getRua(String page1) {
		Pattern pattern = Pattern.compile("((Endereço)|(ENDEREÇO)):\\s[\\wà-úÀ-Ú\\-\\s]*((Número)|(NÚMERO))");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Endereço)|(ENDEREÇO)):\\s")[1];
		    match3 = match2.split("((Número)|(NÚMERO))")[0];
		}
		return match3;
	}
//	private int numero;
	public static String getNumero(String page1) {
		Pattern pattern = Pattern.compile("((Número)|(NÚMERO)):\\s[\\d]*\\s");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Número)|(NÚMERO)):\\s")[1];
		    match3 = match2.split("\\s")[0];
		}
		return match3;
	}
//	private String complemento;
	public static String getComplemento(String page1) {
		Pattern pattern = Pattern.compile("((Complemento)|(COMPLEMENTO)):\\s[\\w.à-úÀ-Ú\\d\\s/-]*\\sBairro\\/Distrito");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Complemento)|(COMPLEMENTO)):\\s")[1];
		    match3 = match2.split("\\sBairro\\/Distrito")[0];
		}
		return match3;
	}
//	private String bairro;
	public static String getBairro(String page1) {
		Pattern pattern = Pattern.compile("((Bairro\\/Distrito)|(BAIRRO\\/DISTRITO)):\\s[\\w-.à-úÀ-Ú\\/\\s]*\\s((Município)|(MUNICÍPIO))");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Bairro\\/Distrito)|(BAIRRO\\/DISTRITO)):\\s")[1];
		    match3 = match2.split("\\s((Município)|(MUNICÍPIO))")[0];
		}
		return match3;
	}
//	private String municipio;
	public static String getMunicipio(String page1) {
		Pattern pattern = Pattern.compile("((Município)|(MUNICÍPIO)):\\s[\\wà-úÀ-Ú\\s]*\\s((UF)|(uf))");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Município)|(MUNICÍPIO)):\\s")[1];
		    match3 = match2.split("\\s((UF)|(uf))")[0];
		}
		return match3;
	}
//	private String uf;
	public static String getUf(String page1) {
		Pattern pattern = Pattern.compile("((UF)|(uf)):\\s[\\w]{2}\\s");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((UF)|(uf)):\\s")[1];
		    match3 = match2.split("\\s")[0];
		}
		return match3;
	}
//	private String cep;
	public static String getCep(String page1) {
		Pattern pattern = Pattern.compile("((CEP)|(cep)):\\s[\\d]{5}[-./]?[\\d]{3}\\s((DDD)|(ddd))?");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((CEP)|(cep)):\\s")[1];
		    match3 = match2.split("\\s((DDD)|(ddd))?")[0];
		}
		return match3;
	}
}
