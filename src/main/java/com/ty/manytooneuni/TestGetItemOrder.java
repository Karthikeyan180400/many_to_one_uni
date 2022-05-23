package com.ty.manytooneuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestGetItemOrder {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Item item = entityManager.find(Item.class, 4);
		if (item != null) {

			System.out.println("");
			System.out.println("Item name is " + item.getName());
			System.out.println("Price is " + item.getPrice());
			System.out.println("Quantity is " + item.getQuantity());
			System.out.println("------------------------------------");

			AmazonOrder amazonOrder = item.getAmazonOrder();
			System.out.println("Order name is " + amazonOrder.getName());
			System.out.println("Order address is " + amazonOrder.getAddress());
			System.out.println("Order status is " + amazonOrder.getStatus());
		} else {
			System.out.println("There is no item for given Id");
		}
		

	}

}
