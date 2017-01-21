package crud.jpa.hibernate.example.main;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import crud.jpa.hibernate.example.model.Diary;


public class Create {

	public static void main(String[] args) {
		//Temporary code, used to exemplify operation.
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ExamplePU");
		EntityManager em = emf.createEntityManager();
		
		Diary diary = em.find(Diary.class, 1L);
		em.getTransaction().begin();
		
		if (diary != null){
			System.out.println("Existing Diary: " + diary.getName());
		}
		else {
			diary = new Diary();
			diary.setName("My Life");
			diary.setPhone("(21) 2435-6519");
			diary.setRegistrationDate(new Date());
			em.persist(diary);
		}
		
		Diary diary2 = em.find(Diary.class, 2L);
		
		if (diary2 != null){
			System.out.println("Existing Diary: " + diary2.getName());
		}
		else {
			diary2 = new Diary();
			diary2.setName("Java Forever?");
			diary2.setPhone("(22) 3582-9945");
			diary2.setRegistrationDate(new Date());
			em.persist(diary2);
		}
		
		Diary diary3 = em.find(Diary.class, 3L);
		
		if (diary3 != null){
			System.out.println("Existing Diary: " + diary3.getName());
		}
		else {
			diary3 = new Diary();
			diary3.setName("Detent Diary");
			diary3.setPhone("(81) 3967-8513");
			diary3.setRegistrationDate(new Date());
			em.persist(diary3);
		}
		
		Diary diary4 = em.find(Diary.class, 4L);
		
		if (diary4 != null){
			System.out.println("Existing Diary: " + diary4.getName());
		}
		else {
			diary4 = new Diary();
			diary4.setName("Dilemma");
			diary4.setPhone("(11) 3932-0358");
			diary4.setRegistrationDate(new Date());
			em.persist(diary4);
		}
		
		Diary diary5= em.find(Diary.class, 5L);
		
		if (diary5 != null){
			System.out.println("Existing Diary: " + diary5.getName());
		}
		else {
			diary5 = new Diary();
			diary5.setName("My Immortals");
			diary5.setPhone("(22) 2234-9212");
			diary5.setRegistrationDate(new Date());
			em.persist(diary5);
		}

		em.getTransaction().commit();
		
		System.out.println("===============================");
		System.out.println("  Successfully created diary!  ");
		System.out.println("===============================");

		em.close();
	}

}
