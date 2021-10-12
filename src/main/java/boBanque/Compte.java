package main.java.boBanque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compte")
@Inheritance(strategy = InheritanceType.JOINED)
public class Compte {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "solde")
	private double solde;
	
	@ManyToMany(mappedBy = "comptes")
	private List<Client> clients;
	
	@OneToMany(mappedBy = "compte")
	private List<Operation> operations;

	public Compte() {
		clients = new ArrayList<Client>();
		operations = new ArrayList<Operation>();
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getId() {
		return id;
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
	
	
	
	
	
	

}
