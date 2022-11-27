package com.leitordoc.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aspose.pdf.*;

import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.google.gson.Gson;
import com.leitordoc.models.BensEDireitos;
import com.leitordoc.models.BoletoBancario;
import com.leitordoc.models.DeclaracaoIR;
import com.leitordoc.models.DividasOnus;
import com.leitordoc.models.Endereco;
import com.leitordoc.models.ImpostoPagoRetido;
import com.leitordoc.models.Ocupacao;
import com.leitordoc.models.RendimentoNaoTributavelIsento;
import com.leitordoc.models.RendimentosTributacaoExclusiva;
import com.leitordoc.models.Resumo;
import com.leitordoc.utils.Boleto1Utils;
import com.leitordoc.utils.EnderecoUtils;
import com.leitordoc.utils.IR1Utils;
import com.leitordoc.utils.OcupacaoUtils;
import com.leitordoc.utils.ResumoUtils;
import com.leitordoc.validators.ResumoValidator;

public class IrToJsonService {
	private ArrayList<String> stringfiedPages;
	
	
	public IrToJsonService() {
		super();
		this.stringfiedPages = new ArrayList<String>();
	}

	public static DeclaracaoIR convert (String filePath) {	
		IrToJsonService service = new IrToJsonService();
		try {
			service.setReadExtractionMethod(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		ArrayList<String> pages = service.getStringfiedPages();
		
		String nome = IR1Utils.getNome(pages.get(0));
		String cpf = IR1Utils.getCPF(pages.get(0));
		String exercicio = IR1Utils.getExercicio(pages.get(0));
		String anoCalendario = IR1Utils.getAnoCalendario(pages.get(0));
		Endereco endereco = EnderecoUtils.mountEndereco(pages.get(0));
		Ocupacao ocupacao = OcupacaoUtils.mountOcupacao(pages.get(0));
		System.out.println(pages.get(0));
//		ArrayList<String> dependentes = IR1Utils.getDependentes(pages.get(0));
//		System.out.println(anoCalendario);

//		private ArrayList<String> dependentes; 
		
//		// TODO Simplificada vs completa
//		private ArrayList<String> rendimentosJPDependentes;
//		private ArrayList<String> rendimentosPFExteriorTitular;
//		private ArrayList<String> rendimentosPFExteriorDependente;
//		private RendimentoNaoTributavelIsento rendimentoNaoTributavelIsento;
//		private RendimentosTributacaoExclusiva rendimentosTributacaoExclusiva;
//		private ImpostoPagoRetido impostoPagoRetido;
//		private BensEDireitos bensEDireitos;
//		private DividasOnus dividasOnus;
		
//		private Resumo resumo;
		String paginasResumo = service.getResumoPages();
		ResumoValidator rv = ResumoUtils.mountResumo(paginasResumo);

		
		DeclaracaoIR dir = new DeclaracaoIR();
//		
//		System.out.println(new Gson().toJson(dir));
		return dir; //Boleto em Json
	}

	public void setReadExtractionMethod(String filePath) throws IOException {
		File arquivo = new File(filePath);
		PDDocument documento = PDDocument.load(arquivo);
		Splitter splitter = new Splitter();
		ArrayList<PDDocument> pages = (ArrayList<PDDocument>) splitter.split(documento);
		PDFTextStripper pdfStripper = new PDFTextStripper();
		pdfStripper.setSortByPosition(true);
		pdfStripper.setLineSeparator("\n");
		for (PDDocument page : pages) {
			String texto = pdfStripper.getText(page);
			this.addStringfiedPage(texto);
		}
		documento.close();
	}
	
	public ArrayList<String> getStringfiedPages() {
		return stringfiedPages;
	}

	public void addStringfiedPage(String stringfiedPage) {
		this.stringfiedPages.add(stringfiedPage);
	}

	public String getResumoPages() {
		String paginasConcatenadas = "";
		int trueIndexer = this.stringfiedPages.size() - 1;
		for (int i = trueIndexer; i >= 0; i-- ) {
			//Acha a pagina do resumo e concatena ela com todas as páginas q vierem depois, retorna a stringzona
			Pattern pattern = Pattern.compile("((RESUMO)|(resumo))\\s+((TRIBUTAÇÃO\\sUTILIZANDO)|(tributacao\\sutilizando))");
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
