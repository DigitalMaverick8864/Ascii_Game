package it.cefi.readFiles;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

@WebServlet("/rFile")
@MultipartConfig
public class ReadFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// -----SERVE PER PESCARE I DATI CHE HO ACQUISITO DA
		// INPUT----------------------------
		response.sendRedirect(request.getContextPath() + "/Preparazione.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//----------------------INIZIALIZZO VARIABILI PER LETTURA DEI FILE-------------
		
		Part filePart1=request.getPart("file1");
		Part filePart2=request.getPart("file2");
		
		InputStream fileContenuto1=filePart1.getInputStream();
		InputStream fileContenuto2=filePart2.getInputStream();
		
		System.out.println(fileContenuto1.toString());
		System.out.println(fileContenuto2.toString());
		
		StringBuilder contenuto1=new StringBuilder();
		StringBuilder contenuto2=new StringBuilder();
		
		//-------------LETTURA DEI FILE-CALCOLO PUNTEGGIO PARZIALIE/TOTALE---------------
		String checkParole1="";
		String parola1;
		String spazio=" ";
		
		int sommaTot1=0;
		int checkSommaCharV1 = 0;
		int sommaCharV1 = 0;
		
		List<String> listaParole1=new ArrayList<String>();
		List<Integer> listaSommeParole1=new ArrayList<Integer>();
		

		try (BufferedReader br1=new BufferedReader(new InputStreamReader(fileContenuto1))){
			String line1;
			while((line1=br1.readLine())!=null) {
				contenuto1.append(line1);
				line1+=spazio;
				char[] arrChar1 = line1.toCharArray(); //trasforma la stringa che ha letto dai file in un array di char
				
				for (int i=0; i < arrChar1.length; i++) { //ciclo l'arraychar per procedere con i calcoli
					if(arrChar1[i]==32) {
						
						parola1=checkParole1; //casting diretto da char a string
						listaParole1.add(parola1);
						checkParole1="";
						
						sommaCharV1+=checkSommaCharV1;
						checkSommaCharV1=0;
						sommaTot1+=sommaCharV1;
						listaSommeParole1.add(sommaCharV1);
						sommaCharV1=0;
						
						System.out.println(parola1);
						System.out.println(sommaCharV1);
											
				    }else {
				    	checkParole1+=Character.toString(arrChar1[i]);
				    	checkSommaCharV1+=arrChar1[i];
				    	System.out.println(sommaTot1);
					}	
				   }	
			      }
			     }
	//**********************************************************************************	
		
		String checkParole2="";
		String parola2;
		int sommaTot2=0;
		int checkSommaCharV2 = 0;
		int sommaCharV2 = 0;
		
		List<String> listaParole2=new ArrayList<String>();
		List<Integer> listaSommeParole2=new ArrayList<Integer>();
		

		try (BufferedReader br2=new BufferedReader(new InputStreamReader(fileContenuto2))){
			String line2;
			while((line2=br2.readLine())!=null) {
				contenuto2.append(line2);
				line2+=spazio;
				char[] arrChar2 = line2.toCharArray();
				
				for (int i=0; i < arrChar2.length; i++) {
					if(arrChar2[i]==32) {
						
						parola2=checkParole2;
						listaParole2.add(parola2);
						checkParole2="";
						
						sommaCharV2+=checkSommaCharV2;
						checkSommaCharV2=0;
						sommaTot2+=sommaCharV2;
						listaSommeParole2.add(sommaCharV2);
						sommaCharV2=0;
						
						System.out.println(parola2);
						System.out.println(sommaCharV2);
											
				    }else {
				    	checkParole2+=Character.toString(arrChar2[i]);
				    	checkSommaCharV2+=arrChar2[i];
				    	System.out.println(checkSommaCharV2);
					}	
				   }	
			      }
			     }
		
		//------------------IMPORT I NOMI DEI PLAYER-------------------
		
		String pl1=request.getParameter("player1");
		String pl2=request.getParameter("player2");
		
		
		//------------------IMPORTO I VALORI RANDOM DA RANDOMSERVLET--------------
		
		HttpSession session = request.getSession();
		int randomLungParole= (int) session.getAttribute("ReadFileR1");
		int randomNumParole= (int) session.getAttribute("ReadFileR2");
				
		System.out.println(randomLungParole);
		System.out.println(randomNumParole);
		
		//-----------------------------CONTROLLO PAROLE INSERITE PLAYER1---------------------------------------
		
		
		if(listaParole1.size() > randomNumParole) {
			request.setAttribute("errore1","ERRORE "+pl1+": NUMERO PAROLE SUPERATO DI: "+(listaParole1.size() - randomNumParole));
			sommaTot1=0;
			listaParole1.clear();
			listaSommeParole1.clear();
		}else if(listaParole1.size() < randomNumParole) {
			request.setAttribute("errore1","ERRORE "+pl1+": NUMERO PAROLE INSUFFICIENTE DI: "+(randomNumParole - listaParole1.size()));
			sommaTot1=0;
			listaParole1.clear();
			listaSommeParole1.clear();
		}else if(listaParole1.get(0).length() > randomLungParole) {
			request.setAttribute("errore1","ERRORE "+pl1+": LUNGHEZZA PAROLE SUPERATO DI: "+(listaParole1.get(0).length() - randomLungParole));	
			sommaTot1=0;
			listaParole1.clear();
			listaSommeParole1.clear();
		}else if(listaParole1.get(0).length() < randomLungParole){
			request.setAttribute("errore1","ERRORE "+pl1+": LUNGHEZZA PAROLE INSUFFICIENTE DI: "+(randomLungParole - listaParole1.get(0).length()));	
			sommaTot1=0;
			listaParole1.clear();
			listaSommeParole1.clear();
			}
		//-----------------------------CONTROLLO PAROLE INSERITE PLAYER2---------------------------------------
				
		if(listaParole2.size() > randomNumParole) {
			request.setAttribute("errore2","ERRORE "+pl2+": NUMERO PAROLE SUPERATO DI: "+(listaParole2.size() - randomNumParole));
			sommaTot2=0;
			listaParole2.clear();
			listaSommeParole2.clear();
		}else if(listaParole2.size() < randomNumParole) {
			request.setAttribute("errore2","ERRORE "+pl2+": NUMERO PAROLE INSUFFICIENTE DI: "+(randomNumParole - listaParole2.size()));
			sommaTot2=0;
			listaParole2.clear();
			listaSommeParole2.clear();
		}else if(listaParole2.get(0).length() > randomLungParole) {
			request.setAttribute("errore2","ERRORE "+pl2+": LUNGHEZZA PAROLE SUPERATO DI: "+(listaParole2.get(0).length() - randomLungParole));	
			sommaTot2=0;
			listaParole2.clear();
			listaSommeParole2.clear();
		}else if(listaParole2.get(0).length() < randomLungParole){
			request.setAttribute("errore2","ERRORE "+pl2+": LUNGHEZZA PAROLE INSUFFICIENTE DI: "+(randomLungParole - listaParole2.get(0).length()));	
			sommaTot2=0;
			listaParole2.clear();
			listaSommeParole2.clear();
			}
		
		//-------------------REQUEST CALCOLO CHAR PLAYER1--------------------------
				
		request.setAttribute("sommaChar1", sommaTot1);
		request.setAttribute("contenuto1", listaParole1);
		request.setAttribute("sommaParoleParz1", listaSommeParole1);
				
		//-------------------REQUEST CALCOLO CHAR PLAYER2--------------------------
				
		request.setAttribute("sommaChar2", sommaTot2);
		request.setAttribute("contenuto2", listaParole2);
		request.setAttribute("sommaParoleParz2", listaSommeParole2);
		
		//----------------CREAZIONE DEL DATABASE E DELLA TABELLA-------------------
		//-----------------INSERIMENTO VINCITORE NEL DATABASE-----------------------
		Connection conn=null;
		Statement state=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/";
				String username="root";
				String password="1234";
				conn=DriverManager.getConnection(url,username,password);
				state=conn.createStatement();
				String create="CREATE DATABASE  IF NOT EXISTS asciiGame;";
				state.executeUpdate(create);
				String useTable="USE asciigame";
				state.executeUpdate(useTable);
			
				String tabella="CREATE TABLE IF NOT EXISTS winAsciiGame ("
						+ "  idPlayer int unsigned AUTO_INCREMENT NOT NULL,"
						+ "  nomeUtente varchar(45) NOT NULL,"
						+ "  numeroParoleInserite int NOT NULL,"
						+ "  lunghezzaParoleCaratteri int NOT NULL,"
						+ "  dataVittoria date NOT NULL,"
						+ "  punteggio int NOT NULL,"
						+ "  PRIMARY KEY (idPlayer)"
						+ ") ENGINE=InnoDB;";
				state.executeUpdate(tabella);
			}catch (SQLException | ClassNotFoundException e){
				e.printStackTrace();
			}		
		//----------------BANNER VINCITORE----------------
		String winner=null;		
		if(sommaTot1 > sommaTot2) {
			request.setAttribute("vincitore", "HA VINTO: "+pl1);	
			winner=pl1;
			int rndNumPar=0+randomNumParole;
			int rndLunPar=0+randomLungParole;
			long millisTime=System.currentTimeMillis();
			Date dataVittoria=new Date(millisTime);
			PreparedStatement statement=null;
			//if (winner != null) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/asciigame";
					String username="root";
					String password="1234";
					state=conn.createStatement();
					conn=DriverManager.getConnection(url,username,password);
					String query="INSERT INTO winasciigame (nomeUtente,numeroParoleInserite,lunghezzaParoleCaratteri,dataVittoria,punteggio) VALUES (?,?,?,?,?);";
					statement=conn.prepareStatement(query);
					statement.setString(1, winner);
					statement.setInt(2, rndNumPar);
					statement.setInt(3, rndLunPar);
					statement.setDate(4, dataVittoria);
					statement.setInt(5, sommaTot1);
					statement.executeUpdate();
					conn.close();
				
				}catch (Exception e) {
					e.printStackTrace();;
				}
		
		}else if(sommaTot1 < sommaTot2){
			request.setAttribute("vincitore", "HA VINTO: "+pl2);	
			winner=pl2;
			int rndNumPar=0+randomNumParole;
			int rndLunPar=0+randomLungParole;
			long millisTime=System.currentTimeMillis();
			Date dataVittoria=new Date(millisTime);
			PreparedStatement statement=null;
			//if (winner != null) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/asciigame";
					String username="root";
					String password="1234";
					state=conn.createStatement();
					conn=DriverManager.getConnection(url,username,password);
					String query="INSERT INTO winasciigame (nomeUtente,numeroParoleInserite,lunghezzaParoleCaratteri,dataVittoria,punteggio) VALUES (?,?,?,?,?);";
					statement=conn.prepareStatement(query);
					statement.setString(1, winner);
					statement.setInt(2, rndNumPar);
					statement.setInt(3, rndLunPar);
					statement.setDate(4, dataVittoria);
					statement.setInt(5, sommaTot2);
					statement.executeUpdate();
					conn.close();
				
				}catch (Exception e) {
					e.printStackTrace();;
				}
		
		}else if(sommaTot1==sommaTot2 && sommaTot1>0 && sommaTot2 >0){  
			request.setAttribute("vincitore", "PAREGGIO");	
		}else if(sommaTot1==0 && sommaTot2==0){
			request.setAttribute("vincitore", "PARTITA NON VALIDA");
		}
		request.getRequestDispatcher("Result.jsp").forward(request, response);

}
}
