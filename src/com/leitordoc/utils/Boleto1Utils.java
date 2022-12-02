package com.leitordoc.utils;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Boleto1Utils {

	public static String getFichaCompensacao(String documento) {
		String[] splitted = documento.split("(\\d{3}-[\\dxX]{1}\\s*\\d{9}\\.\\d{1}\\s+\\d{10}\\.\\d{1}\\s*\\d{10}\\.\\d{1}\\s*\\d{1}\\s*\\d{14})|(\\d{3}-[\\dxX]{1}\\s*\\d{5}\\.\\d{5}\\s*\\d{5}\\.\\d{6}\\s*\\d{5}\\.\\d{6}\\s*\\d{1}\\s*\\d{14})");
		String fichaCompensacao = "";
		if (splitted.length > 2) {
			fichaCompensacao = splitted[2];
		} else {
			fichaCompensacao = splitted[1];
		}
		return fichaCompensacao;
	}
	
	public static String getMora(String fichaCompensacao) {
		Pattern pattern = Pattern.compile("((MORA)|(mora))\\s*((de)|(DE))?\\s*[\\d,.]*%");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((MORA)|(mora))\\s*((de)|(DE))?\\s*")[1];
		    match3 = match2.split("\\s*Uso do Banco")[0];
		}
		return match3;
	}
	
	public static String getCarteira(String fichaCompensacao) {
		Pattern pattern = Pattern.compile("((Valor Documento)|(Valor documento))\\s*[\\w]*");
		String ficha = "";
		if (fichaCompensacao.contains("Uso do Banco")) {	
			ficha = fichaCompensacao.split("Uso do Banco")[1];
		} else {
			ficha = fichaCompensacao;
		}
		Matcher matcher = pattern.matcher(ficha);
		String match2 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    match2 = match.split("((Documento)|(documento))\\s*")[1];
		}

		return match2;
	}
	
	public static String getNossoNumero(String fichaCompensacao) {
		Pattern pattern = Pattern.compile("\\d{2}\\/\\d{2}\\/\\d{4}\\s[\\d-.]*\\s*((Uso do Banco)|(Uso do banco))");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("\\d{2}\\/\\d{2}\\/\\d{4}\\s")[1];
		    match3 = match2.split("\\s*((Uso do Banco)|(Uso do banco))")[0];
		}
		return match3;
	}
	
	public static String getMulta (String fichaCompensacao) {
		Pattern pattern = Pattern.compile("(multa)|(MULTA)+[\\s:deDE]*[\\d,.]*%");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("(multa)|(MULTA)")[1];
		    match3 = match2.split("(CPF)|(CNPJ)")[0];
		}
		return match3.replace(" ", "").replace("DE", "");
	}
	
	public static String getNomePagador (String fichaCompensacao) {
		Pattern pattern = Pattern.compile("((Pagador)|(Sacado))[\\s\\w.A-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ.:/\\-@]*((CPF)|(CNPJ))");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("(Pagador)|(Sacado)")[1];
		    match3 = match2.split("(CPF)|(CNPJ)")[0];
		}
		match3 = match3.replace("\n", "");
		match3 = match3.replaceAll("\\s?[\\d-]+", "");
		match3 = match3.replaceAll("  ", "");
		return match3;
	}
	
	public static String getCodigoBeneficiario (String fichaCompensacao) {
		Pattern pattern = Pattern.compile("[\\w.-]*\\s*[\\d\\/\\s\\.]*((Data do Documento)|(Data do documento))");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Data do Documento)|(Data do documento))")[0];
		    String[] matches = match2.split("^[\\w-]*\\s");
		    if (matches.length > 0) {
		    	match3 = matches[1];
		    }
		}
		match3 = match3.replace("\n", "");
		return match3.replace(" ", "");
	}
	
	public static String getNomBeneficiario (String fichaCompensacao) {
		Pattern pattern = Pattern.compile("\\s*Código\\s*(do)?\\s*((Beneficiário)|(beneficiário)|(Cedente))\\s*([.A-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ|-]*\\s)*[\\d./-]*");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("\\s*Código\\s*(do)?\\s*((Beneficiário)|(beneficiário)|(Cedente))\\s*")[1];
		    match3 = match2.split("\\d+")[0];
		}
		return match3;
	}
	
	public static String getLocalPagamento(String fichaCompensacao) {
		Pattern pattern = Pattern.compile("((Local\\s*de\\s*Pagamento\\s*Vencimento)|(Local\\s*de\\s*pagamento\\s*Vencimento))\\s*([.A-záàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ\\/-]*\\s*)*\\d{2}\\/\\d{2}\\/\\d{4}");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("\\s*Vencimento\\s*")[1];
		    match3 = match2.split("\\d{2}\\/\\d{2}\\/\\d{4}")[0];
		}
		return match3;
	}
	
	public static String[] getDocs(String documento) {
		// Regex que acha cpf ou cnpj
		Pattern pattern = Pattern.compile("(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})|(\\d{3}\\.\\d{3}\\.\\d{3}((\\-)|(\\/))\\d{2})");
		Matcher matcher = pattern.matcher(documento);
		// Esse array vai conter apenas 2 documentos, o primeiro sendo do beneficiário e o segundo do pagador
		String[] docs = new String[2];
		docs[0] = "";
		docs[1] = "";
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
//		System.out.println(documento);
		// Regex que acha linha digitavel
		Pattern pattern = Pattern.compile("(\\s*\\d{9}\\.\\d{1} \\d{10}\\.\\d{1} \\d{10}\\.\\d{1} \\d{1} \\d{14})|(\\s*\\d{5}\\.\\d{5} \\d{5}\\.\\d{6} \\d{5}\\.\\d{6} \\d{1} \\d{14})");
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
		String valor = null;
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
		Pattern pattern = Pattern.compile("(^|\\s)\\d{3}-\\d{1}($|\\s)", Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(documento);
		String codBanco = "";
		if (matcher.find()) {
			codBanco = matcher.group();
		}
		return codBanco.replace("\n", "");
	}
	
	public static String getAceite(String fichaCompensacao) {
		Pattern pattern = Pattern.compile("\\s[\\w]{1}\\s*\\d{2}\\/\\d{2}\\/\\d{4}");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String aceite = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    aceite = match.split("\\s*\\d{2}\\/\\d{2}\\/\\d{4}")[0];
		}
		return aceite.replace(" ", "");
	}
	
	public static String getInstrucoes(String fichaCompensacao) {
		Pattern pattern = Pattern.compile("((Desconto)|(Abatimentos)|(Abatimento))[\\w\\s%êÊãÃâÂçÇõÕóÓáÁéÉ(+\\-)/,:.]+((Mora)|(Outros))");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String instrucoes = "";
		if (matcher.find())
		{
			String match = matcher.group();
			instrucoes = match.split("Outros")[0];
			instrucoes = instrucoes.split("((Abatimentos)|(Abatimento))")[1];
		}
		instrucoes = instrucoes.replace("Mora / Multa", "");
		instrucoes = instrucoes.replace("(+) Mora / Multa / Juros", "");
		instrucoes = instrucoes.replace("(-)", "");
		instrucoes = instrucoes.replace("\n", " ");
		return instrucoes.replace("(+)", "");
	}
	
	public static String getMoeda(String fichaCompensacao) {
		Pattern pattern = Pattern.compile("([R\\$]{2})|([US$]{3})|([€¥£]{1})");
		Matcher matcher = pattern.matcher(fichaCompensacao);
		String moeda = "";
		if (matcher.find())
		{
			moeda = matcher.group();
		}
		return moeda;
	}
}
