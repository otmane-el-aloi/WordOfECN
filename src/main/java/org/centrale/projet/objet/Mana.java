/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Class Mana
 * @author Groupe 24
 */
public class Mana extends Potion {
    // DEfinition des attributs
    private int valMana;
    // Definition des constructreurs:
    /**
     * Constructeur a deux parametres
     * @param pos : position du Mana
     * @param valMana : c'est les points de mana qu'on gagne qu'on trouve un Mana
     */
    public Mana(Point2D pos, int valMana) {
        super(pos);
        this.valMana = valMana;
    }
    /**
     * Constructeur de recopie
     * @param m : objet de type Mana
     */
    public Mana(Mana m) {
        super(m);
        this.valMana = m.valMana;
    }
    /**
     * Constructeur par default
     */
    public Mana() {
        super();
        this.valMana = 10;
    }
    // Definition des methodes
    /**
     * affiche le nom et la position du Mana
     */
    public void affiche(){
        System.out.println("Je suis Mana");
        this.getPos().affiche();
    }
    // Definition des getters et setters
    public int getValMana() {
        return valMana;
    }

    public void setValMana(int valMana) {
        this.valMana = valMana;
    }
    
    
}
