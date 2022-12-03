package com.leitordoc.services;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.leitordoc.models.BensEDireitos;
import com.leitordoc.models.Completa;
import com.leitordoc.models.DeclaracaoIR;
import com.leitordoc.models.DependentesInf;
import com.leitordoc.models.DividasOnus;
import com.leitordoc.models.ImpostoPagoRetido;
import com.leitordoc.models.Ocupacao;
import com.leitordoc.models.Rendimentos;
import com.leitordoc.utils.BensEDireitosUtils;
import com.leitordoc.utils.DividasOnusUtils;
import com.leitordoc.utils.EnderecoUtils;
import com.leitordoc.utils.IR1Utils;
import com.leitordoc.utils.OcupacaoUtils;
import com.leitordoc.utils.RendimentoNaoTributavelIsentoUtils;
import com.leitordoc.utils.RendimentoTributacaoExclusivaUtils;
import com.leitordoc.utils.ResumoUtils;
import com.leitordoc.validators.EnderecoValidator;
import com.leitordoc.validators.IRValidator;
import com.leitordoc.validators.OcupacaoValidator;
import com.leitordoc.validators.ResumoValidator;

public class IrToJsonService {
	private ArrayList<String> stringfiedPages;
	
	
	public IrToJsonService() {
		super();
		this.stringfiedPages = new ArrayList<String>();
	}

	public static IRValidator convert (String filePath) {	
		IrToJsonService service = new IrToJsonService();
		IRValidator irv = new IRValidator();
		
		try {
			// lÍ o pdf e salva num array de strings (p·ginas)
			service.setRead(filePath);
		} catch (IOException e) {
			System.out.println("aaa");
			e.printStackTrace();
		}
		ArrayList<String> sortBypages = service.getStringfiedPages();
		
		String nome = IR1Utils.getNome(sortBypages.get(0));
		String cpf = IR1Utils.getCPF(sortBypages.get(0));
		String exercicio = IR1Utils.getExercicio(sortBypages.get(0));
		String anoCalendario = IR1Utils.getAnoCalendario(sortBypages.get(0));
		if (nome.length() == 0 || cpf.length() == 0 || exercicio.length() == 0 || anoCalendario.length() == 0) {
			irv.setValido(false);
		}
		EnderecoValidator enderecoValidator = EnderecoUtils.mountEndereco(sortBypages.get(0));
		OcupacaoValidator ocupacaoValidator = OcupacaoUtils.mountOcupacao(sortBypages.get(0));
		if (!enderecoValidator.isValido() || !ocupacaoValidator.isValido()) {
			irv.setValido(false);
		}
		DependentesInf dependentesInf = IR1Utils.getDependentesInf(sortBypages.get(0));	
		String rendTribRecPJPages = service.getPagesBetween("RENDIMENTOS\\sTRIBUT¡VEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sJURÕDICA\\sPELO\\sTITULAR", "RENDIMENTOS\\sTRIBUT¡VEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sJURÕDICA\\sPELOS\\sDEPENDENTES");
		ArrayList<Completa> rendTributRecebPessJur = IR1Utils.getRendTributRecebPessJurCompleta(rendTribRecPJPages);
		String rendimentosPJDependentesPages = service.getPagesBetween("RENDIMENTOS\\sTRIBUT¡VEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sJURÕDICA\\sPELOS\\sDEPENDENTES", "RENDIMENTOS\\sTRIBUT¡VEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sFÕSICA\\sE\\sDO\\sEXTERIOR\\sPELO\\sTITULAR");
		String rendimentosPJDependentes = IR1Utils.getRendimentosPJDependentes(rendimentosPJDependentesPages);
		String rendimentosPFExteriorTitularPages = service.getPagesBetween("RENDIMENTOS\\sTRIBUT¡VEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sFÕSICA\\sE\\sDO\\sEXTERIOR\\sPELO\\sTITULAR", "RENDIMENTOS\\sTRIBUT¡VEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sFÕSICA\\sE\\sDO\\sEXTERIOR\\sPELOS\\sDEPENDENTES");
		String rendimentosPFExteriorTitular = IR1Utils.getRendimentosPFExteriorTitular(rendimentosPFExteriorTitularPages);
		String rendimentosPFExteriorDependentePages = service.getPagesBetween("RENDIMENTOS\\sTRIBUT¡VEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sFÕSICA\\sE\\sDO\\sEXTERIOR\\sPELOS\\sDEPENDENTES", "RENDIMENTOS\\sISENTOS\\sE\\sN√O\\sTRIBUT¡VEIS");
		String rendimentosPFExteriorDependente = IR1Utils.getRendimentosPFExteriorDependente(rendimentosPFExteriorDependentePages);
		
		String rendNaoTributaveisPages = service.getPagesBetween("(RENDIMENTOS\\sISENTOS\\sE\\sN√O\\sTRIBUT¡VEIS)", "RENDIMENTOS\\sSUJEITOS\\s¿\\sTRIBUTA«√O\\sEXCLUSIVA\\s\\/\\sDEFINITIVA");
		ArrayList<Rendimentos> rendimentoNaoTributavelIsento = RendimentoNaoTributavelIsentoUtils.mountRendimentoNaoTributavelIsento(rendNaoTributaveisPages);
		String rendTributacaoExclusivaPages = service.getPagesBetween("(RENDIMENTOS\\sSUJEITOS\\s¿\\sTRIBUTA«√O\\sEXCLUSIVA\\s\\/\\sDEFINITIVA)", "RENDIMENTOS\\sTRIBUT¡VEIS\\sRECEBIDOS\\sDE\\sPESSOA\\sJURÕDICA\\sPELO\\sTITULAR\\s\\(IMPOSTO\\sCOM\\sEXIGIBILIDADE\\sSUSPENSA\\)");
		ArrayList<Rendimentos> rendimentoTributacaoExclusiva = RendimentoTributacaoExclusivaUtils.mountRendimentoTributacaoExclusiva(rendTributacaoExclusivaPages);
		
		String impostoPagoRetidoPages = service.getPagesBetween("IMPOSTO\\sPAGO\\s\\/\\sRETIDO\\s", "PAGAMENTOS\\sEFETUADOS");
		ArrayList<ImpostoPagoRetido> impostoPagoRetido = IR1Utils.getImpostoPagoRetido(impostoPagoRetidoPages);
		
		String bensEDireitosPages = service.getPagesBetween("DECLARA«√O\\sDE\\sBENS\\sE\\sDIREITOS", "(DÕVIDAS\\sE\\s‘NUS\\sREAIS)");
		BensEDireitos bensEDireitos = BensEDireitosUtils.mountBensEDireitos(bensEDireitosPages);

		String dividasOnusPages = service.getPagesBetween("(DÕVIDAS\\sE\\s‘NUS\\sREAIS)", "(DOA«’ES\\sA\\sPARTIDOS\\sPOLÕTICOS\\sE\\sCANDIDATOS\\sA\\sCARGOS\\sELETIVOS)");
		DividasOnus dividasOnus = DividasOnusUtils.mountDividasOnus(dividasOnusPages);
		
		String paginasResumo = service.getResumoPages();
		ResumoValidator rv = ResumoUtils.mountResumo(paginasResumo);
		
		DeclaracaoIR dir = new DeclaracaoIR(nome, cpf, exercicio, anoCalendario, enderecoValidator.getEndereco(), ocupacaoValidator.getOcupacao(), dependentesInf, 
		rendTributRecebPessJur, rendimentosPJDependentes, rendimentosPFExteriorTitular, rendimentosPFExteriorDependente,
		rendimentoNaoTributavelIsento, rendimentoTributacaoExclusiva, impostoPagoRetido, bensEDireitos, dividasOnus, rv.getResumo());
		
		irv.setDir(dir);
		if (!rv.isValido()) {
			irv.setValido(false);
		}
		return irv;
	}

