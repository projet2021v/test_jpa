package main.java.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestJpaTP01 {

	public static void main(String[] args) {
		
		//TP01 - test de connexion
		try
		{
			EntityManagerFactory factory = Persistence.createEntityManagerFactory("pu_test_jpa");
			System.out.println("factory cr��e");
			
			EntityManager em = factory.createEntityManager();
			System.out.println("entity manager cr��");
			
			em.getTransaction().begin();
			System.out.println("connexion �tablie");
			
//			em.close();
//			factory.close();
//			System.out.println("connexion ferm�e");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

}
