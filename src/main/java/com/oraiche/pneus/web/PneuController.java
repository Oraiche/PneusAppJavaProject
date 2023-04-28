package com.oraiche.pneus.web;

import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.repositories.PneuRepository;
import com.oraiche.pneus.services.GarageImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/garage")
public class PneuController {
    @Autowired
   private PneuRepository pneuRepository;
    @Autowired
    private GarageImp garageImp;


    @GetMapping("/pneusByMarque/{marque}")
    List<Pneu> findPneusByMarque(@PathVariable String marque)
    {
        return garageImp.findPneusByMarque(marque);
    }
    @GetMapping(value = "/stock")
    List<Pneu> getAllPneu()
   {
    return garageImp.findAllPneu();
    }

    @GetMapping("/pneu")

    public List<Pneu> pneu(@RequestParam(name="marque",defaultValue = "Lassa") String marque,
                           @RequestParam(name="largeur",defaultValue = "14") int largeur )
    {

         return  pneuRepository.findByMarqueAndLargeur(marque,largeur);
    }

    @GetMapping("/compter/marqueAndLargeur")
    @ResponseBody
    public int comptePneusByMarqueAndLargeur(@RequestParam(name="marque",defaultValue = "Lassa") String marque,
                           @RequestParam(name="largeur",defaultValue = "14") int largeur )
    {

        return  garageImp.compterPneusByMarqueAndLargeur(marque,largeur);
    }
    @GetMapping("/compter/largeur")
    @ResponseBody
    public int comptePneusByLargeur(@RequestParam(name="largeur",defaultValue = "14") int largeur )
    {

        return  garageImp.compteByLargeur(largeur);
    }

    @GetMapping("/prixPneus")
    @ResponseBody
    public Map<String, List<Double>> prixPneus(@RequestParam(name="largeur",defaultValue = "14") int largeur)
    {
        return garageImp.prix(largeur);
    }
    @GetMapping("/totalNumberPneus")
    @ResponseBody
    public int totalNumbPneus()
    {
        return garageImp.totalNumbPneus();
    }
    @GetMapping("/prixPneu")
    @ResponseBody
    public double prixPneu(@RequestParam(name = "largeur",defaultValue = "14") int largeur,
                           @RequestParam(name = "hauteur",defaultValue = "175") int hauteur,
                           @RequestParam(name = "marque",defaultValue = "Lassa") String marque)
    {
        return garageImp.prixPneu(largeur,hauteur,marque);
    }
    @GetMapping("/prixPneuByLarAndHaut")
    @ResponseBody
    public double prixPneu(@RequestParam(name = "largeur",defaultValue = "14") int largeur,
                           @RequestParam(name = "hauteur",defaultValue = "175") int hauteur)

    {
        return garageImp.prixPneu(largeur,hauteur);
    }
    @GetMapping("/prixTotByLargeur")
    @ResponseBody
    public double prixTotal(@RequestParam(name="largeur",defaultValue = "14") int largeur)

    {
        return garageImp.somme(largeur);
    }
@PostMapping("/addPneu")
    public Pneu addPneu(@RequestBody Pneu pneu)
{
    return garageImp.addPneu(pneu);
}
    @GetMapping("/Pneu/{pneuId}")
    public Pneu getPneuById(@PathVariable(name = "pneuId") Long id)
    {
        return garageImp.findPneuById(id);
    }
}
