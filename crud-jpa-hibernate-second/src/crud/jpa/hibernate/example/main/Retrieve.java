package crud.jpa.hibernate.example.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import crud.jpa.hibernate.example.model.Diary;

public class Retrieve {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		Diary diary = em.find(Diary.class, 1L);
		
		if (diary != null) {
			System.out.println("#############################################");
			System.out.println("Name: " + diary.getName());
			System.out.println("Phone: " + diary.getPhone());
			System.out.println("Registration date: " + diary.getRegistrationDate());
			System.out.println("#############################################");
		}
		else {
			System.out.println("===========================");
			System.out.println("   Diary already exists!   ");
			System.out.println("===========================");			
		}
		
		em.close();
	}

}
