package com.agenda.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joda.time.DateTime;

import com.agenda.models.AgendaBO;
import com.agenda.models.dao.ClienteDAO;
import com.agenda.models.dao.ProcedimentoDAO;
import com.agenda.models.dto.AgendaDTO;
import com.agenda.models.entity.AgendaEntity;
import com.agenda.models.entity.ClienteEntity;
import com.agenda.models.entity.ProcedimentoEntity;

// TODO: Auto-generated Javadoc
/**
 * The Class AgendaServlet.
 */
@WebServlet(urlPatterns = {"/agenda", "/inserir", "/criar", "/listar"})
public class AgendaServlet extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The agenda bo. */
	AgendaBO agendaBo;

	/**
	 * Instantiates a new agenda servlet.
	 */
	public AgendaServlet() {
		super();
	}
	
	/**
	 * Gets the agenda BO.
	 *
	 * @return the agenda BO
	 */
	private AgendaBO getAgendaBO() {
		return agendaBo = new AgendaBO();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		switch (request.getServletPath()) {
			case "/agenda":
				response.sendRedirect("index.jsp");
				break;
			case "/inserir":
				inserirAgenda(request, response);
				break;
			case "/listar":
				listarAgendas(request, response);
				break;
			case "/criar":
				criarAgenda(request, response);
				break;				
		}
	}
	
	/**
	 * Listar agendas.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarAgendas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<AgendaEntity> agendas = getAgendaBO().listarAgendas();		
		
		request.setAttribute("agendas", agendas);
		RequestDispatcher rd = request.getRequestDispatcher("listar.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * Criar agenda.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void criarAgenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<ProcedimentoEntity> procedimentos = new ProcedimentoDAO().listarProcedimentos();		
		List<ClienteEntity> clientes = new ClienteDAO().listarClientes();
		request.setAttribute("procedimentos", procedimentos);
		request.setAttribute("clientes", clientes);
		RequestDispatcher rd = request.getRequestDispatcher("criar.jsp");
		rd.forward(request, response);
	}
	
	/**
	 * Inserir agenda.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void inserirAgenda(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AgendaDTO agenda = new AgendaDTO();
		agenda.setIdProcedimento(Integer.parseInt(request.getParameter("idProcedimento")));
		agenda.setIdCliente(Integer.parseInt(request.getParameter("idCliente")));
		agenda.setDataExecucao(new DateTime(request.getParameter("dataExecucao")));
		agendaBo.inserirAgenda(agenda);
		response.sendRedirect("listar");
		
	}
}
