/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe Nourriture : represente les bonus/malus d'une caracteristique que les objets de type Personnage peuvent ramasser sur le plateau de jeu
 * @author Groupe 24
 */
public class Nourriture extends Objet{
    // Definition des attributs
    /**
     * carac = 0 (pourcentageMag) ou 1 (pourcentageResistMag) ou 2 (distAttMax) ou 3 (distAttMag)
     */
    private int carac;
    /**
     * val : valeur de la nourriture
     */
    private int val;
    /**
     * nbTour : la duree de l'effet; 
     */
    private int nbTour;
    /**
     * posNourriture : position de la nourriture dans le monde
     */
    private Point2D posNourriture;

    // Definition des constructeurs
    /**
     * Constructeur par defaut
     */
    public Nourriture(){
        Random nbAlea = new Random();
        // initialisation de carac :
        carac = nbAlea.nextInt(4);
        // initialisation de val :
        int effet = nbAlea.nextInt(2); // choix entre bonus ou malus aleatoirement
        switch(effet){
            case 0 : 
                val = nbAlea.nextInt(10)+1;
                break;
            
            case 1 : 
                val = -nbAlea.nextInt(10)-1;
                break;
        }
        // initialistion de nbTour :
        nbTour = nbAlea.nextInt(5)+1;
        // initialistion de posNourriture :
        posNourriture = new Point2D();   
    }
    /**
     * Constructeur a 4 parametres
     * @param carac : carac = 0 (pourcentageMag) ou 1 (pourcentageResistMag) ou 2 (distAttMax) ou 3 (distAttMag)
     * @param val : valeur de la nourriture
     * @param nbTour : la duree de l'effet;
     * @param posNourriture : position de la nourriture dans le monde
     */
    public Nourriture(int carac, int val, int nbTour, Point2D posNourriture){
        this.carac = carac;
        this.val = val;
        this.nbTour = nbTour;
        this.posNourriture = new Point2D(posNourriture);
    }
    /**
     * Constructeur de recopie
     * @param n : objet de type Nourriture
     */
    public Nourriture(Nourriture n){
        this.carac = n.carac;
        this.val = n.val;
        this.nbTour = n.nbTour;
        this.posNourriture = n.posNourriture;
    }
    // Definiton des methodes
    
    // DEfiniton des getters et setters

    public int getCarac() {
        return carac;
    }

    public int getVal() {
        return val;
    }

    public int getNbTour() {
        return nbTour;
    }

    public Point2D getPosNourriture() {
        return posNourriture;
    }

    public void setCarac(int carac) {
        this.carac = carac;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    public void setPosNourriture(Point2D posNourriture) {
        this.posNourriture = posNourriture;
    }
   
}
