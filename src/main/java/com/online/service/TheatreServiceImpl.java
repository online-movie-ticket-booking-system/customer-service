package com.online.service;

import com.online.entity.MoviesDAO;
import com.online.entity.ShowDAO;
import com.online.repository.MovieRepository;
import com.online.repository.ShowRepository;
import com.online.repository.TheatreRepository;
import com.online.request.SearchTheatreRequest;
import com.online.response.Show;
import com.online.response.Theatre;
import com.online.response.TheatreDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    ShowRepository showRepository;

    @Override
    public List<TheatreDetails> findTheatres(SearchTheatreRequest searchTheatreRequest){
        Optional<List<ShowDAO>> shows = showRepository.findByMovieNameAndDateAndTown(searchTheatreRequest.getMovieName(), searchTheatreRequest.getDate(), searchTheatreRequest.getTown());
        return shows.map(showDAOS -> showDAOS.stream().map(this::getTheatreDetails).collect(Collectors.toList())).orElse(Collections.EMPTY_LIST);
    }

    private TheatreDetails getTheatreDetails(ShowDAO showDAO){
        TheatreDetails theatreDetails = new TheatreDetails();
        Show show=new Show(showDAO);
        theatreDetails.setShowInfo(Arrays.asList(show));
        theatreDetails.setTheatre(new Theatre(showDAO.getTheatre()));
        return theatreDetails;
    }


}
