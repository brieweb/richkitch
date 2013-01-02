package com.brie.webapps.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.event.Reception;
import javax.enterprise.inject.Produces;

import javax.inject.Inject;
import javax.inject.Named;

import com.brie.webapps.model.Contestant;

@RequestScoped
public class ContestantListProducer {

	@Inject 
	private ContestantRepository contestantRepository;
	
	private List<Contestant> contestants;
	
	@Produces
	@Named
	public List<Contestant> getContestants() {
		return contestants;
	}
	
	public void onContestantListChanged(@Observes(notifyObserver = Reception.IF_EXISTS) final Contestant contestant) {
		retrieveAllContestantsByFirstName();
	}
	
	@PostConstruct
	public void retrieveAllContestantsByFirstName() {
		contestants = contestantRepository.findAllOrderedByFirstName();
	}

}