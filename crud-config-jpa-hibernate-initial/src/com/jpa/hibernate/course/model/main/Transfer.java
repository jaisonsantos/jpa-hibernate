package com.jpa.hibernate.course.model.main;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.jpa.hibernate.course.model.Bill;

public class Transfer {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
			
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		Bill bill = em.find(Bill.class, 1L);
		
		if (bill == null){
			System.out.print("Enter the opening balance of account 1: ");
			Double initialBallanceAccount = input.nextDouble();
			bill = new Bill();
			bill.setBallance(initialBallanceAccount);
		}
		
		Bill bill2 = em.find(Bill.class, 2L);
		
		if (bill2 == null){
			System.out.print("Enter the opening balance of account 2: ");
			Double initialBallanceAccount2 = input.nextDouble();
			bill2 = new Bill();
			bill2.setBallance(initialBallanceAccount2);
		}
		
		em.getTransaction().begin();
		em.persist(bill); 
		em.persist(bill2);
		em.getTransaction().commit();
		
		em.close();
		em = emf.createEntityManager();
		
		System.out.println("=============== Begin Transaction ================");
		System.out.println("Account Balance 1: " + bill.getBallance());
		System.out.println("Account Balance 2: " + bill2.getBallance());
		System.out.println("================ End Transaction =================");
		
		System.out.print("Enter the value of the transfer from account 1 to account 2: ");
		Double transferValue = input.nextDouble();

		em.getTransaction().begin();
		bill.setBallance(bill.getBallance() - transferValue);
		bill2.setBallance(bill2.getBallance() + transferValue);
		
		em.merge(bill);
		em.merge(bill2);

		if (bill.getBallance() > 0){
			em.getTransaction().commit();
			System.out.print("Transfer sucessfully!");
		}
		else {
			em.getTransaction().rollback();
			System.err.print("Transfer not done, insufficient balance.");
		}

		em.close();
	}
}
