package model;

public class Documento {
	//Atributos
	private int id;
	private String descricao;
	private String filePath;
	private String tipo;
	//Metodo Construtor
	public Documento(int id, String descricao, String filePath, String tipo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.filePath = filePath;
		this.tipo = tipo;
	}
	//Getters e Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
