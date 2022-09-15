package com.online.controller;

import com.online.entity.MoviesDAO;
import com.online.entity.ShowDAO;
import com.online.entity.TheatreDAO;
import com.online.request.SearchTheatreRequest;
import com.online.response.Show;
import com.online.response.Theatre;
import com.online.response.TheatreDetails;
import com.online.service.TheatreServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Date;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(SpringExtension.class)
class SearchControllerTest {

    @InjectMocks
    SearchController searchController;

    @Mock
    private TheatreServiceImpl theatreService;// = Mockito.mock(TheatreServiceImpl.class);

    MockMvc mockMvc;

    @BeforeEach
    public void init() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
    }

    private TheatreDetails getTheatreDetails(){
        TheatreDetails theatreDetails = new TheatreDetails();
        TheatreDAO theatreDAO = new TheatreDAO();
        theatreDAO.setName("INOX Central");
        theatreDAO.setTown("Bengaluru");
        theatreDAO.setLocality("Bellandur");
        Theatre theatre = new Theatre(theatreDAO);

        MoviesDAO moviesDAO=new MoviesDAO();
        moviesDAO.setName("96");

        ShowDAO showDAO = new ShowDAO();
        showDAO.setFormat("2D");
        showDAO.setTicketClass("Classic");
        showDAO.setShowTime(new Date());
        showDAO.setLanguage("English");
        showDAO.setTheatre(theatreDAO);
        showDAO.setMovie(moviesDAO);
        Show show = new Show(showDAO);

        theatreDetails.setTheatre(theatre);
        theatreDetails.setShowInfo(Arrays.asList(show));
        return theatreDetails;
    }
    @Test
    public void testFindTheatres() throws Exception {
        TheatreDetails theatreDetails = getTheatreDetails();
        Mockito.when(theatreService.findTheatres(Mockito.any(SearchTheatreRequest.class))).thenReturn(Arrays.asList(theatreDetails));
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/find/theatres/town/{town}/date/{date}/movie/{movie}","Bengaluru",20220912,"96").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(theatreService).findTheatres(Mockito.any(SearchTheatreRequest.class));

    }
}