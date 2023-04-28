package com.oraiche.pneus.services;

import com.oraiche.pneus.Enums.TypePayement;
import com.oraiche.pneus.entities.Client;
import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.entities.Vente;
import com.oraiche.pneus.exceptions.VenteNotExist;
import com.oraiche.pneus.repositories.PersonneRepo;
import com.oraiche.pneus.repositories.VenteRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class VenteService implements VenteInterface {
    public VenteRepo venteRepo;
    public GarageImp garageService;
    public PersonneRepo personneRepo;
    ClientService clientService;


  public Vente  saveVente(Vente vente)
  {
      venteRepo.save(vente);
      return vente;
  }
    public Vente getVente(Long id)
    {

        return venteRepo.findById(id).orElse(null);
    }


    @Override
    public List<Pneu> pneusVendue(Long id)
    {
        Vente vente=venteRepo.findById(id).orElse(null);
        if (vente==null)throw new VenteNotExist("Vente not Exist");
        else return vente.getPneusVendus();

    }







    @Override
    public List<Vente> getVentes() {
        return venteRepo.findAll();
    }

    public void setPneuToVente(Vente vente,List<Pneu> pneuList)
    {
        vente.setPneusVendus(pneuList);
    }
    @Override
    public void setPneusToVent(String marque) {
        {
            List<Pneu> listPneu = new ArrayList<>();
            listPneu = garageService.findPneusByMarque(marque);

            Client client1 = new Client();
            client1.setNom("Mohamemd");
            client1.setPrenom("Oraiche");
            client1.setAddress("23 ANOUAR SIDI BENNOUR");
            client1.setTelephone("0659637198");
            client1.setTypePayement(TypePayement.ESPECE);
            clientService.saveClient(client1);
            Vente vente1 = new Vente();
            vente1.setDateVente(new Date());
            vente1.setPneusVendus(listPneu);
            vente1.setClientConcerneParVente(client1);
            vente1.setPrixTotalVente(45500);

            venteRepo.save(vente1);
        }
    }

}
