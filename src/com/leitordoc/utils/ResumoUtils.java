package com.leitordoc.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.DescricaoValor;
import com.leitordoc.models.InformacaoBancaria;
import com.leitordoc.models.Parcelamento;
import com.leitordoc.models.Resumo;
import com.leitordoc.validators.ResumoValidator;

public class ResumoUtils {
	
	public static ResumoValidator mountResumo (String concatenatedFinalPages) {
		ArrayList<DescricaoValor> arrRendimentoTributavel = getRendimentoTributavel(concatenatedFinalPages);
		ArrayList<DescricaoValor> arrImpostoPago = getImpostoPago(concatenatedFinalPages);
		String impostoRestituir = getImpostoRestituir(concatenatedFinalPages);
		String saldoPagar = getSaldoPagar(concatenatedFinalPages);
		Parcelamento parcelamento = getParcelamento(concatenatedFinalPages);
		InformacaoBancaria informacaoBancaria = getInformacaoBancaria(concatenatedFinalPages);
		ArrayList<DescricaoValor> arrEvolucaoPatrimonial = getEvolucaoPatrimonial(concatenatedFinalPages);
		ArrayList<DescricaoValor> arrOutrasInformacoes = getOutrasInformacoes(concatenatedFinalPages);
		Resumo resumo = new Resumo(arrRendimentoTributavel, arrImpostoPago, impostoRestituir, saldoPagar, parcelamento, informacaoBancaria, arrEvolucaoPatrimonial, arrOutrasInformacoes);
		ResumoValidator rv = new ResumoValidator(resumo);
		return rv;
	}
	
//	private RendimentoTributavel rendimentoTributavel;
	public static ArrayList<DescricaoValor> getRendimentoTributavel(String pages) {
		Pattern pattern = Pattern.compile("RENDIMENTOS\\sTRIBUTÁVEIS\\sE\\sDESCONTO\\sSIMPLIFICADO\\s[\\w\\s,à-úÀ-Ú.%()/]*\\sIMPOSTO\\sPAGO");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find()) {
			String match = matcher.group();
		    String match2 = match.split("RENDIMENTOS\\sTRIBUTÁVEIS\\sE\\sDESCONTO\\sSIMPLIFICADO\\s")[1];
		    match3 = match2.split("\\sIMPOSTO\\sPAGO")[0];
		}
		String[] a = match3.split("\\n");
		
		ArrayList<DescricaoValor> arrRendimentoTributavel = new ArrayList<DescricaoValor>();
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				String descricao = a[i].split("[\\d.,]+")[0];
				String valor = a[i].split("[A-zà-úÀ-Ú\\s/%()]+")[1];
				DescricaoValor rendimentoTributavel = new DescricaoValor(descricao, valor);
				arrRendimentoTributavel.add(rendimentoTributavel);
			}
		}
		
		return arrRendimentoTributavel;
	}
//	private ImpostoPago impostoPago;
	public static ArrayList<DescricaoValor> getImpostoPago(String pages) {
		Pattern pattern = Pattern.compile("\\sIMPOSTO\\sPAGO\\s[\\s\\w,à-úÀ-Ú.%()/\\-º]*\\s((IMPOSTO\\sA\\sRESTITUIR)|(Imposto\\sa\\srestituir))");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("\\sIMPOSTO\\sPAGO\\s")[1];
		    match3 = match2.split("\\s((IMPOSTO\\sA\\sRESTITUIR)|(Imposto\\sa\\srestituir))")[0];
		}
		String[] a = match3.split("\\n");

		ArrayList<DescricaoValor> arrImpostoPago = new ArrayList<DescricaoValor>();
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				String descricao = a[i].split("[\\d.]+,[\\d]{2}")[0];
				String valor = a[i].split("[\\wA-zà-úÀ-Ú\\s/\\-.º()/]+\\s(?=([\\d.]+,[\\d]{2}))")[1];
				DescricaoValor impostoPago = new DescricaoValor(descricao, valor);
				arrImpostoPago.add(impostoPago);
			}
		}
		return arrImpostoPago;
	}
//	private String impostoRestituir;
	public static String getImpostoRestituir(String pages) {
		Pattern pattern = Pattern.compile("(?<=(IMPOSTO\\sA\\sRESTITUIR\\s)|(Imposto\\sa\\srestituir\\s))[\\d,.\\s]+\\s(?=(SALDO\\sIMPOSTO)|(Saldo\\simposto))");
		Matcher matcher = pattern.matcher(pages);
		String match = "";
		if (matcher.find())
		{
			match = matcher.group();
			match = match.replace("\n", "");
		}
		return match;
	}
//	private String saldoAPagar;
	public static String getSaldoPagar(String pages) {
		Pattern pattern = Pattern.compile("((SALDO\\sIMPOSTO\\sA\\sPAGAR)|(Saldo\\simposto\\sa\\spagar))\\s[\\d,.-]+\\s((PARCELAMENTO)|(parcelamento))");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((SALDO\\sIMPOSTO\\sA\\sPAGAR)|(Saldo\\simposto\\sa\\spagar))\\s")[1];
		    match3 = match2.split("\\s((PARCELAMENTO)|(parcelamento))")[0];
		}
		return match3;
	}
