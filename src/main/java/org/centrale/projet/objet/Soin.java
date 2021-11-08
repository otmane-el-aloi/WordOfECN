/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Class Soin
 * @author Groupe 24
 */
public class Soin extends Potion{
    /**
     * c'est le nombre de points de vie que faire gagner un soin
     */
    private int valPtVie;
    // Definition des constructeurs
    /**
     * Constructeur avec deux parametres
     * @param pos : position du Soin
     * @param valPtVie : nombre de points de vie que faire gagner un soin
     */
    public Soin(Point2D pos, int valPtVie) {
        super(pos);
        this.valPtVie = valPtVie;
    }
    /**
     * Constructeur de recopie
     * @param s : objet de type Soin
     */
    public Soin(Soin s) {
        super(s);
        this.valPtVie = s.valPtVie;
    }
    /**
     * Constructeur par defaut
     */
    public Soin() {
        super();
        this.valPtVie = 10;
    }
    // Definition des methodes
    /**
     * affiche le nom et la posiiton de Soin
     */
    public void affiche(){
        System.out.println("Je suis Soin");
        this.getPos().affiche();
    }
    // Definition des getters et setters

    public int getValPtVie() {
        return valPtVie;
    }

    public void setValPtVie(int valPtVie) {
        this.valPtVie = valPtVie;
    }
    
    
}
