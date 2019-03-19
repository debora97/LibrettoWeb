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
	 * @return {@code true} nel caso normale 
	 * {@code false} nel caso normale 
	 */
	public boolean add(Voto v) {
		if(!this.esisteGiaVoto(v) && !this.votoConflitto(v)){
			voti.add(v);
			return true;
		}else {
			return false;
		}
		

	}/*
		 * public void StampaVoti(int Voti) {
		 * 
		 * } public String StampaVoti1(int Voti) { return null; }
		 */

	/**
	 * Seleziona il sottoinsieme di voti che hanno il punteggio specificato
	 * 
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
		Voto voto = new Voto(0, nomeEsame, null);

		int pos = this.voti.indexOf(voto);
		if (pos == -1) {
			return null;
		} else
			return this.voti.get(pos);
	}

	/**
	 * dato un {@link voto } determina se esiste già un voto con uguale corso e
	 * uguale punti
	 * 
	 * @param v
	 * @return {@code true } se ha trovato corso e punti uguali {@code false } se
	 *         non li ha trovati
	 */
	public boolean esisteGiaVoto(Voto v) {
		int pos = this.voti.indexOf(v);
		if (pos == -1)
			return false;
		else {
			// è un conflitto solo se il corso c'è ma ha un voto diverso
			return (v.getPunti() == this.voti.get(pos).getPunti()); // senza fare if else basta tornare quello che mi
																	// dice lui

		}
	}

	/**
	 * mi dice se il {@link Voto} {@code v} è in conflitto con uno dei voti
	 * esistenti , se il voto non esiste non c'è conflitto
	 * 
	 * @param v
	 * @return {@code true  }se il voto esiste ed ha un punteggio diverso {
	 *         {@code false } se il voto
	 */
	public boolean votoConflitto(Voto v) {
		int pos = this.voti.indexOf(v);
		if (pos == -1)
			return false;
		else {
			// è un conflitto solo se il corso c'è ma ha un voto diverso
			return (v.getPunti() != this.voti.get(pos).getPunti());
		}

	}
	
	@Override
	public String toString() {
		return String.format("Libretto [voti=%s]", voti);
	}

	public Libretto librettoMigliorato() {
		Libretto nuovo= new Libretto();
		for(Voto v: this.voti) {
			nuovo.add(v.clone()); // (ricordati di fare il new altrimenti modifica anche gli attributi di  voti di v)
		}
		for(Voto v: nuovo.voti) {
			int punti= (v.getPunti());
			if(punti<24) {
				punti+=1;
			}else if(punti<=28)
				punti=punti+2;
			v.setPunti(punti);
		}
		return nuovo;
	}
	
	public void cancellaVotiScarsi() {
		
		List<Voto> cancellare=new ArrayList<Voto>();
		for(Voto v: this.voti) {
			if(v.getPunti()<24) {
			cancellare.add(v);
			}
		}
		this.voti.removeAll(cancellare);
		//questa cosa non si fa perchè mentre scorro una lista non posso modificare gli elementi
		/*for(Voto v: this.voti) {
			if(v.getPunti()<24) {
				this.voti.remove(v);
			}
		}*/
	}

}
