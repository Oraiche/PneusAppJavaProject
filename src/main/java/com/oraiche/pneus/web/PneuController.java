package com.oraiche.pneus.web;

import ch.qos.logback.core.model.Model;
import com.oraiche.pneus.PneusApplication;
import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.repositories.PneuRepository;
import com.oraiche.pneus.services.GarageImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class PneuController {
    @Autowired
   private PneuRepository pneuRepository;

    @Autowired
    private GarageImp garageImp;


    @GetMapping("/index")
    @ResponseBody
    public List<Pneu> pneu(@RequestParam(name="marque",defaultValue = "Lassa") String marque,
                           @RequestParam(name="largeur",defaultValue = "14") int largeur )
    {

         return  pneuRepository.findByMarqueAndLargeur(marque,largeur);
    }

    @GetMapping("/compter")
    @ResponseBody
    public int comptePneus(@RequestParam(name="marque",defaultValue = "Lassa") String marque,
                           @RequestParam(name="largeur",defaultValue = "14") int largeur )
    {

        return  pneuRepository.findByMarqueAndLargeur(marque,largeur).size();
    }

    @GetMapping("/prixPneus")
    @ResponseBody
    public Map<String, Double> prixPneus(@RequestParam(name="largeur",defaultValue = "14") int largeur)
    {
        return garageImp.prix(largeur);
    }

    @GetMapping("/prixTot")
    @ResponseBody
    public double prixTotal(@RequestParam(name="largeur",defaultValue = "14") int largeur,
                            @RequestParam(name="hauteur",defaultValue ="165") int hauteur)
    {
        return garageImp.somme(pneuRepository.findByLargeurAndHauteur(largeur,hauteur));
    }


}
