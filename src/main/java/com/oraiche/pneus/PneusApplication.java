package com.oraiche.pneus;

import com.oraiche.pneus.entities.Pneu;
import com.oraiche.pneus.repositories.PneuRepository;
import com.oraiche.pneus.services.GarageImp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PneusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PneusApplication.class, args);
    }
    @Bean
    CommandLineRunner star(GarageImp garageService,PneuRepository pneuRepository)
    {

        return args -> { pneuRepository.save(new Pneu(14,175,70,"Lassa",600));
                         pneuRepository.save(new Pneu(15,185,65,"StarMax",540));
                         pneuRepository.save(new Pneu(15,165,70,"Amine",700));
                         pneuRepository.save(new Pneu(14,175,70,"Lassa",550));
                         pneuRepository.save(new Pneu(15,185,65,"StarMax",470));
                         pneuRepository.save(new Pneu(13,165,70,"Amine",860));
                         pneuRepository.save(new Pneu(14,175,70,"Lassa",720));
                         pneuRepository.save(new Pneu(15,185,65,"StarMax",370));
                         pneuRepository.save(new Pneu(16,165,60,"Lassa",890));
                         pneuRepository.save(new Pneu(14,175,70,"Lassa",790));
                         pneuRepository.save(new Pneu(15,185,65,"Lassa",470));
                         pneuRepository.save(new Pneu(15,165,70,"Amine",300));
                         pneuRepository.save(new Pneu(14,175,70,"Lassa",600));
                         pneuRepository.save(new Pneu(15,185,65,"StarMax",540));
                         pneuRepository.save(new Pneu(15,165,70,"Amine",700));
                         pneuRepository.save(new Pneu(14,175,70,"Lassa",550));
                         pneuRepository.save(new Pneu(15,185,65,"StarMax",470));
                         pneuRepository.save(new Pneu(13,165,70,"Amine",860));
                         pneuRepository.save(new Pneu(14,175,70,"StarMax",720));
                         pneuRepository.save(new Pneu(15,185,65,"StarMax",370));
                         pneuRepository.save(new Pneu(16,165,60,"Lassa",890));
                         pneuRepository.save(new Pneu(14,175,70,"Amine'",790));
                         pneuRepository.save(new Pneu(15,185,65,"Lassa",470));
                         pneuRepository.save(new Pneu(15,165,70,"Amine",300));

                         System.out.println(garageService.compteByMarque("Lassa"));
                         System.out.println(garageService.compteByLargeur(15));

                        System.out.println("nolmbre de pneux by largeur");
                        System.out.println(garageService.prix(15));




        };

    }

}
