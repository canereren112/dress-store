package com.eren.dstore.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eren.dstore.dao.BeverageDao;
import com.eren.dstore.entity.Beverage;

@Repository
public class BeverageDaoJpa extends BaseDaoJpa<Beverage> implements BeverageDao {

	public List<Beverage> getAllBeverages() {
		return getEntityManager().createQuery("from Beverage b where b.status='A'").getResultList();
	}

	public Beverage getBeverageWithName(String name) {
		List<Beverage> beverages = getEntityManager().createQuery("from Beverage b where b.name=?1 and b.status='A'")
				.setParameter(1, name).getResultList();
		if (beverages.isEmpty()) {
			return null;
		} else {
			return beverages.get(0);
		}
	}
}
