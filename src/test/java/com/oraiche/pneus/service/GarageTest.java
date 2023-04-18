package com.oraiche.pneus.service;

import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.repositories.PneuRepository;
import com.oraiche.pneus.services.GarageImp;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GarageTest {
    @InjectMocks
    GarageImp garageImp;

    @Mock
    PneuRepository pneuRepository;

    private List<Pneu> listPneusTest;
   @BeforeEach
   public void setUp()
   {
       Pneu pneuTest1=new Pneu(13,175,70,"Amine",650);
       Pneu pneuTest2=new Pneu(14,165,70,"Amine",600);
       Pneu pneuTest3=new Pneu(15,175,70,"Amine",750);
       // creat a list of pneus
       listPneusTest=new ArrayList<>(Arrays.asList(pneuTest1,pneuTest2,pneuTest3));

   }
    @Test
    public void findPneuByMarqueTest()
    {

   // Mockit PneuRepository

        Mockito.when(pneuRepository.findByMarque("Amine")).thenReturn(listPneusTest);

        List<Pneu> pneusAmines = garageImp.findPneusByMarque("Amine");
        assertEquals(true,pneusAmines.size()==3);
        assertEquals(600,pneusAmines.get(1).getPrix());
        assertEquals(15,pneusAmines.get(2).getLargeur());
    }

    @Test
    public void findPneuByIdTest()
    {
        Pneu pneuTest=new Pneu(13,175,70,"Amine",650);
        pneuTest.setId(3L);
       Mockito.when(pneuRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(pneuTest));

        Pneu pneuById = garageImp.findPneuById(3L);
        assertEquals(pneuById,pneuTest);
        assertEquals(pneuById.getPrix(),650);

    }

}
