package com.oraiche.pneus;

import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.services.GarageImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PneusApplicationTests {
    @Autowired
    GarageImp garageImp;

    @Test
    void findByIdTest() {
       Pneu pneu =garageImp.findPneuById(1L);
        assertEquals("Lassa",pneu.getMarque());
        assertEquals(14,pneu.getLargeur());
    }


}
