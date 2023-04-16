package com.oraiche.pneus;

import com.oraiche.pneus.Enums.TypePayement;
import com.oraiche.pneus.entities.Client;
import com.oraiche.pneus.entities.Personne;
import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.entities.Vente;
import com.oraiche.pneus.repositories.PersonneRepo;
import com.oraiche.pneus.repositories.PneuRepository;
import com.oraiche.pneus.repositories.VenteRepo;
import com.oraiche.pneus.services.GarageImp;
import org.apache.catalina.LifecycleState;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class PneusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PneusApplication.class, args);
    }
    @Bean
    CommandLineRunner star(GarageImp garageService, PneuRepository pneuRepository, PersonneRepo personneRepo, VenteRepo venteRepo)
    {

        return args -> { garageService.savePneu(new Pneu(14,175,70,"Lassa",600));
                         garageService.savePneu(new Pneu(15,185,65,"StarMax",540));
                         garageService.savePneu(new Pneu(15,165,70,"Amine",700));
                         garageService.savePneu(new Pneu(14,175,70,"Lassa",550));
                         garageService.savePneu(new Pneu(15,185,65,"StarMax",470));
                         garageService.savePneu(new Pneu(13,165,70,"Amine",860)); garageService.savePneu(new Pneu(14,175,70,"Lassa",720));
                         garageService.savePneu(new Pneu(15,185,65,"StarMax",370));
                         garageService.savePneu(new Pneu(16,165,60,"Lassa",890));
                         garageService.savePneu(new Pneu(14,175,70,"Lassa",790));
                         garageService.savePneu(new Pneu(15,185,65,"Lassa",470));
                         garageService.savePneu(new Pneu(15,165,70,"Amine",300));
                         garageService.savePneu(new Pneu(14,175,70,"Lassa",600));
                         garageService.savePneu(new Pneu(15,185,65,"StarMax",540));
                         garageService.savePneu(new Pneu(15,165,70,"Amine",700));
                         garageService.savePneu(new Pneu(14,175,70,"Lassa",550));
                         garageService.savePneu(new Pneu(15,185,65,"StarMax",470));
                         garageService.savePneu(new Pneu(13,165,70,"Amine",860));
                         garageService.savePneu(new Pneu(14,175,70,"StarMax",720));
                         garageService.savePneu(new Pneu(15,185,65,"StarMax",370));
                         garageService.savePneu(new Pneu(16,165,60,"Lassa",890));
                         garageService.savePneu(new Pneu(14,175,70,"Amine'",790));
                         garageService.savePneu(new Pneu(15,185,65,"Lassa",470));
                         garageService.savePneu(new Pneu(15,165,70,"Amine",300));

            List<Pneu> listPneu= new ArrayList<>();
            listPneu.add(new Pneu(15,185,65,"StarMax",540));
            listPneu.add(new Pneu(14,175,70,"Amine'",790));

            Client client1=new Client();
            client1.setNom("Mohamemd");
            client1.setPrenom("Oraiche");
            client1.setAddress("23 ANOUAR SIDI BENNOUR");
            client1.setTelephone("0659637198");
            client1.setTypePayement(TypePayement.ESPECE);
            personneRepo.save(client1);



            Vente vente1=new Vente();
            vente1.setDateVente(new Date());
            vente1.setPneusVendus(listPneu);
            vente1.setClientConcerneParVente(client1);
            vente1.setPrixTotalVente(45500);


            venteRepo.save(vente1);


            System.out.println(garageService.findPneuById(1L).taille());
            Pneu pneu=garageService.findPneuById(1L);
           pneu.setStock(15);
            System.out.println(pneu);
            System.out.println(pneu.getStock());
            System.out.println(pneu.getPrixVente());
            System.out.println(pneu.getPrixAchat());

            System.out.println(garageService.prixPneu(14,175,"Lassa"));


        };

    }

}
