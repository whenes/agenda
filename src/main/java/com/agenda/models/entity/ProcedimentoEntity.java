package com.agenda.models.entity;

import java.util.List;
import java.util.Objects;

public class ProcedimentoEntity {
	private Integer id;
	private String nome;
	private List<RegraEntity> regras;
	
	public ProcedimentoEntity() {
		super();
	}
	public ProcedimentoEntity(Integer id, String nome, List<RegraEntity> regras) {
		super();
		this.id = id;
		this.nome = nome;
		this.regras = regras;
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
	public List<RegraEntity> getRegras() {
		return this.regras;
	}
	public void setRegras(List<RegraEntity> regras) {
		this.regras = regras;
	}
	@Override
	public String toString() {
		return "Procedimento [id=" + id + ", nome=" + nome + ", regras [" + regras + "]";
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
		ProcedimentoEntity other = (ProcedimentoEntity) obj;
		return Objects.equals(id, other.id);
	}
}
