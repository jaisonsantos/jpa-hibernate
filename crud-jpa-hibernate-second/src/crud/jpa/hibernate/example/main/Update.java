package crud.jpa.hibernate.example.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import crud.jpa.hibernate.example.model.Diary;

public class Update {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		Diary diary = em.find(Diary.class, 1L);
		
		if (diary != null) {
			diary.setName("Developer Forever");
			diary.setPhone("(23) 2445-7690");
			diary.setRegistrationDate(new Date());

			em.getTransaction().commit();
			
			System.out.println("=================================");
			System.out.println("   Diary Updated Successfully!   ");
			System.out.println("=================================");
		}
		else {
			System.out.println("======================");
			System.out.println("   Diary not found!   ");
			System.out.println("======================");
		}
		
		em.close();
	}
	
}
