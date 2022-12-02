package com.leitordoc.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.Completa;
import com.leitordoc.models.Dependente;
import com.leitordoc.models.DependentesInf;
import com.leitordoc.models.ImpostoPagoRetido;

public class IR1Utils {
	public static String getNome(String page1) {
		Pattern pattern = Pattern.compile("NOME:[\\s\\w]*CPF");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("NOME:")[1];
		    match3 = match2.split("CPF")[0];
		    match3 = match3.replace("\n", "");
		}
		return match3;
	}
	public static String getCPF(String page1) {
		Pattern pattern = Pattern.compile("CPF:\\s(\\d{3}\\.\\d{3}\\.\\d{3}((\\-)|(\\/))\\d{2})\\sIMPOSTO");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("CPF:\\s")[1];
		    match3 = match2.split("\\sIMPOSTO")[0];
		}
		return match3;
	}
	public static String getExercicio(String page1) {
		Pattern pattern = Pattern.compile("((EXERCÍCIO)|(EXERCICIO))\\s[\\d]*\\sANO");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((EXERCÍCIO)|(EXERCICIO))\\s")[1];
		    match3 = match2.split("\\sANO")[0];
		}
		return match3;
	}
	public static String getAnoCalendario(String page1) {
		Pattern pattern = Pattern.compile("((ANO-CALENDÁRIO)|(ANO-CALENDARIO))\\s[\\d]{4}\\s");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((ANO-CALENDÁRIO)|(ANO-CALENDARIO))\\s")[1];
		    match3 = match2.split("\\s")[0];
		}
		return match3;
	}
	public static DependentesInf getDependentesInf(String page1) {
		Pattern pattern = Pattern.compile("(DEPENDENTES)\\s[\\s\\w,à-úÀ-Ú.%()/\\-º]+\\s(ALIMENTANDOS)");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
			if (match.contains("Sem Informações")) {
				return new DependentesInf(new ArrayList<Dependente>(), "");
			}
		    String match2 = match.split("(CPF)\\s")[1];
		    match3 = match2.split("\\s(ALIMENTANDOS)")[0];
		}
		ArrayList<Dependente> dependentes = new ArrayList<Dependente>();
		String[] arr = match3.split("\n");
		int i = 0;
		if (arr.length > 0) {
			for (i = 0; i < arr.length - 1; i++) {
				Pattern codPattern = Pattern.compile("[\\d]{2}\\s");
				Matcher codMatcher = codPattern.matcher(arr[i]);
				String cod = "";
				if (codMatcher.find()) {
					cod = codMatcher.group();
				}
				Pattern nomePattern = Pattern.compile("[\\d]{2}\\s[\\s\\wà-úÀ-Ú'\\-]+\\s[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}");
				Matcher nomeMatcher = nomePattern.matcher(arr[i]);
				String nome = "";
				if (nomeMatcher.find()) {
					nome = nomeMatcher.group();
					String[] nomeSplit = nome.split("[\\d]{2}\\s");
					
					if (nomeSplit.length > 0) {
						nome = nomeSplit[1];
					}
					nomeSplit = nome.split("\\s[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}");
					if (nomeSplit.length > 0) {
						nome = nomeSplit[0];
					}
				}
				Pattern datNascPattern = Pattern.compile("[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}");
				Matcher datNascMatcher = datNascPattern.matcher(arr[i]);
				String datNasc = "";
				if (datNascMatcher.find()) {
					datNasc = datNascMatcher.group();
				}
				Pattern cpfPattern = Pattern.compile("(\\d{3}\\.\\d{3}\\.\\d{3}((\\-)|(\\/))\\d{2})");
				Matcher cpfMatcher = cpfPattern.matcher(arr[i]);
				String cpf = "";
				if (cpfMatcher.find()) {
					cpf = cpfMatcher.group();
				}
				Dependente d = new Dependente(cod, nome, datNasc, cpf);
				dependentes.add(d);
			}
		}
		String totalDeducao = arr[i].split("DEPENDENTES\\s")[1];
		DependentesInf di = new DependentesInf(dependentes, totalDeducao);
		return di;
	}
	public static String getRendimentosPJDependentes(String pages) {
		Pattern pattern = Pattern.compile("(?<=(RENDIMENTOS\\sTRIBUTÁVEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sJURÍDICA\\sPELOS\\sDEPENDENTES))[\\w\\s,à-úÀ-Ú.%()/]+(?=(RENDIMENTOS\\sTRIBUTÁVEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sFÍSICA\\sE\\sDO\\sEXTERIOR\\sPELO\\sTITULAR))");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			match3 = matcher.group();
			
			// Remove cabeçalho
			String[] split = match3.split("Página\\s[\\w\\d\\s,à-úÀ-Ú.%()/\\-º:]+ANO-CALENDÁRIO\\s[\\d]{4}\\s");
			if (split.length > 1) {
				String plchlder = split[0] + split[1];
				match3 = plchlder;
			}
			match3 = match3.replace("\n", "");
		}
		return match3;
	}
	public static String getRendimentosPFExteriorTitular(String pages) {
		Pattern pattern = Pattern.compile("(?<=(RENDIMENTOS\\sTRIBUTÁVEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sFÍSICA\\sE\\sDO\\sEXTERIOR\\sPELO\\sTITULAR))[\\w\\s,à-úÀ-Ú.%()/]+(?=(RENDIMENTOS\\sTRIBUTÁVEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sFÍSICA\\sE\\sDO\\sEXTERIOR\\sPELOS\\sDEPENDENTES))");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			match3 = matcher.group();
			
			// Remove cabeçalho
			String[] split = match3.split("Página\\s[\\w\\d\\s,à-úÀ-Ú.%()/\\-º:]+ANO-CALENDÁRIO\\s[\\d]{4}\\s");
			if (split.length > 1) {
				String plchlder = split[0] + split[1];
				match3 = plchlder;
			}
			match3 = match3.replace("\n", "");
		}
		return match3;
	}
	public static String getRendimentosPFExteriorDependente (String pages) {
		Pattern pattern = Pattern.compile("(?<=(RENDIMENTOS\\sTRIBUTÁVEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sFÍSICA\\sE\\sDO\\sEXTERIOR\\sPELOS\\sDEPENDENTES))[\\w\\s,à-úÀ-Ú.%()/\\-:]+(?=(RENDIMENTOS\\sISENTOS\\sE\\sNÃO\\sTRIBUTÁVEIS))");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			match3 = matcher.group();
			// Remove cabeçalho
			String[] split = match3.split("Página\\s[\\w\\d\\s,à-úÀ-Ú.%()/\\-º:]+ANO-CALENDÁRIO\\s[\\d]{4}\\s");
			if (split.length > 0) {
				String plchlder = "";
				if (split.length > 1) {
					plchlder = split[0] + split[1];
				} else {
					plchlder = split[0];
				}
				match3 = plchlder;
				match3 = match3.replace("\n", "");
			}
		}
		
		return match3;
	}
	
	public static ArrayList<ImpostoPagoRetido> getImpostoPagoRetido(String pages) {
		ArrayList<ImpostoPagoRetido> impostoPagoRetidoArr = new ArrayList<ImpostoPagoRetido>();
		Pattern pattern = Pattern.compile("(?<=(IMPOSTO\\sPAGO\\s\\/\\sRETIDO\\s))[\\w\\s,à-úÀ-Ú.%()/\\-º:]+\\s(?=(PAGAMENTOS\\sEFETUADOS))");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String[] plchldr = match.split("\\(Valores\\sem\\sReais\\)\\s");
		    if (plchldr.length > 1) {
		    	 match3 = plchldr[1];
		    } else {
		    	return impostoPagoRetidoArr;
		    }
		}
		// Separa nas quebras de linha
		String[] a = match3.split("\\n");
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
//				System.out.println("linha: " + a[i]);
				String razao = a[i].split("[\\d.,]+,\\d{2}")[0];
