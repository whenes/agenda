package com.agenda.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.agenda.models.dto.AgendaDTO;
import com.agenda.models.entity.AgendaEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class AgendaDAO.
 */
public class AgendaDAO {
	
	/** The conexao. */
	private ConexaoBanco conexao = new ConexaoBanco();
	
	/**
	 * Listar agendas.
	 *
	 * @return the list
	 */
	public List<AgendaEntity> listarAgendas() {
		List<AgendaEntity> agendas = new ArrayList<>();
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("select id, data_execucao from agenda;");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				DateTime dataExecucao = new DateTime(rs.getDate(2));
				agendas.add(new AgendaEntity(id, null, null, dataExecucao));
			}
			return agendas;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
	
	/**
	 * Buscar agenda por id.
	 *
	 * @param idAgenda the id agenda
	 * @return the agenda entity
	 */
	public AgendaEntity buscarAgendaPorId(Integer idAgenda) {
		conexao.conectar();
		AgendaEntity agenda = new AgendaEntity();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("select id, data_execucao from agenda where id = ?;");
			pst.setInt(1, idAgenda);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				agenda.setId(rs.getInt(1));
				agenda.setDataExecucao(new DateTime(rs.getDate(2)));
			}
			return agenda;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
	
	/**
	 * Inserir agenda.
	 *
	 * @param agenda the agenda
	 */
	public void inserirAgenda(AgendaDTO agenda) {
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("insert into agenda (id_procedimento, id_cliente, data_execucao) values (?, ?, ?);");
			pst.setInt(1, agenda.getIdProcedimento());
			pst.setInt(2, agenda.getIdCliente());
			
			DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
			String dateString = fmt.print(agenda.getDataExecucao());
			
			pst.setString(3, dateString);
			pst.executeUpdate();
		} catch (Exception e) {
			return;
		} finally {
			conexao.desconectar();
		}
	}
}
