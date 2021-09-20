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
    // Definition des constructeurs
        /**
     * Construteur avec plusieurs parametres d'un Lapin
     * 
     * @param pV
     * @param pA
     * @param pP
     * @param dA
     * @param pos 
     * @param ptPar 
     */
    public Lapin(int pV, int pA, int pP, int dA, Point2D pos, int ptPar) {
        super(pV, pA, pP,dA, pos, ptPar);
    }
    /**
     * Constructeur avec un parametre
     * @param l : Objet loup
     */
    public Lapin(Lapin l) {
        super(l);
    }
    /**
     * Constructeur par defaut
     */
    public Lapin() {
        super(); 
    }

    // Definition des méthodes
    
    /**
     * Méthode affiche qui permet l'affichage d'un Monstre
     */
    public void affiche() {
        System.out.println("Le lapin se situe dans la position : ");
        this.getPos().affiche();
    }
}