	public void setRead(String filePath) throws IOException {
		File arquivo = new File(filePath);
		PDDocument documento = PDDocument.load(arquivo);
		Splitter splitter = new Splitter();
		try {
			ArrayList<PDDocument> pages = (ArrayList<PDDocument>) splitter.split(documento);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			pdfStripper.setSortByPosition(true);
			pdfStripper.setLineSeparator("\n");
			for (PDDocument page : pages) {
				String texto = pdfStripper.getText(page);
				this.addStringfiedPage(texto);
			}
		} finally {
			documento.close();
		}
		
	}
	private ArrayList<String> getStringfiedPages() {
		return stringfiedPages;
	}
	private void addStringfiedPage(String stringfiedPage) {
		this.stringfiedPages.add(stringfiedPage);
	}
	
	private String getPagesBetween(String startRegex, String endRegex) {
		String paginasConcatenadas = "";
		int i = 0;
		int startPage = 0;
		Boolean encontrouStartPage = false;
		Boolean encontrouFinalPage = false;
		int finalPage = 0;
		for (i = 0; i < this.stringfiedPages.size(); i++ ) {
			// Procura a p·gina onde inicia o campo 
			Pattern startPattern = Pattern.compile(startRegex);
			Matcher startMatcher = startPattern.matcher(this.stringfiedPages.get(i));
			if (startMatcher.find() && !encontrouStartPage) {
				startPage = i;
				encontrouStartPage = true;
			}
			//	Procura a p·gina onde termina o campo
			Pattern finalPattern = Pattern.compile(endRegex);
			Matcher finalMatcher = finalPattern.matcher(this.stringfiedPages.get(i));
			if (finalMatcher.find() && !encontrouFinalPage) {
				finalPage = i;
				encontrouFinalPage = true;
			}
		}
		for (int j = startPage; j <= finalPage; j++) {
			// Concatena as p·ginas numa string ˙nica e devolve
			paginasConcatenadas = paginasConcatenadas.concat(this.stringfiedPages.get(j));
		}
		return paginasConcatenadas;
	}
	
	private String getResumoPages() {
		String paginasConcatenadas = "";
		int trueIndexer = this.stringfiedPages.size() - 1;
		for (int i = trueIndexer; i >= 0; i-- ) {
			//Acha a pagina do resumo e concatena ela com todas as p·ginas q vierem depois, retorna a stringzona
			Pattern pattern = Pattern.compile("((RESUMO)|(resumo))\\s+((TRIBUTA«√O\\sUTILIZANDO)|(tributacao\\sutilizando))");
			Matcher matcher = pattern.matcher(this.stringfiedPages.get(i));
			if (matcher.find()) {
				for (int j = i; j <= trueIndexer; j++ ) {
					paginasConcatenadas = paginasConcatenadas.concat(this.stringfiedPages.get(j));
				}
				break;
			}
		}
		return paginasConcatenadas;
	}
}
