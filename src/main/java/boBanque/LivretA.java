package main.java.boBanque;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
	
	@Column(name = "taux")
	private double taux;

	public LivretA() {
		super();
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
	
	
	
}
