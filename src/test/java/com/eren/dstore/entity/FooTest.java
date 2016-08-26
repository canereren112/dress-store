package com.eren.dstore.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hsqldb.util.DatabaseManagerSwing;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:**/servlet-context.xml")
@Transactional
public class FooTest {

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void shouldHaveAnEntityManager() {
		assertNotNull(entityManager);
	}

	@Test
	public void shouldHaveNoObjectsAtStart() {
		List<?> results = entityManager.createQuery("from Beverage").getResultList();
		assertTrue(results.isEmpty());
	}

	@Test
	public void shouldBeAbleToPersistAnObject() {
		assertEquals(0, entityManager.createQuery("from Beverage").getResultList().size());
		Beverage jobUser = new Beverage();
		jobUser.setCost(5);
		jobUser.setName("tea");
		jobUser.setCdate(new Date());
		entityManager.persist(jobUser);
		entityManager.flush();
		assertEquals(1, entityManager.createQuery("from Beverage").getResultList().size());
	}

	@Test
	public void shouldBeABleToQueryForObjects() {
		shouldBeAbleToPersistAnObject();

		assertEquals(1, entityManager.createQuery("from Beverage where name = 'tea'").getResultList().size());
		assertEquals(0, entityManager.createQuery("from Beverage where name = 'Baz'").getResultList().size());
	}

//	@After
//	public void startDBManager() {
//
//		// hsqldb
//		DatabaseManagerSwing.main(new String[] { "--url", "jdbc:hsqldb:hsql://localhost/kahvecidb", "--user", "sa", "--password", "" });
//
//	}
}
