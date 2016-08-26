package com.eren.dstore.dao.jpa;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eren.dstore.dao.CondimentDao;
import com.eren.dstore.entity.Condiment;

@Repository
public class CondimentDaoJpa extends BaseDaoJpa<Condiment> implements CondimentDao {

	public List<Condiment> getAllCondiments() {
		return getEntityManager().createQuery(
				"from Condiment b where b.status='A'").getResultList();
	}

	public Condiment getCondimentWithName(String name) {
		List<Condiment> Condiments = getEntityManager()
				.createQuery("from Condiment b where b.name=?1 and b.status='A'")
				.setParameter(1, name).getResultList();
		if(Condiments.isEmpty()) {
			return null;
		} else {
			return Condiments.get(0);
		}
	}
}
