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
		    String match2 = match.split("(CPF)\\s")[1];
		    match3 = match2.split("\\s(ALIMENTANDOS)")[0];
		}
		ArrayList<Dependente> dependentes = new ArrayList<Dependente>();
		String[] arr = match3.split("\n");
		if (arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				String[] codSplit = arr[i].split("\\s", 2);
				String cod = "";
				if (codSplit.length > 0) {
					cod = codSplit[0];
				}
				String nomeSplit = arr[i].split();
				String nome = "";
				if (nomeSplit > 0) {
					nome = nomeSplit[0];
				}
				Dependente d = new Dependente(match3, match3, page1, match3);
			}
		}
		
		
		return match3;
	}
	

//	// TODO Simplificada vs completa
//	private ArrayList<String> rendimentosJPDependentes;
//	private ArrayList<String> rendimentosPFExteriorTitular;
//	private ArrayList<String> rendimentosPFExteriorDependente;
//	private RendimentoNaoTributavelIsento rendimentoNaoTributavelIsento;
//	private RendimentosTributacaoExclusiva rendimentosTributacaoExclusiva;
//	private ImpostoPagoRetido impostoPagoRetido;
//	private BensEDireitos bensEDireitos;
//	private DividasOnus dividasOnus;
}
