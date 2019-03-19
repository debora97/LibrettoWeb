package it.polito.tdp.polito;

import java.time.LocalDate;
import java.util.List;

public class TestLibretto {

	//potrei creare questo main nella classe Libretto
	public static void main(String[] args) {
		Libretto libr = new Libretto();
		libr.add(new Voto(25, "pwr" , LocalDate.of(2019, 12, 25)));
		libr.add(new Voto(26, "pgp" , LocalDate.of(2018, 1, 12)));
		libr.add(new Voto(29, "analisi" , LocalDate.of(2007, 03, 13)));
		libr.add(new Voto(21, "fisica" , LocalDate.of(2019, 04, 25)));
		libr.add(new Voto(22, "geo" , LocalDate.of(2018, 01, 15)));
		libr.add(new Voto(24, "st" , LocalDate.of(2018, 01, 16)));
		libr.add(new Voto(25, "chimica" , LocalDate.of(2019, 01, 24)));
		libr.add(new Voto(20, "po" , LocalDate.of(2017, 07, 29)));
		libr.add(new Voto(19, "eoa" , LocalDate.of(2017, 07, 8)));
		libr.add(new Voto(18, "ro" , LocalDate.of(2017, 07, 9)));
		
		List<Voto> vc= libr.StampaVoti2(25);
		System.out.println(vc);
		Voto a1= libr.cercaNomeEsame("pwr");
		Voto a2=libr.cercaNomeEsame("Analisi3");
		System.out.println(a1);
		System.out.println(a2);
		Voto giusti= new Voto(22, "geo", LocalDate.now());
		Voto sbagliato = new Voto(22, "geo", LocalDate.now());
		
		
		
		

	}

}
