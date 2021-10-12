package main.java.boBanque;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "VIR")
public class Virement extends Operation {
	
	@Column(name = "beneficiaire")
	private String beneficiaire;

	public Virement() {
		super();
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
}
