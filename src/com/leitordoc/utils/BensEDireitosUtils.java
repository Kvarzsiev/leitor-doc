package com.leitordoc.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.leitordoc.models.BemDireito;
import com.leitordoc.models.BensEDireitos;

public class BensEDireitosUtils {
	
	public static BensEDireitos mountBensEDireitos (String pages) {
		ArrayList<BemDireito> listaBensDireitos = new ArrayList<BemDireito>();

		// Limpa todos os dados inuteis
		Pattern purgePattern = Pattern.compile("(?<=(SITUAÇÃO\\sEM\\s[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}\\s[\\d]{2}\\/[\\d]{2}\\/[\\d]{4})\\s)[\\s\\w,à-úÀ-Ú.%()/\\-º:²ª$]+(?=(DÍVIDAS\\sE\\sÔNUS\\sREAIS))");
		Matcher purgeMatcher = purgePattern.matcher(pages);
		String purgeMatch = "";
		if (purgeMatcher.find())
		{
			purgeMatch = purgeMatcher.group();
		}
		purgeMatch = purgeMatch.replaceAll("Página\\s[\\s\\w,à-úÀ-Ú.%()/\\-º:²ª$]+?(SITUAÇÃO\\sEM\\s[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}\\s[\\d]{2}\\/[\\d]{2}\\/[\\d]{4}\\s)", "");

		Pattern listaPattern = Pattern.compile("(^)[\\d]{2}\\s[\\s\\w,à-úÀ-Ú.%()/\\-º:²ª$]+?(?=(\\s[\\d]{3}\\s\\-))", Pattern.MULTILINE);
		Matcher listaMatcher = listaPattern.matcher(purgeMatch);
		String listaMatch = "";
		while (listaMatcher.find()) 
		{
			listaMatch = listaMatcher.group();
			
			Pattern codPattern = Pattern.compile("(^)[\\d]{2}\\s", Pattern.MULTILINE);
			Matcher codMatcher = codPattern.matcher(listaMatch);
			String codMatch = "";
			if (codMatcher.find()) {
				codMatch = codMatcher.group();	
			}
			
			Pattern restPattern = Pattern.compile("(?<=(^[\\d]{2}\\s))[\\s\\w,à-úÀ-Ú.%()/\\-º:²ª$]+");
			Matcher restMatcher = restPattern.matcher(listaMatch);
			String restMatch = "";
			String discriminacao = "";
			if (restMatcher.find()) {
				restMatch = restMatcher.group();	
				String[] plchldr = restMatch.split("[\\d.]+,[\\d]{2}\\s[\\d.]+,[\\d]{2}\\s?");
				if (plchldr.length > 1) {
					discriminacao = plchldr[0] + plchldr[1];
					discriminacao = discriminacao.replace("\n", "");
				} else if (plchldr.length > 0){
					discriminacao = plchldr[0];
				}
			}
			
			Pattern situacaoPattern = Pattern.compile("(?<=([\\d.]+,[\\d]{2}\\s))[\\d.]+,[\\d]{2}\\s?");
			Matcher situacaoMatcher = situacaoPattern.matcher(restMatch);
			String situacaoMatch = "";
			if (situacaoMatcher.find()) {
				situacaoMatch = situacaoMatcher.group();	
			}
			
			BemDireito bd = new BemDireito(codMatch, discriminacao, situacaoMatch);
			listaBensDireitos.add(bd);
		}
		
		// Get total
		Pattern totalPattern = Pattern.compile("(?<=(TOTAL\\s[\\d.,]+)\\s)[\\d.,]+");
		Matcher totalMatcher = totalPattern.matcher(purgeMatch);
		String totalMatch = "";
		if (totalMatcher.find())
		{
			totalMatch = totalMatcher.group();
		}
		BensEDireitos bed = new BensEDireitos(listaBensDireitos, totalMatch);
		return bed;
	}
}
