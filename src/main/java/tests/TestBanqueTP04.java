package main.java.tests;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import main.java.boBanque.Adresse;
import main.java.boBanque.AssuranceVie;
import main.java.boBanque.Banque;
import main.java.boBanque.Client;
import main.java.boBanque.Compte;
import main.java.boBanque.LivretA;
import main.java.boBanque.Operation;
import main.java.boBanque.Virement;

public class TestBanqueTP04 {

	public static void main(String[] args) {
		
		Adresse adresse1 = new Adresse(1, "rue1", 29000, "Quimper");
		Adresse adresse2 = new Adresse(2, "rue2", 29000, "Quimper");
		Adresse adresse3 = new Adresse(3, "rue3", 29000, "Quimper");
		
		Client client1 = new Client("nom1", "prenom1", LocalDate.now());
		Client client2 = new Client("nom2", "prenom2", LocalDate.now());
		Client client3 = new Client("nom3", "prenom3", LocalDate.now());
		
		client1.setAdresse(adresse1);
		client2.setAdresse(adresse2);
		client3.setAdresse(adresse3);
		
		
		Banque banque1 = new Banque("banque1");
		Banque banque2 = new Banque("banque2");
		Banque banque3 = new Banque("banque3");
		
		client1.setBanque(banque1);
		banque1.getClients().add(client1);
		
		client2.setBanque(banque2);
		banque2.getClients().add(client2);
		
		client3.setBanque(banque3);
		banque3.getClients().add(client3);
		
		
		Compte compte = new Compte("cpt1", 100);
		Compte livret = new LivretA("livretA", 200, 1.2);
		Compte assurance = new AssuranceVie("assuranceVie", 300, LocalDate.of(2030, 12, 31), 1.5);
	
		Operation operation1 = new Operation(LocalDateTime.now(), 1.0d, "salaire");
		Operation operation2 = new Operation(LocalDateTime.now(), 2.0d, "salaire");
		Operation operation3 = new Operation(LocalDateTime.now(), 3.0d, "salaire");
		Operation operation4 = new Operation(LocalDateTime.now(), 4.0d, "salaire");
		Operation operation5 = new Operation(LocalDateTime.now(), 5.0d, "salaire");
		Operation operation6 = new Operation(LocalDateTime.now(), 6.0d, "salaire");
		Operation operation7 = new Virement(LocalDateTime.now(), 7.0d, "don", "Institut Pasteur");
		
		compte.getOperations().add(operation1);
		operation1.setCompte(compte);
		compte.getOperations().add(operation2);
		operation2.setCompte(compte);
		compte.getOperations().add(operation3);
		operation3.setCompte(compte);
		
		assurance.getOperations().add(operation4);
		operation4.setCompte(assurance);
		assurance.getOperations().add(operation5);
		operation5.setCompte(assurance);
		
		livret.getOperations().add(operation6);
		operation6.setCompte(livret);
		livret.getOperations().add(operation7);
		operation7.setCompte(livret);
		
		
		client1.getComptes().add(compte);
		compte.getClients().add(client1);
		
		client2.getComptes().add(livret);
		livret.getClients().add(client2);
		
		client3.getComptes().add(assurance);
		assurance.getClients().add(client3);
		
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_banque");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(banque1);
			em.persist(banque2);
			em.persist(banque3);
			
			em.persist(compte);
			em.persist(livret);
			em.persist(assurance);
			
			em.persist(operation1);
			em.persist(operation2);
			em.persist(operation3);
			em.persist(operation4);
			em.persist(operation5);
			em.persist(operation6);
			em.persist(operation7);
			
			em.persist(client1);
			em.persist(client2);
			em.persist(client3);
			
			em.getTransaction().commit();
			
			em.close();
			emf.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
