package com.agenda.models.dto;

import java.util.Objects;

import org.joda.time.DateTime;

public class AgendaDTO {
	private Integer id;
	private Integer idProcedimento;
	private Integer idCliente;
	private DateTime dataExecucao;
	
	public AgendaDTO() {
		super();
	}
	public AgendaDTO(Integer id, Integer idProcedimento, Integer idCliente, DateTime dataExecucao) {
		super();
		this.id = id;
		this.idProcedimento = idProcedimento;
		this.idCliente = idCliente;
		this.dataExecucao = dataExecucao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdProcedimento() {
		return idProcedimento;
	}
	public void setIdProcedimento(Integer idProcedimento) {
		this.idProcedimento = idProcedimento;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public DateTime getDataExecucao() {
		return dataExecucao;
	}
	public void setDataExecucao(DateTime dataExecucao) {
		this.dataExecucao = dataExecucao;
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
		AgendaDTO other = (AgendaDTO) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "AgendaDTO [id=" + id + ", idProcedimento=" + idProcedimento + ", idCliente=" + idCliente
				+ ", dataExecucao=" + dataExecucao + "]";
	}
}
