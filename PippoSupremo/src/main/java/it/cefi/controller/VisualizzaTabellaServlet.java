package it.cefi.controller;

import jakarta.servlet.ServletException;			//-
import jakarta.servlet.annotation.WebServlet;		//-
import jakarta.servlet.http.HttpServlet;			//-
import jakarta.servlet.http.HttpServletRequest;		//-
import jakarta.servlet.http.HttpServletResponse;	//-
import java.io.IOException;							//-
import java.sql.Connection;							//-
import java.sql.DriverManager;						//-
import java.sql.PreparedStatement;					//-
import java.sql.ResultSet;							//-
import java.sql.SQLException;						//-
import java.util.ArrayList;							//-
import java.util.List;								//-
import it.cefi.models.Tabella;

@WebServlet("/visualizzaTabella")
public class VisualizzaTabellaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Tabella> table = new ArrayList<Tabella>();
		Connection conn=null;
		PreparedStatement statement=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/asciigame";
			//String url="jdbc:mysql://127.0.0.1:3306/asciigame?serverTimeZone=UTC";
			String username = "root";
			String password = "1234";
			conn = DriverManager.getConnection(url, username, password);
			String query = "SELECT * FROM winasciigame";
			statement = conn.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				Tabella tabella = new Tabella();
				tabella.setIdplayer(resultSet.getInt("idPlayer"));
				tabella.setNomeutente(resultSet.getString("nomeUtente"));
				tabella.setNumeroparoleinserite(resultSet.getInt("numeroParoleInserite"));
				tabella.setLunghezzaparolecaratteri(resultSet.getInt("lunghezzaParoleCaratteri"));
				tabella.setDatavittoria(resultSet.getDate("dataVittoria"));
				tabella.setPunteggio(resultSet.getInt("punteggio"));
				table.add(tabella);
			}
			
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("winasciigame", table);
		request.getRequestDispatcher("Tabella.jsp").forward(request, response);
		
	}
	
}
