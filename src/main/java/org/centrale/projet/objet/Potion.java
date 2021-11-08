/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Class Potion
 * @author Groupe 24
 */
public abstract class Potion extends Objet{
    // DEfinition des constructeur
    /**
     * Constructeur avec un parametre
     * @param pos : position de la Potion
     */
    public Potion(Point2D pos) {
        super(pos);
    }
    /**
     * Constructeur de recopie
     * @param p : Objet de type Potion
     */
    public Potion(Potion p) {
        super(p);
    }
    /**
     * constructeur par default
     */
    public Potion() {
        super();
    }
    // Definition des methodes
    /**
     * affiche le nom et la position de Potion
     */
    public void affiche(){
        System.out.println("Je suis Potion");
        this.getPos().affiche();
    }
}
