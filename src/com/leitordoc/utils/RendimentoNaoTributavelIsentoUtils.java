package com.leitordoc.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.RendimentoNaoTributavelIsento;
import com.leitordoc.models.Rendimentos;

public class RendimentoNaoTributavelIsentoUtils {
	
	public static ArrayList<Rendimentos> mountRendimentoNaoTributavelIsento (String pages) {
		ArrayList<Rendimentos> arr = new ArrayList<Rendimentos>();
		Pattern pattern = Pattern.compile("RENDIMENTOS\\sISENTOS\\sE\\sNÃO\\sTRIBUTÁVEIS\\s[\\w\\d\\s,à-úÀ-Ú.%()/\\-º:]+\\sRENDIMENTOS\\sSUJEITOS\\sÀ\\sTRIBUTAÇÃO\\sEXCLUSIVA\\s\\/\\sDEFINITIVA");
		Matcher matcher = pattern.matcher(pages);
		String match = "";
		if (matcher.find()) {
			match = matcher.group();
		}
		// Pode ser que retorne o cabeçalho (caso os campos estejam divididos em 2 páginas) - removendo cabeçalho abaixo
		String[] split = match.split("Página\\s[\\w\\d\\s,à-úÀ-Ú.%()/\\-º:]+ANO-CALENDÁRIO\\s[\\d]{4}\\s");
		if (split.length > 1) {
			String plchlder = split[0] + split[1];
			match = plchlder;
		}
		// Separando cada tipo de rendimento
		Pattern rendimentoPattern = Pattern.compile("[\\d]{2}.\\s[\\w\\s,à-úÀ-Ú.%()/\\-º:]+?(?=(([\\d]{2}\\.\\s)|(TOTAL\\s)))");
		Matcher rendimentoMatcher = rendimentoPattern.matcher(match);
		String rendItem = "";
		while (rendimentoMatcher.find()) {
			rendItem = rendimentoMatcher.group();
			Pattern tipPattern = Pattern.compile("[\\d]{2}\\.\\s[\\w\\s,à-úÀ-Ú.%()/\\-º:]+?\\s(?=Beneficiário)");
			Matcher tipMatcher = tipPattern.matcher(rendItem);
			String tipRend = "";
			if (tipMatcher.find()) {
				// Pega tipo (ex: 26. Outros)
				tipRend = tipMatcher.group();
				String [] plchlder = tipRend.split("[\\d.]+,[\\d]{2}");
				if (plchlder.length > 0) {
					tipRend = plchlder[0] + plchlder[1];
				}
				tipRend = tipRend.replace("\n", "");
			}
			Pattern totalPattern = Pattern.compile("(?<=([\\w\\s,à-úÀ-Ú.%()/\\-º:]+))[\\d.]+,[\\d]{2}(?=([\\w\\s,à-úÀ-Ú.%()/\\-º:]*Beneficiário\\sCPF))");
			Matcher totalMatcher = totalPattern.matcher(rendItem);
			String total = "";
			if (totalMatcher.find()) {
				// Pega valor total
				total = totalMatcher.group();
				total = total.replace("\n", "");
			}
			// Separando cada item dentro do tipo de rendimento
			Pattern itemTipoPattern = Pattern.compile("Titular\\s[\\w\\s,à-úÀ-Ú.%()/\\-º:]+?(?=(Titular)|(marcadecaim))");
			Matcher itemTipoMatcher = itemTipoPattern.matcher(rendItem + "marcadecaim");
			String itemTipo = "";
			while (itemTipoMatcher.find()) {
				itemTipo = itemTipoMatcher.group();
				
				// Pega nome da fonte
				Pattern nomFontePattern = Pattern.compile("(?<=(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})\\s)[\\w\\s,à-úÀ-Ú.%()/\\-º:]+");
				Matcher nomFonteMatcher = nomFontePattern.matcher(itemTipo);
				String nomFonte = "";
				String pegaValor = "";
				if (nomFonteMatcher.find()) {
					String plchldr = nomFonteMatcher.group();
					pegaValor = plchldr;
					String[] plchldrArr = plchldr.split("\\s[\\d,\\.]+");
					plchldr = plchldrArr[0] + plchldrArr[1];
					nomFonte = plchldr.replace("\n", " ");
				}
				
				// Pega valor 
				Pattern valorPattern = Pattern.compile("\\s[\\d,\\.]+\\s");
				Matcher valorMatcher = valorPattern.matcher(pegaValor);
				String valor = "";
				if (valorMatcher.find()) {
					valor = valorMatcher.group();
					valor = valor.replace("\n", "");
				}
				
				// Pega documento da fonte
				Pattern docFontePattern = Pattern.compile("(\\d{2}\\.\\d{3}\\.\\d{3}\\/\\d{4}\\-\\d{2})|(\\d{3}\\.\\d{3}\\.\\d{3}((\\-)|(\\/))\\d{2})");
				Matcher docFonteMatcher = docFontePattern.matcher(itemTipo);
				int index = 0;
				String docFonte = "";
				while (docFonteMatcher.find()) {
					if (index > 0) {
						docFonte = docFonteMatcher.group();
						docFonte = docFonte.replace("\n", "");
					}
					index++;
				}
				
				Rendimentos rnti = new Rendimentos(tipRend, valor, docFonte, nomFonte, total);
				arr.add(rnti);
			}
		} 
		return arr;	
	}
}
