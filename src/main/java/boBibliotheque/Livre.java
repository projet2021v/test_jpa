package main.java.boBibliotheque;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="titre")
	private String titre;
	
	@Column(name="auteur")
	private String auteur;
	
	@ManyToMany
	@JoinTable(
			name="compo",
			joinColumns=@JoinColumn(name="id_liv", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="id_emp", referencedColumnName="id")
	)
	private List<Emprunt> emprunts;

	public Livre() {
		emprunts = new ArrayList<Emprunt>();
	}

	public Integer getId() {
		return id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public List<Emprunt> getEmprunts() {
		return emprunts;
	}

	public void setEmprunts(List<Emprunt> emprunts) {
		this.emprunts = emprunts;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Livre [id=");
		builder.append(id);
		builder.append(", titre=");
		builder.append(titre);
		builder.append(", auteur=");
		builder.append(auteur);
		builder.append("]");
		return builder.toString();
	}
	
	

	

	
	
	

}
