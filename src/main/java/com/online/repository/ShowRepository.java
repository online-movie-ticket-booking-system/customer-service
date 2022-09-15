package com.online.repository;

import com.online.entity.ShowDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<ShowDAO,Long> {

    @Query("Select * from Shows INNER Join THEATRES on Shows.theatreId=Theatres.theatreId and movieId IN (SELECT id from MOVIES m  WHERE LOWER(m.movieName)=LOWER(:name)) and show.date=:date and show.town=:town")
    Optional<List<ShowDAO>> findByMovieNameAndDateAndTown(String name, Date date, String town);
}
