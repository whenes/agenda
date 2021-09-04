package com.agenda.models.entity;

import java.util.Objects;

public class ClienteEntity {
	private Integer id;
	private String nome;
	private Integer idade;
	private String sexo;
	private PlanoSaudeEntity planoSaude;
	
	public ClienteEntity() {
		super();
	}
	public ClienteEntity(Integer id, String nome, Integer idade, String sexo, PlanoSaudeEntity planoSaude) {
		super();
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.sexo = sexo;
		this.planoSaude = planoSaude;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public PlanoSaudeEntity getPlanoSaude() {
		return planoSaude;
	}
	public void setPlanoSaude(PlanoSaudeEntity planoSaude) {
		this.planoSaude = planoSaude;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", idade=" + idade + ", sexo=" + sexo + ", planoSaude="
				+ planoSaude + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteEntity other = (ClienteEntity) obj;
		return Objects.equals(id, other.id);
	}
}
