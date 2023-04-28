package com.oraiche.pneus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.oraiche.pneus.Enums.TypePayement;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Builder
@AllArgsConstructor @NoArgsConstructor
@Entity
@DiscriminatorValue("Client")
public class Client extends Personne{
      @JsonIgnore
      @OneToOne(mappedBy = "clientConcerneParVente")
      private Vente vente;

      @Enumerated(EnumType.STRING)
      private TypePayement typePayement;

}
