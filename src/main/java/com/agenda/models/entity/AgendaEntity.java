package com.agenda.models.entity;

import java.util.Objects;

import org.joda.time.DateTime;

// TODO: Auto-generated Javadoc
/**
 * The Class AgendaEntity.
 */
public class AgendaEntity {
	
	/** The id. */
	private Integer id;
	
	/** The procedimento. */
	private ProcedimentoEntity procedimento;
	
	/** The cliente. */
	private ClienteEntity cliente;
	
	/** The data execucao. */
	private DateTime dataExecucao;
	
	/**
	 * Instantiates a new agenda entity.
	 */
	public AgendaEntity() {
		super();
	}
	
	/**
	 * Instantiates a new agenda entity.
	 *
	 * @param id the id
	 * @param procedimento the procedimento
	 * @param cliente the cliente
	 * @param dataExecucao the data execucao
	 */
	public AgendaEntity(Integer id, ProcedimentoEntity procedimento, ClienteEntity cliente, DateTime dataExecucao) {
		super();
		this.id = id;
		this.procedimento = procedimento;
		this.cliente = cliente;
		this.dataExecucao = dataExecucao;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * Gets the procedimento.
	 *
	 * @return the procedimento
	 */
	public ProcedimentoEntity getProcedimento() {
		return procedimento;
	}
	
	/**
	 * Sets the procedimento.
	 *
	 * @param procedimento the new procedimento
	 */
	public void setProcedimento(ProcedimentoEntity procedimento) {
		this.procedimento = procedimento;
	}
	
	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public ClienteEntity getCliente() {
		return cliente;
	}
	
	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	
	/**
	 * Gets the data execucao.
	 *
	 * @return the data execucao
	 */
	public DateTime getDataExecucao() {
		return dataExecucao;
	}
	
	/**
	 * Sets the data execucao.
	 *
	 * @param dataExecucao the new data execucao
	 */
	public void setDataExecucao(DateTime dataExecucao) {
		this.dataExecucao = dataExecucao;
	}
	
	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendaEntity other = (AgendaEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Agenda [id=" + id + ", procedimento=" + procedimento + ", cliente=" + cliente + ", dataExecucao="
				+ dataExecucao + "]";
	}
}
