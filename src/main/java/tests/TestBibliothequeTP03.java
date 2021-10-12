package main.java.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import main.java.boBibliotheque.Emprunt;
import main.java.boBibliotheque.Livre;

public class TestBibliothequeTP03 {
	
	static int id_emprunt = 4;
	static int id_client = 3;

	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) {
		
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_test_jpa");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			//-----------------------------------TOUS LES LIVRES D'UN EMPRUNT---------
			//recherche d'un emprunt
			Emprunt empruntRecherche = em.find(Emprunt.class, id_emprunt);
			
			//recherche des livres de cet emprunt
			Query livresEmpruntes = em.createQuery(
					"select l from Livre l "
					+ "inner join l.emprunts e "
					+ "where e.id = ?0");
			
			livresEmpruntes.setParameter(0, id_emprunt);
			
			List<Livre> listeLivres = livresEmpruntes.getResultList();
			
			//affichage de l'emprunt et des livres empruntés
			System.out.println(empruntRecherche.toString());
			for(Livre l : listeLivres) {
				System.out.println(l.toString());
			}
			
			System.out.println("------------------------------------------------");
			
			//-----------------------------------TOUS LES EMPRUNTS D'UN CLIENT---------
			Query empruntsDunClient = em.createQuery(
					"select e from Emprunt e "
					+ "inner join e.client c "
					+ "where c.id = ?0");
			
			empruntsDunClient.setParameter(0, id_client);
			
			List<Emprunt> listeEmprunts = empruntsDunClient.getResultList();
			
			//affichage des emprunts recherchés
			for(Emprunt e : listeEmprunts) {
				System.out.println(e.toString());
			}

			
			em.close();
			emf.close();

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
