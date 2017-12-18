package site.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
//chaar de pontos criticos
@Entity
@Table(name="Conteudo")
public class Conteudo {
	@Id
	@Column(name="id")
	@GeneratedValue
	private int id;
	@Column(name="nome")
	private String nome;
	@Column(name="tipo")
	private String tipo;
	@Column(name="endereco")
	private String endereco;
	@Column(name="mensagem")
	private String mensagem;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	
	
}
