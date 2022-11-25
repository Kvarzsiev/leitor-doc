package com.leitordoc.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.EvolucaoPatrimonial;
import com.leitordoc.models.ImpostoPago;
import com.leitordoc.models.InformacaoBancaria;
import com.leitordoc.models.OutrasInformacoes;
import com.leitordoc.models.Parcelamento;
import com.leitordoc.models.RendimentoTributavel;
import com.leitordoc.models.Resumo;

public class ResumoUtils {
	
	public static Resumo mountResumo (String concatenatedFinalPages) {
		ArrayList<RendimentoTributavel> arrRendimentoTributavel = getRendimentoTributavel(concatenatedFinalPages);
//		System.out.println(concatenatedFinalPages);
		Resumo r = new Resumo(arrRendimentoTributavel, null, concatenatedFinalPages, concatenatedFinalPages, null, null, null, null);
		return r;
	}
	
//	private RendimentoTributavel rendimentoTributavel;
	public static ArrayList<RendimentoTributavel> getRendimentoTributavel(String pages) {
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
		
		ArrayList<RendimentoTributavel> arrRendimentoTributavel = new ArrayList<RendimentoTributavel>();
		if (a.length > 0) {
			for (int i = 0; i < a.length; i++) {
				String descricao = a[i].split("[\\d.,]+")[0];
				String valor = a[i].split("[A-zà-úÀ-Ú\\s/]+")[1];
				RendimentoTributavel rendimentoTributavel = new RendimentoTributavel(descricao, valor);
				arrRendimentoTributavel.add(rendimentoTributavel);
			}
		}
		
		return arrRendimentoTributavel;
	}
//	private ImpostoPago impostoPago;
//	private String impostoRestituir;
//	private String saldoAPagar;
//	private Parcelamento parcelamento;
//	private InformacaoBancaria informacaoBancaria;
//	private EvolucaoPatrimonial evolucaoPatrimonial;
//	private OutrasInformacoes outrasInformacoes;
}
