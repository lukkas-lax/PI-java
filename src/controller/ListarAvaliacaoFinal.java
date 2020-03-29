package controller;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.AvaliacaoService;
import service.EntregaService;
import model.Avaliacao;
import model.Entrega;


@WebServlet("/listar_avaliacaoFinal.do")
public class ListarAvaliacaoFinal  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String chave = request.getParameter("data[search]");
		String acao = request.getParameter("acao");
		
		AvaliacaoService tu = new AvaliacaoService();
		ArrayList<Avaliacao> listaAV = null;
		
		EntregaService et = new EntregaService();
		ArrayList<Entrega> listaAV2 = null;
		HttpSession session = request.getSession();
		
	if (acao.equals("buscar")) {
			if (chave != null && chave.length() > 0) {
				listaAV = tu.listarAvaliacao(chave);
				listaAV2 = et.listarEntrega(chave);
			
			} else {
				
				listaAV = tu.listarAvaliacao();
				listaAV2 = et.listarEntrega();
			}
			session.setAttribute("listaAV", listaAV);
			session.setAttribute("listaAV2", listaAV2);
			
			
		} else if (acao.equals("reiniciar")) {
			
			session.setAttribute("listaAV", listaAV);
			session.setAttribute("listaAV2", listaAV2);
		}
		
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("AcompanhamentoAvaliacaoAluno.jsp");
		dispatcher.forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}


