package com.agenda.models.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// TODO: Auto-generated Javadoc
/**
 * The Class ConexaoBanco.
 */
public class ConexaoBanco {
	
	/** The driver. */
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/agenda?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "usuario";
	
	/** The password. */
	private String password = "senha";
	
	/** The conexao. */
	private Connection conexao = conectar();

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	protected Connection conectar() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			return conn;
		} catch(Exception e) {
			return null;
		}
	}
	
	/**
	 * Gets the prepared statement.
	 *
	 * @param query the query
	 * @return the prepared statement
	 */
	protected PreparedStatement getPreparedStatement(String query) {
		try {
			return this.conexao.prepareStatement(query);
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * Desconectar.
	 *
	 * @return the boolean
	 */
	protected Boolean desconectar() {
		try {
			this.conexao.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
