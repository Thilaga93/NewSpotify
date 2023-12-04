package com.test.springbdd.Service;

import com.test.springbdd.Entity.Spotify;


public interface SpotifyDao {
		
		void save(Spotify theInstructor);	
		Spotify findInstructorById(int theId);
		void deleteInstructorById(int theId);

	}


