package com.agenda.models.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.agenda.models.entity.ClienteEntity;

public class ClienteDAO {
	private ConexaoBanco conexao = new ConexaoBanco();
	
	public List<ClienteEntity> listarClientes() {
		List<ClienteEntity> clientes = new ArrayList<>();
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("select * from cliente;");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt(1);
				String nome = rs.getString(2);
				Integer idade = rs.getInt(3);
				String sexo = rs.getString(4);
				clientes.add(new ClienteEntity(id, nome, idade, sexo, null));
			}
			return clientes;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
	
	public ClienteEntity buscarClientePorIdDaAgenda(Integer idAgenda) {
		conexao.conectar();
		try {
			PreparedStatement pst = conexao.getPreparedStatement("select c.id, c.nome, c.idade, c.sexo, c.id_plano from cliente c, agenda a where a.id_cliente = c.id and a.id = ?;");
			pst.setInt(1, idAgenda);
			ResultSet rs = pst.executeQuery();
			ClienteEntity cliente = new ClienteEntity();
			while (rs.next()) {
				cliente.setId(rs.getInt(1));
				cliente.setNome(rs.getString(2));
				cliente.setIdade(rs.getInt(3));
				cliente.setSexo(rs.getString(4));
			}
			return cliente;
		} catch (Exception e) {
			return null;
		} finally {
			conexao.desconectar();
		}
	}
}