//	private Parcelamento parcelamento;
	public static Parcelamento getParcelamento(String pages) {
		Pattern pattern = Pattern.compile("((PARCELAMENTO)|(Parcelamento))\\s[\\s\\w,à-úÀ-Ú.%()/\\-º]+\\s((INFORMAÇÕES\\sBANCÁRIAS)|(Informações\\sbancárias))");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((PARCELAMENTO)|(Parcelamento))\\s")[1];
		    match3 = match2.split("\\s((INFORMAÇÕES\\sBANCÁRIAS)|(Informações\\sbancárias))")[0];
		}
		String[] a = match3.split("\\n");

		String valorQuota = a[0].split("[A-zà-úÀ-Ú\\s/]+")[1];
		String numQuotas = a[1].split("[A-zà-úÀ-Ú\\s/]+")[1];
		Parcelamento parcelamento = new Parcelamento(valorQuota, numQuotas);
		
		return parcelamento;
	}
//	private InformacaoBancaria informacaoBancaria;
	public static InformacaoBancaria getInformacaoBancaria(String pages) {
		Pattern pattern = Pattern.compile("((INFORMAÇÕES\\sBANCÁRIAS)|(Informações\\sbancárias))\\s[\\s\\w,à-úÀ-Ú.%()/\\-º:]+\\sConta\\spara\\scrédito\\s([\\d,./-]+)?");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    match3 = match.split("((INFORMAÇÕES\\sBANCÁRIAS)|(Informações\\sbancárias))\\s")[1];
		}
		String[] a = match3.split("\\n");

		String tipConta = "";
		String banco = "";
		String agencia = "";
		String contaCredito = "";
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				switch (i) {
					case 0: 
						//TODO rever esse campo no IR do Pai
						String[] splitTipConta = a[i].split("[A-zà-úÀ-Ú\\s/\\:]+");
						if (splitTipConta.length > 1) {
//							System.out.println("a");
							tipConta = splitTipConta[1];
						} else if (splitTipConta.length > 0) {
//							System.out.println("b");
							tipConta = a[i];
						}
						break;
					case 1:
						String[] splitBanco = a[i].split("[A-zà-úÀ-Ú\\s/]+");
						if (splitBanco.length > 0) {
							banco = splitBanco[1];
						}
						break;
					case 2:
						String[] splitAgencia = a[i].split("[A-zà-úÀ-Ú\\s\\(\\)\\/]+");
						if (splitAgencia.length > 0) {
							agencia = splitAgencia[1];
						}
						break;
					case 3:
						String[] splitContaCredito = a[i].split("[A-zà-úÀ-Ú\\s/]+");
						if (splitContaCredito.length > 0) {
							contaCredito = splitContaCredito[1];
						}
						break;
				}
			}
		}
		InformacaoBancaria informacaoBancaria = new InformacaoBancaria(tipConta, banco, agencia, contaCredito);
		return informacaoBancaria;
	}
//	private EvolucaoPatrimonial evolucaoPatrimonial;
	public static ArrayList<DescricaoValor> getEvolucaoPatrimonial(String pages) {
		Pattern pattern = Pattern.compile("((EVOLUÇÃO\\sPATRIMONIAL)|(Evolução\\spatrimonial))\\s[\\s\\w,à-úÀ-Ú.%()/\\-º]+\\s(OUTRAS\\sINFORMAÇÕES)");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((EVOLUÇÃO\\sPATRIMONIAL)|(Evolução\\spatrimonial))\\s")[1];
		    match3 = match2.split("\\s(OUTRAS\\sINFORMAÇÕES)")[0];
		}
		String[] a = match3.split("\\n");
		
		ArrayList<DescricaoValor> arrEvolucaoPatrimonial = new ArrayList<DescricaoValor>();
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				String descricao = a[i].split("[\\d.]+,[\\d]{2}")[0];
				String valor = a[i].split("[A-zà-úÀ-Ú\\s/]+[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}")[1];
				DescricaoValor evolucaoPatrimonial = new DescricaoValor(descricao, valor);
				arrEvolucaoPatrimonial.add(evolucaoPatrimonial);
			}
		}
		
		return arrEvolucaoPatrimonial;
	}
//	private OutrasInformacoes outrasInformacoes;
	public static ArrayList<DescricaoValor> getOutrasInformacoes(String pages) {
		Pattern pattern = Pattern.compile("(OUTRAS\\sINFORMAÇÕES)\\s[\\s\\w,à-úÀ-Ú.%()/\\-º]+\\sPágina");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("(OUTRAS\\sINFORMAÇÕES)\\s")[1];
		    match3 = match2.split("\\sPágina")[0];
		}
		String[] a = match3.split("\\n");
		
		ArrayList<DescricaoValor> arrOutrasInformacoes = new ArrayList<DescricaoValor>();
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				String[] splitDescricao = a[i].split("[\\d.]+,[\\d]{2}");
				String descricao = "";
				if (splitDescricao.length > 0) {
					descricao = splitDescricao[0];
				}
				String[] splitValor = a[i].split("[A-zà-úÀ-Ú\\s/\\-\\(\\)º,.\\d]+(?=(\\s[\\d.]+,[\\d]{2}))");
				String valor = "";
				if (splitValor.length > 1) {
					valor = splitValor[1];
				}
				DescricaoValor outraInformacao = new DescricaoValor(descricao, valor);
				arrOutrasInformacoes.add(outraInformacao);
			}
		}
		
		return arrOutrasInformacoes;
	}
}
