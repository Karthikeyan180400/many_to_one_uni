package com.ty.manytooneuni;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveHospitalBranch {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Branch branch1 = new Branch();
		branch1.setName("BTM Branch");
		branch1.setState("Karnataka");
		branch1.setCountry("India");
		branch1.setPhone(11117777);

		Branch branch2 = new Branch();
		branch2.setName("Gandhi Nagar Branch");
		branch2.setState("Tamil Nadu");
		branch2.setCountry("India");
		branch2.setPhone(22220044);

		Branch branch3 = new Branch();
		branch3.setName("West Fornia Branch");
		branch3.setState("California");
		branch3.setCountry("USA");
		branch3.setPhone(12219900);

		Hospital hospital = new Hospital();
		hospital.setName("KS Hospital");
		hospital.setWebsite("ks.com");

		branch1.setHospital(hospital);
		branch2.setHospital(hospital);
		branch3.setHospital(hospital);

		entityTransaction.begin();
		entityManager.persist(hospital);
		entityManager.persist(branch1);
		entityManager.persist(branch2);
		entityManager.persist(branch3);
		entityTransaction.commit();

	}

}
