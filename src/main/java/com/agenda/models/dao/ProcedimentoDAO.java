package com.agenda.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agenda.models.entity.ProcedimentoEntity;

public class ProcedimentoDAO {
	private ConexaoBanco conexao = new ConexaoBanco();

	public List<ProcedimentoEntity> listarProcedimentos() {
		List<ProcedimentoEntity> procedimentos = new ArrayList<>();
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("select * from procedimento;");
			ResultSet rsProcedimentos = pst.executeQuery();
			while (rsProcedimentos.next()) {
				Integer id = rsProcedimentos.getInt(1);
				String nome = rsProcedimentos.getString(2);
				procedimentos.add(new ProcedimentoEntity(id, nome, null));
			}
			return procedimentos;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
	
	public List<ProcedimentoEntity> buscarProcedimentosPorIdDoPlanoDeSaude(Integer idProcedimento) {
		List<ProcedimentoEntity> procedimentos = new ArrayList<>();
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("select * "
					+ "from procedimento p, plano_saude ps, plano_procedimento pp "
					+ "where p.id = pp.id_procedimento and ps.id = pp.id_plano and ps.id = ?;");
			pst.setInt(1, idProcedimento);
			ResultSet rsProcedimentos = pst.executeQuery();
			while (rsProcedimentos.next()) {
				Integer id = rsProcedimentos.getInt(1);
				String nome = rsProcedimentos.getString(2);
				procedimentos.add(new ProcedimentoEntity(id, nome, null));
			}
			return procedimentos;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
	
	public ProcedimentoEntity buscarProcedimentoPorIdDaAgenda(Integer idAgenda) {
		ProcedimentoEntity procedimento = new ProcedimentoEntity();
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("select p.id, p.nome from procedimento p, agenda a where a.id_procedimento = p.id and a.id = ?;");
			pst.setInt(1, idAgenda);
			ResultSet rsProcedimentos = pst.executeQuery();
			while (rsProcedimentos.next()) {
				procedimento.setId(rsProcedimentos.getInt(1));
				procedimento.setNome(rsProcedimentos.getString(2));
			}
			return procedimento;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
}
