package com.jpa.hibernate.course.model.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.hibernate.course.model.Client;

public class QueryWithJPQL {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		List<Client> clients = em.createQuery("from Client", Client.class).getResultList();
		System.out.println("================ Clients ================");
		for (Client cli : clients) {
			System.out.println("Name: " + cli.getName());
			System.out.println("Age: " + cli.getAge());
			System.out.println("Profession: " + cli.getProfession());
			System.out.println("Sex: " + cli.getSex());
			System.out.println("-----------------------------------------");
		}
		em.close();
	}

}
