package com.oraiche.pneus.web;

import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.entities.Vente;
import com.oraiche.pneus.services.VenteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VenteController {
    public VenteService venteService;

    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @GetMapping("/ventes")
    List<Vente> getPneusVendue()
    {
        return venteService.getVentes();
    }
    @GetMapping("/ventes/{id}")
    List<Pneu> getPneusVendue(@PathVariable(name = "id") Long id)
    {
        return venteService.pneusVendue(id);
    }
}
