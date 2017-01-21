package com.jpa.hibernate.course.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.hibernate.course.model.Client;

public class UpdateFirstObject {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		Client client = em.find(Client.class, 1L);
		if (client != null) {
			em.getTransaction().begin();
			client.setName("Thales Araujo Costa");
			client.setAge(39);
			client.setSex("M");
			client.setProfession("Encanador");
			em.getTransaction().commit();
		}
		else {
			System.out.println("Client not found");
		}
		
		System.out.println("Client successfully updated!");
		em.close();
	}
}
