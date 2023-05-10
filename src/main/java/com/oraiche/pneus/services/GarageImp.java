package com.oraiche.pneus.services;

import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.exceptions.PneuNotFoundException;
import com.oraiche.pneus.repositories.PneuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class GarageImp implements Garage{
    @Autowired
    private PneuRepository pneuRepository;


    @Override
    public Pneu savePneu(Pneu pneu) {
        pneuRepository.save(pneu);
        return pneu;

    }

    @Override
    public int totalNumbPneus() {
        return pneuRepository.findAll().size();
    }

    @Override
    public double prixPneu(int largeur, int hauteur, String marque) throws PneuNotFoundException {
         Pneu p=pneuRepository.findFirstByLargeurAndHauteurAndMarque(largeur,hauteur,marque);
         if(p==null) throw  new PneuNotFoundException("pneu not Found");
         else
        return p.getPrixVente();
    }
    public double prixPneu(int largeur, int hauteur) throws PneuNotFoundException {
        Pneu p=pneuRepository.findFirstByLargeurAndHauteur(largeur,hauteur);
        if(p==null) throw  new PneuNotFoundException("pneu not Found");
        else
            return p.getPrixVente();
    }

    @Override
    public int compterPneusByMarqueAndLargeur(String marque, int largeur) {
        return pneuRepository.findByMarqueAndLargeur(marque,largeur).size();
    }

    @Override
    public int compterPneusBylargeurAndHauteur(int largeur, int hauteur) {
        return pneuRepository.findByLargeurAndHauteur(largeur,hauteur).size();
    }

    @Override
    public Pneu addPneu(Pneu pneu) {
        Pneu savedPneu = pneuRepository.save(pneu);
        return savedPneu;
    }

    @Override
    public List<Pneu> findPneusByMarque(String marque) {
        return pneuRepository.findByMarque(marque);
    }

    @Override
    public List<Pneu> findAllPneu() {
        return pneuRepository.findAll();
    }

    @Override
    public Pneu findPneuById(Long id) {

        return pneuRepository.findById(id).get();
    }

    @Override
    public int compteByMarque(String marque) {
        int nomber =pneuRepository.findByMarque(marque).size();
        return nomber;
    }

    @Override
    public int compteByLargeur( int largeur) {
        return pneuRepository.findByLargeur(largeur).size() ;
    }

    @Override
    public Map<String,Double> prix(int largeur) {
        Map<String,Double> prixMarque=new HashMap<String,Double>();
        List<Pneu> listP=pneuRepository.findByLargeur(largeur);
        for(Pneu p:listP) {
            prixMarque.put(p.getMarque(),p.getPrixVente());
        }
        return prixMarque ;
    }

    @Override
    public double somme(int largeur) {
        double s=0;
        List<Double> listPrix=pneuRepository.findByLargeur(largeur).stream().map(p->p.getPrixVente()).collect(Collectors.toList());
        for (double prix:listPrix) {
            s=s+prix;
        }

        return s;
    }


}
