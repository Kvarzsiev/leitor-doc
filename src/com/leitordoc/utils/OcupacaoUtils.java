package com.leitordoc.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.Ocupacao;
import com.leitordoc.validators.OcupacaoValidator;

public class OcupacaoUtils {

	public static OcupacaoValidator mountOcupacao(String page1) {
		String natureza = getNatureza(page1);
		String ocupacaoPrincipal = getOcupacaoPrincipal(page1);
		String tipoDeclaracao = getTipoDeclaracao(page1);
		String nroReciboUltimaEntrega = getNroReciboUltimaEntrega(page1);
		Ocupacao o = new Ocupacao(natureza, ocupacaoPrincipal, tipoDeclaracao, nroReciboUltimaEntrega);
		OcupacaoValidator ov = new OcupacaoValidator(o);
		return ov;
	}
	
//	private String natureza;
	public static String getNatureza(String page1) {
		Pattern pattern = Pattern.compile("((Natureza\\sda\\sOcupação)|(NATUREZA\\sDA\\sOCUPAÇÃO)):\\s[\\d\\wà-úÀ-Ú,.\\-\\s]*\\s((Ocupação)|(OCUPAÇÃO))");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Natureza\\sda\\sOcupação)|(NATUREZA\\sDA\\sOCUPAÇÃO)):\\s")[1];
		    match3 = match2.split("\\s((Ocupação)|(OCUPAÇÃO))")[0];
		}
		return match3;
	}
//	private String ocupacaoPrincipal;
	public static String getOcupacaoPrincipal(String page1) {
		Pattern pattern = Pattern.compile("((Ocupação\\sPrincipal)|(OCUPAÇÃO\\sPRINCIPAL)):\\s[\\d\\wà-úÀ-Ú,.\\-\\s]*\\s((Tipo\\sde\\sdeclaração)|(TIPO\\sDE\\sDECLARAÇÃO))");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Ocupação\\sPrincipal)|(OCUPAÇÃO\\sPRINCIPAL)):\\s")[1];
		    match3 = match2.split("\\s((Tipo\\sde\\sdeclaração)|(TIPO\\sDE\\sDECLARAÇÃO))")[0];
		    match3 = match3.replace("\n", "");
		}
		return match3;
	}
//	private String tipoDeclaracao;
	public static String getTipoDeclaracao(String page1) {
		Pattern pattern = Pattern.compile("((Tipo\\sde\\sdeclaração)|(TIPO\\sDE\\sDECLARAÇÃO)):\\s[\\d\\wà-úÀ-Ú,.\\-\\s]*\\sNº?");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Tipo\\sde\\sdeclaração)|(TIPO\\sDE\\sDECLARAÇÃO)):\\s")[1];
		    match3 = match2.split("\\sNº?")[0];
		}
		return match3;
	}
//	private String nroReciboUltimaEntrega;
	public static String getNroReciboUltimaEntrega(String page1) {
		Pattern pattern = Pattern.compile("((Nº?)|(nº?))[\\d\\wà-úÀ-Ú,.\\-\\s:]*\\s[\\d]{2}.?[\\d]{2}.?[\\d]{2}.?[\\d]{2}.?[\\d]{2}-?[\\d]{2}\\s");
		Matcher matcher = pattern.matcher(page1);
		String match3 = "";
		if (matcher.find())
		{
			String match = matcher.group();
		    String match2 = match.split("((Nº?)|(nº?))[\\d\\wà-úÀ-Ú,.\\-\\s]*:\\s*")[1];
		    match3 = match2.split("\\s")[0];
		}
		return match3;
	}
}
