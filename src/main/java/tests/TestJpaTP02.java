package main.java.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import main.java.bo.Livre;

public class TestJpaTP02 {

	public static void main(String[] args) {
		
		//TP02 - Entité
		try
		{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_test_jpa");
			EntityManager em = factory.createEntityManager();
			
			em.getTransaction().begin();
			
			//recherche du livre dont l'id est 3
			System.out.println("recherche du livre dont l'id est 3");
			
			Livre l3 = em.find(Livre.class, 3);
			if(l3 != null) {
				System.out.println(l3.getTitre() + ", par " + l3.getAuteur());
			}
			
			System.out.println("-------");
			
			
			//ajout d'un livre en base
			System.out.println("ajout d'un livre en base");

			Livre nouveauLivre = new Livre();
			nouveauLivre.setTitre("La planète des singes");
			nouveauLivre.setAuteur("Pierre Boulle");
			em.persist(nouveauLivre);
			
			System.out.println("-------");
			
			
			//modification du livre dont l'id est 5
			System.out.println("modification du livre dont l'id est 5");

			Livre l5 = em.find(Livre.class, 5);
			if(l5 != null) {
				l5.setTitre("Du plaisir dans la cuisine");
				em.merge(l5);
			}
			
			System.out.println("-------");

			
			//requête JPQL: extraire livre en fonction de son titre
			System.out.println("requête JPQL: extraire livre en fonction de son titre");

			TypedQuery<Livre> livreDapresTitre = em.createQuery("select l from Livre l where l.titre = ?0", Livre.class);
			livreDapresTitre.setParameter(0, "Germinal");

			Livre germinal = livreDapresTitre.getSingleResult();
			if(germinal != null) {
				System.out.println(germinal.toString());
			}
			
			System.out.println("-------");
			
			
			//requête JPQL: extraire livre en fonction de son auteur
			System.out.println("requête JPQL: extraire livre en fonction de son auteur");

			TypedQuery<Livre> livreDapresAuteur = em.createQuery("select l from Livre l where l.auteur = ?0", Livre.class);
			livreDapresAuteur.setParameter(0, "Jules Verne");

			Livre vingtMilleLieuxSousLesMers = livreDapresAuteur.getSingleResult();
			if(vingtMilleLieuxSousLesMers != null) {
				System.out.println(vingtMilleLieuxSousLesMers.toString());
			}
			
			System.out.println("-------");
			
			
			//suppression du livre ajouté ci-dessus
			System.out.println("suppression du livre ajouté ci-dessus");

			livreDapresTitre.setParameter(0, "La planète des singes");
			Livre livreASupprimer = livreDapresTitre.getSingleResult();
			if(livreASupprimer != null) {
				em.remove(livreASupprimer);
			}
			
			System.out.println("-------");
			
			
			//liste de tous les livres en base
			System.out.println("liste de tous les livres en base");

			TypedQuery<Livre> listeQuery = em.createQuery("select l from Livre l", Livre.class);
			List<Livre> listeLivres = listeQuery.getResultList();
			for(Livre l : listeLivres) {
				System.out.println(l.toString());
			}
			
			System.out.println("-------");
			
			em.getTransaction().commit();
			em.close();
			factory.close();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
