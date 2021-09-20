/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * classe Payson : sous-classe de Personnage
 * @author Groupe 24
 */

public class Paysan extends Personnage{
    // Definition des Constructeurs :
    /**
     * Constructeur d'un personnage Paysan
     * 
     * @param nom
     * @param pV
     * @param pA
     * @param pP
     * @param pM
     * @param rM
     * @param dA
     * @param dM
     * @param distMax
     * @param pos 
     */
    public Paysan(String nom, int pV, int pA, int pP, int pM, int rM, int dA, 
            int dM, int distMax, Point2D pos){
        super( nom, pV, 0, pA,  pP,  pM,  rM,  dA, dM,  distMax, pos);
    }
    
    /** 
     * Constructeur de recopie
     * 
     * @param p 
     */
    public Paysan(Paysan p){
        super(p);
    }
    
    /**
     * Constructeur par défaut
     * 
     */
    
    public Paysan(){
        super();
    }
}
