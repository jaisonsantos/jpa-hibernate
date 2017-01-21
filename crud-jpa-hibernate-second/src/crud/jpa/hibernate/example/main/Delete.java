package crud.jpa.hibernate.example.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import crud.jpa.hibernate.example.model.Diary;

public class Delete {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		Diary diary = em.find(Diary.class, 7L);
		
		if (diary != null) {
			em.getTransaction().begin();
			em.remove(diary);
			em.getTransaction().commit();
			
			System.out.println("=================================");
			System.out.println("   Diary deleted successfully!   ");
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
