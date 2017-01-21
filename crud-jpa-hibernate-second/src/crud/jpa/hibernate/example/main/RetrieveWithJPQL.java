package crud.jpa.hibernate.example.main;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import crud.jpa.hibernate.example.model.Diary;

public class RetrieveWithJPQL {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		List<Diary> diares = em.createQuery("from Diary", Diary.class).getResultList();
		System.out.println("================ Diares ================");
		for (Diary d : diares) {
			System.out.println("Name: " + d.getName());
			System.out.println("Phone: " + d.getPhone());
			System.out.println("Registration Date: " + d.getRegistrationDate());
			System.out.println("----------------------------------------");
		}
		em.close();
	}

}
