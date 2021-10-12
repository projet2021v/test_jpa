package main.java.boBanque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class AssuranceVie extends Compte {
	
	@Column(name = "date_fin")
	private LocalDate dateFin;
	
	@Column(name = "taux")
	private double taux;
	
	public AssuranceVie() {
		super();
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	

}
