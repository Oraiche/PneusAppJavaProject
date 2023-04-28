package com.oraiche.pneus.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  @AllArgsConstructor @NoArgsConstructor
public class Pneu {
    @Id    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marque;
    private int largeur;
    private int  hauteur;
    private int diametre;
    private double prixVente;
    private double prixAchat;
    private String madeIn;
    private int stock;

    @JsonIgnore
    @ManyToOne
    private Vente vente;
    public Pneu(int largeur,int hauteur,int diametre,String marque,double prix)
    {
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.diametre=diametre;
        this.marque=marque;
        this.prixVente=prix;

    }
    public String taille()
    {
        return this.hauteur+"/"+this.diametre+"  "+"R"+this.largeur;
    }

}
