package com.jpa.hibernate.course.model.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.hibernate.course.model.Client;

public class SavingFirstObject {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Client client = em.find(Client.class, 1L);
		
		if (client != null) {
			System.out.println("Existing client:" + client.getName());
		}
		else {
			client = new Client();
			client.setName("Pedro Lara");
			client.setAge(28);
			client.setProfession("Engenheiro Elétrico");
			client.setSex("M");
			em.persist(client);
		}
		
		Client client2 = em.find(Client.class, 2L);

		if (client2 != null) {
			System.out.println("Existing client:" + client2.getName());
		} 
		else {
			client2 = new Client();
			client2.setName("Maria Santos");
			client2.setAge(20);
			client2.setProfession("Médica");
			client2.setSex("F");
			em.persist(client2);
		}
		
		Client client3 = em.find(Client.class, 3L);
		
		if (client3 != null) {
			System.out.println("Existing client:" + client3.getName());
		}
		else {
			client3 = new Client();
			client3.setName("João Lucas");
			client3.setAge(23);
			client3.setProfession("Administrador");
			client3.setSex("M");
			em.persist(client3);
		}
		
		Client client4 = em.find(Client.class, 4L);
		
		if (client4 != null) {
			System.out.println("Existing client:" + client4.getName());
		}
		else {
			client4 = new Client();
			client4.setName("Laura Santo Pietro");
			client4.setAge(32);
			client4.setProfession("Gerente de Projetos");
			client4.setSex("F");
			em.persist(client4);
		}
		
		em.getTransaction().commit();

		System.out.println("===============================");
		System.out.println("####--Saved successfully!--####");
		System.out.println("===============================");
		
		em.close();
	}

}
