package main.java.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestBanqueTP04 {

	public static void main(String[] args) {
		
		try
		{
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_banque");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.close();
			emf.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}


	}

}
