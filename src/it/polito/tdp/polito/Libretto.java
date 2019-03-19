package it.polito.tdp.polito;

import java.util.*;

public class Libretto {
	private List<Voto> voti;

	public Libretto() {
		this.voti = new ArrayList<Voto>(); // vuota e nulla sono due cose diverse

	}

	// aggiunge un nuovo voto al libretto
	/**
	 * uso la delega chiamando il metodo con lo stesso nome della funzione
	 * 
	 * @param v il { {@link} da aggiungere
	 */
	public void add(Voto v) {
		voti.add(v);

	}/*
		 * public void StampaVoti(int Voti) {
		 * 
		 * } public String StampaVoti1(int Voti) { return null; }
		 */
	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * @param punti 
	 * @return
	 */

	public List<Voto> StampaVoti2(int voti) {
		List<Voto> result = new ArrayList<Voto>();
		for (Voto v : this.voti) {
			if (v.getPunti() == voti) {
				result.add(v);
			}
		}
		return result;
	}
	/**
	 * 
	 * @param nomeEsame nome del corso da ricercare
	 * @return il {@link Voto} 
	 */
	public Voto cercaNomeEsame(String nomeEsame) {
		for(Voto v: this.voti) {
			if(v.getCorso().equals(nomeEsame)) {
				return v;
			}
		}
		return null;
	}
	/**
	 * dato un {@link voto } determina se esiste già un voto con 
	 * uguale corso e uguale punti 
	 * @param v
	 * @return {@code true } se ha trovato corso e punti uguali 
	 *         {@code false } se non li ha trovati
	 */
	public boolean esisteGiaVoto(Voto v) {
		Voto trovato=this.cercaNomeEsame(v.getCorso());
		if(trovato==null) {
			return false;
		} 
		if(trovato.getPunti()==v.getPunti()){
			return true ;
			} else return false;
		
	}

}
