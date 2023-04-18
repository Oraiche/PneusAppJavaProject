package com.oraiche.pneus.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.services.GarageImp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc(addFilters = false)
public class GarageControllerTest  {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    GarageImp garageImp;

    @Test
    public void findPneusByMarqueTest() throws Exception{
        Pneu pneuTest1=new Pneu(13,175,70,"Amine",650);
        Pneu pneuTest2=new Pneu(14,165,70,"Amine",600);
        Pneu pneuTest3=new Pneu(15,175,70,"Amine",750);

        // creat a list of pneus
        List<Pneu> listPneusTest=new ArrayList<>(Arrays.asList(pneuTest1,pneuTest2,pneuTest3));

        Mockito.when(garageImp.findPneusByMarque("Amine")).thenReturn(listPneusTest);

        mockMvc.perform(get("/pneusByMarque/{marque}","Amine")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void addPneuTest() throws Exception {
        Pneu pneuTest1 = new Pneu(13, 175, 70, "Amine", 650);


        Mockito.when(garageImp.addPneu(Mockito.any(Pneu.class))).thenReturn(pneuTest1);

        mockMvc.perform(MockMvcRequestBuilders.post("/addPneu")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content( objectMapper.writeValueAsString(pneuTest1)))
                        .andExpect(status().isOk()
                                );





    }
}
