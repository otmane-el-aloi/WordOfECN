/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * classe Lapin : sous-classe de Monstre
 * @author Groupe 24
 */
public class Lapin extends Monstre {
    
    // Constructeurs 
    /**
     * Constructeur Personnage
     *
     * @param pV points vie
     * @param pA pourcentage attaque
     * @param pP pourcentage par?
     * @param dA degats d'attaque
     * @param pos position du personnage dans le monde
     */
    public Lapin(int pV, int pA, int pP, int dA, Point2D pos) {
        super(pV, pA, pP, dA, pos);
    }
    /**
     * Constructeur de recopie
     * 
     * @param l object de type lapin
     */

    public Lapin(Lapin l) {
        super(l);
    }
    /**
     * Constructeur vide
     */
    public Lapin() {
        super();
    }

}
