package com.leitordoc.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.DescricaoValor;
import com.leitordoc.models.Resumo;

public class ResumoUtils {
	
	public static Resumo mountResumo (String concatenatedFinalPages) {
		
		System.out.println(concatenatedFinalPages);
		ArrayList<DescricaoValor> arrRendimentoTributavel = getRendimentoTributavel(concatenatedFinalPages);
		ArrayList<DescricaoValor> arrImpostoPago = getImpostoPago(concatenatedFinalPages);
		String impostoRestituir = getImpostoRestituir(concatenatedFinalPages);
		String saldoPagar = getSaldoPagar(concatenatedFinalPages);
		Resumo r = new Resumo(arrRendimentoTributavel, arrImpostoPago, impostoRestituir, saldoPagar, null, null, null, null);
		return r;
	}
	
//	private RendimentoTributavel rendimentoTributavel;
	public static ArrayList<DescricaoValor> getRendimentoTributavel(String pages) {
		Pattern pattern = Pattern.compile("RENDIMENTOS\\sTRIBUTÁVEIS\\sE\\sDESCONTO\\sSIMPLIFICADO\\s[\\w\\d\\s,à-úÀ-Ú.%()/]*\\sIMPOSTO\\sPAGO");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("RENDIMENTOS\\sTRIBUTÁVEIS\\sE\\sDESCONTO\\sSIMPLIFICADO\\s")[1];
		    match3 = match2.split("\\sIMPOSTO\\sPAGO")[0];
		}
		String[] a = match3.split("\\n");
		
		ArrayList<DescricaoValor> arrRendimentoTributavel = new ArrayList<DescricaoValor>();
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				String descricao = a[i].split("[\\d.,]+")[0];
				String valor = a[i].split("[A-zà-úÀ-Ú\\s/]+")[1];
				DescricaoValor rendimentoTributavel = new DescricaoValor(descricao, valor);
				arrRendimentoTributavel.add(rendimentoTributavel);
			}
		}
		
		return arrRendimentoTributavel;
	}
//	private ImpostoPago impostoPago;
	public static ArrayList<DescricaoValor> getImpostoPago(String pages) {
		System.out.println(pages);
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
				String descricao = a[i].split("[\\d.,]+")[0];
				String valor = a[i].split("[A-zà-úÀ-Ú\\s/]+")[1];
				DescricaoValor impostoPago = new DescricaoValor(descricao, valor);
				arrImpostoPago.add(impostoPago);
			}
		}
		
		return arrImpostoPago;
	}
//	private String impostoRestituir;
	public static String getImpostoRestituir(String pages) {
		Pattern pattern = Pattern.compile("((IMPOSTO\\sA\\sRESTITUIR)|(Imposto\\sa\\srestituir))\\s[\\d,\\s]+\\s((SALDO\\sIMPOSTO)|(Saldo\\simposto))");
		Matcher matcher = pattern.matcher(pages);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((IMPOSTO\\sA\\sRESTITUIR)|(Imposto\\sa\\srestituir))\\s")[1];
		    match3 = match2.split("\\s((SALDO\\sIMPOSTO)|(Saldo\\simposto))")[0];
		}
		return match3;
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
//	private InformacaoBancaria informacaoBancaria;
//	private EvolucaoPatrimonial evolucaoPatrimonial;
//	private OutrasInformacoes outrasInformacoes;
}
