package com.oraiche.pneus.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private double prix;
    private String madeIn;

    public Pneu(int largeur,int hauteur,int diametre,String marque,double prix)
    {
        this.largeur=largeur;
        this.hauteur=hauteur;
        this.diametre=diametre;
        this.marque=marque;
        this.prix=prix;
    }

}
