package it.cefi.models;

import java.sql.Date;

public class Tabella {
	private int idPlayer;
	private String nomeUtente;
	private int numeroParoleInserite;
	private int lunghezzaParoleCaratteri;
	private Date dataVittoria;
	private int punteggio;
	
	public int getIdplayer() {
		return idPlayer;
	}
	public void setIdplayer(int idPlayer) {
		this.idPlayer = idPlayer;
	}
	public String getNomeutente() {
		return nomeUtente;
	}
	public void setNomeutente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}
	public int getNumeroparole() {
		return numeroParoleInserite;
	}
	public void setNumeroparoleinserite(int numeroParoleInserite) {
		this.numeroParoleInserite = numeroParoleInserite;
	}
	public int getLunghezzaparolecaratteri() {
		return lunghezzaParoleCaratteri;
	}
	public void setLunghezzaparolecaratteri(int lunghezzaParoleCaratteri) {
		this.lunghezzaParoleCaratteri = lunghezzaParoleCaratteri;
	}
	public Date getDatavittoria() {
		return dataVittoria;
	}
	public void setDatavittoria(Date dataVittoria) {
		this.dataVittoria = dataVittoria;
	}
	public int getPunteggio() {
		return punteggio;
	}
	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}

	
}
