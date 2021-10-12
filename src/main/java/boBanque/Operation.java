package main.java.boBanque;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
@DiscriminatorValue(value = "OPE")
public class Operation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "date")
	private LocalDateTime date;
	
	@Column(name = "montant")
	private double montant;
	
	@Column(name = "motif")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name = "compte_id")
	private Compte compte;

	public Operation() {}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public int getId() {
		return id;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	
	
	

}
