package com.agenda.models.entity;

import java.util.Objects;

public class RegraEntity {
	private Integer id;
	private Integer idade;
	private String sexo;
	private String permissao;
	private Integer idProcedimento;
	
	public RegraEntity() {
		super();
	}
	public RegraEntity(Integer id, Integer idade, String sexo, String permissao, Integer idProcedimento) {
		super();
		this.id = id;
		this.idade = idade;
		this.sexo = sexo;
		this.permissao = permissao;
		this.idProcedimento = idProcedimento;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getPermissao() {
		return permissao;
	}
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	public Integer getIdProcedimento() {
		return idProcedimento;
	}
	public void setIdProcedimento(Integer idProcedimento) {
		this.idProcedimento = idProcedimento;
	}
	@Override
	public String toString() {
		return "Regra [id=" + id + ", idade=" + idade + ", sexo=" + sexo + ", permissao=" + permissao
				+ ", idProcedimento=" + idProcedimento + "]";
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
		RegraEntity other = (RegraEntity) obj;
		return Objects.equals(id, other.id);
	}
}
