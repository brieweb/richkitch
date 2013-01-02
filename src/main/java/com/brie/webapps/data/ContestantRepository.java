package com.brie.webapps.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.brie.webapps.model.Contestant;

@ApplicationScoped
public class ContestantRepository {

	@Inject
	private EntityManager em;
	
	public Contestant findById(Long id) {
		return em.find(Contestant.class, null);
	}
	
	public List<Contestant> findAllOrderedByFirstName() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Contestant> criteria = cb.createQuery(Contestant.class);
		Root<Contestant> contestant = criteria.from(Contestant.class);
		criteria.select(contestant).orderBy(cb.asc(contestant.get("firstName")));
		return em.createQuery(criteria).getResultList();
	}
}
