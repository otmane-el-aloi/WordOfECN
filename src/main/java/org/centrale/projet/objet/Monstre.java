/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe Monstre 
 * @author Groupe 24
 */
public class Monstre extends Creature {

    // Definition des attributs
    // Points de vie
    //private int ptVie;
    // Pourcentage d'attaque
    //private int pourcentageAtt;
    // Pourcentage de Par
    //private int pourcentagePar;
    // Degree D'attaque
    //private int degAtt;
    // Position
    //private Point2D pos;
    //??
    // DEfinition des constructeurs
    
    /**
     * Construteur avec plusieurs parametres d'un Monstre
     * 
     * @param pV
     * @param pA
     * @param pP
     * @param dA
     * @param pos 
     * @param ptPar 
     */
    public Monstre(int pV, int pA, int pP, int dA, Point2D pos, int ptPar) {
        super(pV, pA, pP, dA, pos, ptPar);
    }
    /**
     * Constructeur avec un parametre
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
    public void affiche() {
        System.out.println("ma position est: ");
        this.getPos().affiche();
    }
}
