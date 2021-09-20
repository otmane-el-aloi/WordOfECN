/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Random;
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
    private int ptPar;
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
        super(pV, pA, dA, pos);
        this.ptPar = ptPar;
    }
    /**
     * Constructeur avec un parametre
     * @param m : Objet monstre
     */
    public Monstre(Monstre m) {
        super(m);
        this.ptPar = m.ptPar;
    }
    /**
     * Constructeur par defaut
     */
    public Monstre() {
        super(); 
        this.ptPar = 0;
    }

    // Definition des méthodes
    
    /**
     * Méthode affiche qui permet l'affichage d'un Monstre
     */
    public void affiche() {
        System.out.println("Le Monstre se situe dans la position : ");
        this.getPos().affiche();
    }
    
    // DEfinition des getters et setters

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    } 
}
