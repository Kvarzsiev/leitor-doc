package com.leitordoc.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.BensEDireitos;
import com.leitordoc.models.Dependente;
import com.leitordoc.models.DependentesInf;
import com.leitordoc.models.DividasOnus;
import com.leitordoc.models.Endereco;
import com.leitordoc.models.ImpostoPagoRetido;
import com.leitordoc.models.Ocupacao;
import com.leitordoc.models.RendimentoNaoTributavelIsento;
import com.leitordoc.models.RendimentosTributacaoExclusiva;
import com.leitordoc.models.Resumo;

public class IR1Utils {
//	private String nome;
	public static String getNome(String page1) {
		Pattern pattern = Pattern.compile("NOME:[\\s\\w]*CPF");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("NOME:")[1];
		    match3 = match2.split("CPF")[0];
		}
		return match3;
	}
	
//	private String cpf;
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
//	private String exercicio;
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
//	private String anoCalendario;
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
//	private DependentesInf dependentes; 
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
	
//	private ArrayList<String> rendimentosPJDependentes;

//	// TODO Simplificada vs completa

//	private ArrayList<String> rendimentosPFExteriorTitular;
//	private ArrayList<String> rendimentosPFExteriorDependente;
//	private RendimentoNaoTributavelIsento rendimentoNaoTributavelIsento;
//	private RendimentosTributacaoExclusiva rendimentosTributacaoExclusiva;
//	private ImpostoPagoRetido impostoPagoRetido;
//	private BensEDireitos bensEDireitos;
//	private DividasOnus dividasOnus;
}
