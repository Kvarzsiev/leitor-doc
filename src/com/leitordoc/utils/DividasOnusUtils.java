package com.leitordoc.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.DescricaoValor;
import com.leitordoc.models.DividaOnus;
import com.leitordoc.models.DividasOnus;
import com.leitordoc.models.InformacaoBancaria;
import com.leitordoc.models.Parcelamento;
import com.leitordoc.models.Resumo;
import com.leitordoc.validators.ResumoValidator;

public class DividasOnusUtils {
	
	public static DividasOnus mountDividasOnus (String pages) {
		
		ArrayList<DividaOnus> listaDividaOnus = new ArrayList<DividaOnus>();
		String total = "";
		Pattern pattern = Pattern.compile("(?<=(EM\\s[\\d]{4})\\s)[\\d]{2}\\s[\\w\\s,à-úÀ-Ú.%()/]*\\s(?=(DOAÇÕES))");
		Matcher matcher = pattern.matcher(pages);
		String match = "";
		if (matcher.find()) {
			match = matcher.group();
		}
		// Separa dividas 
		Pattern dividasPattern = Pattern.compile("\\s[\\d]{2}\\s[\\w\\s,à-úÀ-Ú.%()/]+?(?=(\\s[\\d]{2}\\s)|(TOTAL))");
		Matcher dividasMatcher = dividasPattern.matcher(pages);
		String dividaMatch = "";
		while (dividasMatcher.find()) {
			dividaMatch = dividasMatcher.group();
			// Pega código
			Pattern codPattern = Pattern.compile("(?<=(\\s))[\\d]{2}(?=(\\s[\\w,.\\s]+))");
			Matcher codMatcher = codPattern.matcher(dividaMatch);
			String codMatch = "";
			if (codMatcher.find()) {
				codMatch = codMatcher.group();
			}
			
			// Pega discriminação (0_o)
			Pattern discriminacaoPattern = Pattern.compile("(?<=([\\d]{2}\\s))[\\w\\s,à-úÀ-Ú.%()/]+");
			Matcher discriminacaoMatcher = discriminacaoPattern.matcher(dividaMatch);
			String discriminacaoMatch = "";
			if (discriminacaoMatcher.find()) {
				discriminacaoMatch = discriminacaoMatcher.group();
				String[] plchldrArr = discriminacaoMatch.split("\\s[\\d,.]+\\s[\\d,.]+\\s[\\d,.]+");
				if (plchldrArr.length > 1) {
					discriminacaoMatch = plchldrArr[0] + plchldrArr[1];
					discriminacaoMatch.replace("\n", "");
				}
			}
			
			// Pega situacao atual da divida 
			Pattern situacaoPattern = Pattern.compile("(?<=(\\s[\\d,.]+)\\s)[\\d,.]+(?=(\\s[\\d,.]+))");
			Matcher situacaoMatcher = situacaoPattern.matcher(dividaMatch);
			String situacaoMatch = "";
			if (situacaoMatcher.find()) {
				situacaoMatch = situacaoMatcher.group();
			}
			
			// Pega o valor pago atual da divida
			Pattern valorPagoPattern = Pattern.compile("(?<=(\\s[\\d,.]+\\s))[\\d,.]+");
			Matcher valorPagoMatcher = valorPagoPattern.matcher(dividaMatch);
			String valorPagoMatch = "";
			if (valorPagoMatcher.find()) {
				if (valorPagoMatcher.find()) {
					valorPagoMatch = valorPagoMatcher.group();
				}
			}
			DividaOnus divo = new DividaOnus(codMatch, discriminacaoMatch, situacaoMatch, valorPagoMatch);
			listaDividaOnus.add(divo);
		}
		
		// Pega o valor total mais recente da dívida 
		Pattern totalPattern = Pattern.compile("(?<=(TOTAL\\s[\\d,.]+)\\s)[\\d,.]+(?=(\\s[\\d,.]+))");
		Matcher totalMatcher = totalPattern.matcher(pages);
		String totalMatch = "";
		if (totalMatcher.find()) {
			totalMatch = totalMatcher.group();
		}
		if (listaDividaOnus.size() == 0 && totalMatch.length() == 0) {
			totalMatch = "Sem Informações";
		}
		DividasOnus dio = new DividasOnus(listaDividaOnus, totalMatch);
		return dio;
	}
}
