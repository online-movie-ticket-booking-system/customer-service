package com.online.response;

import com.online.entity.ShowDAO;

import java.util.List;

public class TheatreDetails {
    private Theatre theatre;
    private List<Show> showInfo;

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<Show> getShowInfo() {
        return showInfo;
    }

    public void setShowInfo(List<Show> showInfo) {
        this.showInfo = showInfo;
    }


}
