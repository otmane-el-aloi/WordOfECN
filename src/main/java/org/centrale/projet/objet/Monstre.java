/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe abstraite Monstre 
 * @author Groupe 24
 */
public abstract class Monstre extends Creature {

    // DEfinition des constructeurs
    
    /**
     * Construteur avec plusieurs parametres d'un Monstre
     * 
     * @param pV : Points de vie
     * @param pA : Pourcentage d'attaque
     * @param pP : Pourcentage de Par
     * @param dA : Degree D'attaque
     * @param pos : position du monstre
     * @param ptPar  : Point de parade
     */
    public Monstre(int pV, int pA, int pP, int dA, Point2D pos, int ptPar) {
        super(pV, pA, pP, dA, pos, ptPar);
    }
    /**
     * Constructeur de recopie
     * @param m : Objet monstre
     */
    public Monstre(Monstre m) {
        super(m);
    }
    /**
     * Constructeur par defaut
     */
    public Monstre() {
        super(); 
    }

    // Definition des méthodes
    /**
     * Méthode affiche qui permet l'affichage d'un Monstre
     */
    public abstract void affiche() ;
}
