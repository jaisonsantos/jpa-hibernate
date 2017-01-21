package com.jpa.hibernate.course.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.hibernate.course.model.Client;

public class RemovingFirstObject {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		Client client = em.find(Client.class, 1L);

		em.getTransaction().begin();
		em.remove(client);
		em.getTransaction().commit();
		
		System.out.println("Client successfully removed!");
		
		em.close();
		
	}
	
}
