package com.ty.manytooneuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveItemOrder {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Item item1 = new Item();
		item1.setName("Working table");
		item1.setPrice(14000);
		item1.setQuantity(2);

		Item item2 = new Item();
		item2.setName("Office Chair");
		item2.setPrice(5000);
		item2.setQuantity(5);

		/*Item item3 = new Item();
		item3.setName("Water Bottle");
		item3.setPrice(700);
		item3.setQuantity(2);*/

		AmazonOrder amazonOrder = new AmazonOrder();
		amazonOrder.setName("TE");
		amazonOrder.setAddress("Kathriguppe");
		amazonOrder.setStatus("Getting Prepared");

		item1.setAmazonOrder(amazonOrder);
		item2.setAmazonOrder(amazonOrder);
		//item3.setAmazonOrder(amazonOrder);

		entityTransaction.begin();
		entityManager.persist(amazonOrder);
		entityManager.persist(item1);
		entityManager.persist(item2);
	//	entityManager.persist(item3);
		entityTransaction.commit();

	}

}
