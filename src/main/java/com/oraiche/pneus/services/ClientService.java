package com.oraiche.pneus.services;

import com.oraiche.pneus.entities.Client;
import com.oraiche.pneus.entities.Vente;
import com.oraiche.pneus.repositories.PersonneRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class ClientService implements ClientInterface{
 PersonneRepo personneRepo;

    @Override
    public Client saveClient(Client client) {
        return personneRepo.save(client) ;
    }

}
