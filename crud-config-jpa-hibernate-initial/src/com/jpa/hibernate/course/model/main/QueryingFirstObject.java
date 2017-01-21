package com.jpa.hibernate.course.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.hibernate.course.model.Client;

public class QueryingFirstObject {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		Client client = em.find(Client.class, 1L);
		
		if (client == null) {
			System.out.println("Client not found!");
		} 
		else {
			System.out.println("Name: " + client.getName());
			System.out.println("Age: " + client.getAge());
			System.out.println("Sex: " + client.getSex());
			System.out.println("Profession: " + client.getProfession());
		}
		
		em.close();
		
	}

}
