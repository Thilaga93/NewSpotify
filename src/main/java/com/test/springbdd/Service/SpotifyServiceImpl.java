package com.test.springbdd.Service;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.springbdd.Entity.Spotify;

@Repository
public class SpotifyServiceImpl implements SpotifyDao {
	
	@Autowired
	EntityManager entitymanager;

	public SpotifyServiceImpl(EntityManager theentitymanager) {
		super();
		this.entitymanager = theentitymanager;
	}



@Transactional
	public void save(Spotify theInstructor) {
	entitymanager.persist(theInstructor);
		
	}

	@Override
	public Spotify findInstructorById(int theId) {
		
		return entitymanager.find(Spotify.class, theId);
	}

	@Override
	public void deleteInstructorById(int theId) {
		// TODO Auto-generated method stub
		
	}

	
	
	

}
