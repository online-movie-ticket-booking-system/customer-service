package com.online.response;

import com.online.request.ShowType;

import javax.persistence.Column;
import java.util.List;

public class Movie {
    private long id;
    private String name;
    private ShowType type;
    private double rating;
    private List<String> genre;
    private List<String> language;
    private String format;
    private List<String> town;
}
