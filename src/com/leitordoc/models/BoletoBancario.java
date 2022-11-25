package com.leitordoc.models;

import java.util.Date;
import com.leitordoc.validators.BoletoBancarioValidator;

public class BoletoBancario extends Documento {
	private String nomBeneficiario;
	private String docBeneficiario;
	private String codBeneficiario;
	private String moeda;
	private String codBanco;
	private String nomPagador;
	private String docPagador;
	private String linhaDigitavel;
	private Date emissao;
	private Date vencimento;
	private String valor;
	private String nossoNumero;
	private String localPagamento;
	private String multa;
	private String carteira;
	private String mora;
	private String aceite;
	private String instrucoes;
	private BoletoBancarioValidator validator;
	
	@Override
	public String toString() {
		return "BoletoBancario [nomBeneficiario=" + nomBeneficiario + ", docBeneficiario=" + docBeneficiario
				+ "\n, codBeneficiario=" + codBeneficiario + ", codBanco=" + codBanco + ", nomPagador=" + nomPagador
				+ ", docPagador=" + docPagador + ",\n linhaDigitavel=" + linhaDigitavel + ", emissao=" + emissao
				+ ", \n vencimento=" + vencimento + ", valor=" + valor + ", nossoNumero=" + nossoNumero
				+ ", \n localPagamento=" + localPagamento + ", multa=" + multa + ", carteira=" + carteira + ", mora="
				+ mora + "]";
	}
	
	public String getNomBeneficiario() {
		return nomBeneficiario;
	}
	public void setNomBeneficiario(String nomBeneficiario) {
		this.nomBeneficiario = nomBeneficiario;
	}
	public String getDocBeneficiario() {
		return docBeneficiario;
	}
	public void setDocBeneficiario(String docBeneficiario) {
		this.docBeneficiario = docBeneficiario;
	}
	public String getCodBeneficiario() {
		return codBeneficiario;
	}
	public void setCodBeneficiario(String codBeneficiario) {
		this.codBeneficiario = codBeneficiario;
	}
	public String getCodBanco() {
		return codBanco;
	}
	public void setCodBanco(String codBanco) {
		this.codBanco = codBanco;
	}
	public String getNomPagador() {
		return nomPagador;
	}
	public void setNomPagador(String nomPagador) {
		this.nomPagador = nomPagador;
	}
	public String getDocPagador() {
		return docPagador;
	}
	public void setDocPagador(String docPagador) {
		this.docPagador = docPagador;
	}
	public String getLinhaDigitavel() {
		return linhaDigitavel;
	}
	public void setLinhaDigitavel(String linhaDigitavel) {
		this.linhaDigitavel = linhaDigitavel;
	}
	public Date getEmissao() {
		return emissao;
	}
	public void setEmissao(Date emissao) {
		this.emissao = emissao;
	}
	public Date getVencimento() {
		return vencimento;
	}
	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getNossoNumero() {
		return nossoNumero;
	}
	public void setNossoNumero(String nossoNumero) {
		this.nossoNumero = nossoNumero;
	}
	public String getLocalPagamento() {
		return localPagamento;
	}
	public void setLocalPagamento(String localPagamento) {
		this.localPagamento = localPagamento;
	}
	public String getMulta() {
		return multa;
	}
	public void setMulta(String multa) {
		this.multa = multa;
	}
	public String getCarteira() {
		return carteira;
	}
	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	public String getMora() {
		return mora;
	}
	public void setMora(String mora) {
		this.mora = mora;
	}
	public BoletoBancario(int id, String descricao, String filePath, String tipo) {
		super(id, descricao, filePath, tipo);
		// TODO Auto-generated constructor stub
	}
	public String getAceite() {
		return aceite;
	}
	public void setAceite(String aceite) {
		this.aceite = aceite;
	}
	public String getInstrucoes() {
		return instrucoes;
	}
	public void setInstrucoes(String instrucoes) {
		this.instrucoes = instrucoes;
	}
	public String getMoeda() {
		return moeda;
	}
	public void setMoeda(String moeda) {
		this.moeda = moeda;
	}
	public BoletoBancario(int id, String descricao, String filePath, String tipo, String nomBeneficiario,
			String docBeneficiario, String codBeneficiario, String codBanco, String nomPagador, String docPagador,
			String linhaDigitavel, Date emissao, Date vencimento, String valor, String nossoNumero,
			String localPagamento, String multa, String carteira, String mora, String aceite, String instrucoes) {
		super(id, descricao, filePath, tipo);
		this.nomBeneficiario = nomBeneficiario;
		this.docBeneficiario = docBeneficiario;
		this.codBeneficiario = codBeneficiario;
		this.codBanco = codBanco;
		this.nomPagador = nomPagador;
		this.docPagador = docPagador;
		this.linhaDigitavel = linhaDigitavel;
		this.emissao = emissao;
		this.vencimento = vencimento;
		this.valor = valor;
		this.nossoNumero = nossoNumero;
		this.localPagamento = localPagamento;
		this.multa = multa;
		this.carteira = carteira;
		this.mora = mora;
		this.aceite = aceite;
		this.instrucoes = instrucoes;
	}
	public BoletoBancario(int id, String descricao, String filePath, String tipo, String nomBeneficiario,
			String docBeneficiario, String codBeneficiario, String codBanco, String nomPagador, String docPagador,
			String linhaDigitavel, Date emissao, Date vencimento, String valor, String nossoNumero,
			String localPagamento, String multa, String carteira, String mora) {
		super(id, descricao, filePath, tipo);
		this.nomBeneficiario = nomBeneficiario;
		this.docBeneficiario = docBeneficiario;
		this.codBeneficiario = codBeneficiario;
		this.codBanco = codBanco;
		this.nomPagador = nomPagador;
		this.docPagador = docPagador;
		this.linhaDigitavel = linhaDigitavel;
		this.emissao = emissao;
		this.vencimento = vencimento;
		this.valor = valor;
		this.nossoNumero = nossoNumero;
		this.localPagamento = localPagamento;
		this.multa = multa;
		this.carteira = carteira;
		this.mora = mora;
	}
	public BoletoBancario(int id, String descricao, String filePath, String tipo, String nomBeneficiario,
			String docBeneficiario, String codBeneficiario, String moeda, String codBanco, String nomPagador,
			String docPagador, String linhaDigitavel, Date emissao, Date vencimento, String valor, String nossoNumero,
			String localPagamento, String multa, String carteira, String mora, String aceite, String instrucoes) {
		super(id, descricao, filePath, tipo);
		this.nomBeneficiario = nomBeneficiario;
		this.docBeneficiario = docBeneficiario;
		this.codBeneficiario = codBeneficiario;
		this.moeda = moeda;
		this.codBanco = codBanco;
		this.nomPagador = nomPagador;
		this.docPagador = docPagador;
		this.linhaDigitavel = linhaDigitavel;
		this.emissao = emissao;
		this.vencimento = vencimento;
		this.valor = valor;
		this.nossoNumero = nossoNumero;
		this.localPagamento = localPagamento;
		this.multa = multa;
		this.carteira = carteira;
		this.mora = mora;
		this.aceite = aceite;
		this.instrucoes = instrucoes;
	}

	public BoletoBancarioValidator getValidator() {
		return validator;
	}

	public void setValidator(BoletoBancarioValidator validator) {
		this.validator = validator;
	}
}
