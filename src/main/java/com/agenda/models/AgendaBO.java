package com.agenda.models;

import java.util.List;

import com.agenda.models.dao.AgendaDAO;
import com.agenda.models.dao.ClienteDAO;
import com.agenda.models.dao.PlanoSaudeDAO;
import com.agenda.models.dao.ProcedimentoDAO;
import com.agenda.models.dto.AgendaDTO;
import com.agenda.models.entity.AgendaEntity;
import com.agenda.models.entity.ClienteEntity;
import com.agenda.models.entity.PlanoSaudeEntity;
import com.agenda.models.entity.ProcedimentoEntity;
import com.agenda.models.entity.RegraEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class AgendaBO.
 */
public class AgendaBO {
	
	/** The agenda dao. */
	private AgendaDAO agendaDao = new AgendaDAO();
	
	/**
	 * Listar agendas.
	 *
	 * @return the list
	 */
	public List<AgendaEntity> listarAgendas() {
		List<AgendaEntity> agendas = agendaDao.listarAgendas();
		for (AgendaEntity agenda : agendas) {
			ProcedimentoDAO procedimentoDao = new ProcedimentoDAO();
			ProcedimentoEntity procedimento = procedimentoDao.buscarProcedimentoPorIdDaAgenda(agenda.getId());
			ClienteDAO clienteDao = new ClienteDAO();
			ClienteEntity cliente = clienteDao.buscarClientePorIdDaAgenda(agenda.getId());
			PlanoSaudeDAO planoSaudeDao = new PlanoSaudeDAO();
			PlanoSaudeEntity planoSaude = planoSaudeDao.buscarPlanoDeSaudePorIdDoCliente(cliente.getId());
			cliente.setPlanoSaude(planoSaude);
			agenda.setCliente(cliente);
			agenda.setProcedimento(procedimento);
		}
		return agendas;
	}
	
	/**
	 * Inserir agenda.
	 *
	 * @param agenda the agenda
	 */
	public void inserirAgenda(AgendaDTO agenda) {
		agendaDao.inserirAgenda(agenda);
	}
	
	/**
	 * Checks if is plano cobre procedimento.
	 *
	 * @param plano the plano
	 * @param regras the regras
	 * @return the boolean
	 */
	public Boolean isPlanoCobreProcedimento(PlanoSaudeEntity plano, List<RegraEntity> regras) {
		for (RegraEntity regra : regras) {
			for (ProcedimentoEntity procedimento: plano.getProcedimentos()) {
				if (regra.getIdProcedimento() == procedimento.getId()) {
					return true;
				}
			}
		}
		return false;
	}
}
