package com.agenda.models.entity;

import java.util.List;
import java.util.Objects;

public class PlanoSaudeEntity {
	private Integer id;
	private String nome;
	private List<ProcedimentoEntity> procedimentos;
	
	public PlanoSaudeEntity() {
		super();
	}
	public PlanoSaudeEntity(Integer id, String nome, List<ProcedimentoEntity> procedimentos) {
		super();
		this.id = id;
		this.nome = nome;
		this.procedimentos = procedimentos;
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
	public List<ProcedimentoEntity> getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(List<ProcedimentoEntity> procedimentos) {
		this.procedimentos = procedimentos;
	}
	@Override
	public String toString() {
		return "PlanoSaude [id=" + id + ", nome=" + nome + ", procedimentos=" + procedimentos + "]";
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
		PlanoSaudeEntity other = (PlanoSaudeEntity) obj;
		return Objects.equals(id, other.id);
	}
}
