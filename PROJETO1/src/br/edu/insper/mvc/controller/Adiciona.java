package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tasks;



/**
 * Servlet implementation class Adiciona
 */
@WebServlet("/adiciona")
public class Adiciona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adiciona() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAO dao;
		try {
			dao = new DAO();
		
		
		Tasks task = new Tasks();
		
		String nascimento = request.getParameter("data");
		java.util.Date data =new SimpleDateFormat("yyyy-MM-dd").parse(nascimento);
		Calendar dataNascimento =Calendar.getInstance();
		dataNascimento.setTime(data);
		
		task.setData(dataNascimento);
		
		task.setUsuario(request.getParameter("usuario"));
		task.setTag(request.getParameter("tag"));
		task.setTarefa(request.getParameter("tarefa"));
		
		dao.adiciona(task);
		
		request.setAttribute("tasks",task);
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
		

		
		
		dao.close();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
