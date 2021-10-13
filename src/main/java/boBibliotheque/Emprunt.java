package main.java.boBibliotheque;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="emprunt")
public class Emprunt {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="date_debut")
	private Date date_debut;
	
	@Column(name="date_fin")
	private Date date_fin;
	
	@Column(name="delai")
	private Integer delai;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private ClientBibli client;
	
	@ManyToMany(mappedBy="emprunts")
	private List<Livre> livresEmpruntes;

	public Emprunt() {
		livresEmpruntes = new ArrayList<Livre>();
	}

	public Date getDate_debut() {
		return date_debut;
	}

	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}

	public Date getDate_fin() {
		return date_fin;
	}

	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public ClientBibli getClient() {
		return client;
	}

	public void setClient(ClientBibli client) {
		this.client = client;
	}

	public List<Livre> getLivresEmpruntes() {
		return livresEmpruntes;
	}

	public void setLivresEmpruntes(List<Livre> livresEmpruntes) {
		this.livresEmpruntes = livresEmpruntes;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emprunt [id=");
		builder.append(id);
		builder.append(", date_debut=");
		builder.append(date_debut);
		builder.append(", date_fin=");
		builder.append(date_fin);
		builder.append(", delai=");
		builder.append(delai);
		builder.append(", client=");
		builder.append(client);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	

}