//				System.out.println("Raz: " + razao);
				String valor = a[i].split("[A-zà-úÀ-Ú\\s/:\\(\\)\\-]+")[1];
//				System.out.println("Val: " + valor);
				ImpostoPagoRetido impostoPagoRetido = new ImpostoPagoRetido(razao, valor);
				impostoPagoRetidoArr.add(impostoPagoRetido);
			}
		}
		
		return impostoPagoRetidoArr;
	}

	// TODO Simplificada vs completa
	public static ArrayList<Completa> getRendTributRecebPessJurCompleta(String pages) {
//		System.out.println(pages);
		ArrayList<Completa> rendTributRecebPessJurCompletaArr = new ArrayList<Completa>();
		Pattern pattern = Pattern.compile("(?<=(RENDIMENTOS\\sTRIBUTÁVEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sJURÍDICA\\sPELO\\sTITULAR))[\\w\\s,à-úÀ-Ú.%()/\\-º:]+\\s(?=(RENDIMENTOS\\sTRIBUTÁVEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sJURÍDICA\\sPELOS\\sDEPENDENTES))");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String[] plchldr = match.split("DE\\sPES.\\sJURÍDICA\\sOFICIAL\\sNA\\sFONTE\\sSALÁRIO\\s");
		    if (plchldr.length > 1) {
		    	 match3 = plchldr[1];
		    } else {
		    	return rendTributRecebPessJurCompletaArr;
		    }
		}
		
		Pattern itemPattern = Pattern.compile("[\\w\\s,à-úÀ-Ú.%()/:\\-]+?(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2}\\s)|(\\d{3}\\.\\d{3}\\.\\d{3}((\\-)|(\\/))\\d{2}\\s)");
		Matcher itemMatcher = itemPattern.matcher(match3);
		while (itemMatcher.find())
		{
			String match = itemMatcher.group();
			// Separa os valores
			String[] plchldr = match.split("(?<=([\\d.]+,[\\d]{2}))\\s");
			String fontePagadora = "";
			String rendRecebidos = "";
			String contrPrev = "";
			String impRetido = "";
			String _13Sal = "";
			String irrf13Sal = "";
			
			if (plchldr.length == 6) {
				String[] plchldr2 = plchldr[0].split("\\s(?=([\\d.]+,[\\d]{2}))");
				
				fontePagadora = plchldr2[0].concat(" "); 
				fontePagadora = fontePagadora.concat(plchldr[5]);
				fontePagadora = fontePagadora.replace("\n", " ");
				rendRecebidos = plchldr2[1];
				contrPrev = plchldr[1];
				impRetido = plchldr[2];
				_13Sal = plchldr[3];
				irrf13Sal = plchldr[4];
				
			} 
			
			Completa c = new Completa(fontePagadora, rendRecebidos, contrPrev, impRetido, _13Sal, irrf13Sal);
			rendTributRecebPessJurCompletaArr.add(c);
		}
		
		return rendTributRecebPessJurCompletaArr;
	}

//	private ArrayList<String> rendimentosPFExteriorTitular;
//	private ArrayList<String> rendimentosPFExteriorDependente;
}
