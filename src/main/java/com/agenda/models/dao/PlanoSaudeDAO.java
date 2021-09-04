package com.agenda.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.agenda.models.entity.PlanoSaudeEntity;

public class PlanoSaudeDAO {
	private ConexaoBanco conexao = new ConexaoBanco();
	
	public PlanoSaudeEntity buscarPlanoDeSaudePorId(Integer idPlanoSaude) {
		PlanoSaudeEntity planoSaude = new PlanoSaudeEntity();
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("select * from plano_saude where id = ?;");
			pst.setInt(1, idPlanoSaude);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				planoSaude.setId(rs.getInt(1));
				planoSaude.setNome(rs.getString(2));
				planoSaude.setProcedimentos(null);
			}
			return planoSaude;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
	
	public PlanoSaudeEntity buscarPlanoDeSaudePorIdDoCliente(Integer idCliente) {
		PlanoSaudeEntity planoSaude = new PlanoSaudeEntity();
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("select p.id, p.nome from cliente c, plano_saude p where c.id_plano = p.id and c.id = ?;");
			pst.setInt(1, idCliente);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				planoSaude.setId(rs.getInt(1));
				planoSaude.setNome(rs.getString(2));
				planoSaude.setProcedimentos(null);
			}
			return planoSaude;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
}
