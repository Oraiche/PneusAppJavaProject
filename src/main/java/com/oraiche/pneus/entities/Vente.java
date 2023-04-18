package com.oraiche.pneus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Vente {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "vente",cascade = CascadeType.ALL)
    private List<Pneu> pneusVendus=new ArrayList<>();
    @OneToOne
    private Client clientConcerneParVente;
    private Date dateVente;
    private double prixTotalVente;

}
