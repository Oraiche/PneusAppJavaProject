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
        return pneuRepository.save(pneu);
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

        return pneuRepository.findById(id).orElseThrow(PneuNotFoundException::new);
    }

    @Override
    public int compteByMarque(String marque) {

        return pneuRepository.findByMarque(marque).size();
    }

    @Override
    public int compteByLargeur( int largeur) {
        return pneuRepository.findByLargeur(largeur).size() ;
    }

    @Override
    public Map<String,Double> prix(int largeur) {

        Map<String, List<Double>> collect = pneuRepository.findByLargeur(largeur)
                .stream()
                .collect(Collectors.groupingBy(Pneu::getMarque, Collectors.mapping(r -> r.getPrixVente(), Collectors.toList())));

        return pneuRepository.findByLargeur(largeur)
                .stream()
                .collect(Collectors.toMap(Pneu::getMarque, Pneu::getPrixVente));
    }

    @Override
    public double somme(int largeur) {

        return pneuRepository.findByLargeur(largeur).stream().mapToDouble(Pneu::getPrixVente).reduce(0, Double::sum);


    }


}
