package com.online.service;

import com.online.request.SearchTheatreRequest;
import com.online.response.TheatreDetails;

import java.util.List;

public interface TheatreService {
    List<TheatreDetails> findTheatres(SearchTheatreRequest searchTheatreRequest);
}
