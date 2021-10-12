package main.java.boBanque;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte {
	
	@Column(name = "taux")
	private double taux;

	public LivretA() {
		super();
	}

	public LivretA(String numero, double solde, double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		this.taux = taux;
	}
	
}
