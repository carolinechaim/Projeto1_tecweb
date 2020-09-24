package br.edu.insper.mvc.controller;

import java.io.IOException;
import java.sql.SQLException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.insper.mvc.model.DAO;
import br.edu.insper.mvc.model.Tasks;


/**
 * Servlet implementation class Lista
 */
@WebServlet("/lista")
public class Lista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
protected void service (HttpServletRequest request,
		HttpServletResponse response) throws ServletException,IOException{
		
				
			DAO dao;
			try {
				dao = new DAO();

			
			Tasks task = new Tasks();
			
			task.setTag(request.getParameter("tag"));
			
			if (request.getParameter("tag") != "todos" ) {
				List<Tasks> tasks = dao.getListaMod(task);
				request.setAttribute("tasks",tasks);
				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
					
			} else {
			
			List<Tasks> tasks = dao.getLista();
			request.setAttribute("tasks",tasks);
			RequestDispatcher dispatcher = request.getRequestDispatcher("lista.jsp");
			dispatcher.forward(request, response);
				
			} 
			

			dao.close();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		

				
			}		

}