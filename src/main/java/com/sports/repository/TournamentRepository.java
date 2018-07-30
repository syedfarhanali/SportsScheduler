package com.sports.repository;

import com.sports.entity.Event;
import com.sports.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by farhans on 7/26/18.
 */
@Repository
public interface TournamentRepository extends JpaRepository<Tournament,Integer>{

}
