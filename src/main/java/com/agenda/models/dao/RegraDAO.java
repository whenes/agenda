package com.agenda.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agenda.models.entity.RegraEntity;

public class RegraDAO {
	private ConexaoBanco conexao = new ConexaoBanco();

	public List<RegraEntity> buscarRegrasDoProcedimento(Integer idProcedimento) {
		List<RegraEntity> regras = new ArrayList<>();
		conexao.conectar();
		try {
			PreparedStatement pstRegras = conexao.getPreparedStatement("select * from regra where id_procedimento = ?;");
			pstRegras.setInt(1, idProcedimento);
			ResultSet rsRegras = pstRegras.executeQuery();
			while (rsRegras.next()) {
				Integer id = rsRegras.getInt(1);
				Integer idade = rsRegras.getInt(2);
				String sexo = rsRegras.getString(3);
				String permissao = rsRegras.getString(4);
				regras.add(new RegraEntity(id, idade, sexo, permissao, idProcedimento));
			}
			return regras;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
	
	public List<RegraEntity> listarRegras() {
		List<RegraEntity> regras = new ArrayList<>();
		conexao.conectar();
		try {
			PreparedStatement pstRegras = conexao.getPreparedStatement("select * from regra;");
			ResultSet rsRegras = pstRegras.executeQuery();
			while (rsRegras.next()) {
				Integer id = rsRegras.getInt(1);
				Integer idade = rsRegras.getInt(2);
				String sexo = rsRegras.getString(3);
				String permissao = rsRegras.getString(4);
				Integer idProcedimento = rsRegras.getInt(5);
				regras.add(new RegraEntity(id, idade, sexo, permissao, idProcedimento));
			}
			return regras;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
}
