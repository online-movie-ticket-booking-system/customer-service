package com.online.controller;

import com.online.request.SearchTheatreRequest;
import com.online.response.TheatreDetails;
import com.online.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/find")
public class SearchController {

    @Autowired
    TheatreService theatreService;

    @GetMapping("/theatres/town/{town}/date/{date}/movie/{movie}")
    public List<TheatreDetails> findTheatres(@PathVariable(required = true) String town,
                                             @PathVariable(required = true) String date,
                                            @PathVariable(required = true) String movie) throws ParseException {

        Date date1= new SimpleDateFormat("yyyyMMdd").parse(date);
        SearchTheatreRequest searchBuilder = new SearchTheatreRequest.Builder().setTown(town).
                setMovieName(movie).setDate(date1).build();
        return theatreService.findTheatres(searchBuilder);
    }
}
