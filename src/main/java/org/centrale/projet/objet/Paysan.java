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
    // Definition des constructeurs
    
    /**
     * Constructeur avec plusieurs parametres d'Archer
     * @param nom Nom de l'Archer
     * @param ptV points vie
     * @param pA pourcentage attaque
     * @param pP pourcentage par?
     * @param pM pourcentage magie
     * @param rM pourcentage resistance magie
     * @param dA degats d'attaque
     * @param dM degats magie
     * @param distMax distance d'attaque maximal
     * @param pos position du personnage dans le monde
     * @param ptPar points de paries
     */
    
    public Paysan(String nom, int ptV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
        super(nom, ptV, 0, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
    }
    
     /**
     * Constructeur de recopie d'Archer à partir d'un objet Archer
     *
     * @param p objet Paysan
     */
    public Paysan(Paysan p) {
        super(p);

    }
    /**
     * Constructeur par defaut
     */
    public Paysan() {
        super();
    }

}
