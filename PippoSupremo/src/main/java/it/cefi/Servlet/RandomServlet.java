package it.cefi.Servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import it.cefi.models.DatiRandom;

@WebServlet("/Random")
public class RandomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int lungParole=DatiRandom.randLungPar();
		int numeroParole=DatiRandom.randNumPar();
		
		request.setAttribute("randomico1", lungParole);
		request.setAttribute("randomico2", numeroParole);
		request.getRequestDispatcher("Preparazione.jsp").forward(request, response);
		
		//-------------MANDO I VALORI RANDOM A READFILESERVLET-------------------
		HttpSession session = request.getSession();
		session.setAttribute("ReadFileR1", lungParole);
		session.setAttribute("ReadFileR2", numeroParole);
	
		
		request.getRequestDispatcher("/rFile").forward(request, response);
		
	}

}
