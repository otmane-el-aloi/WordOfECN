/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Groupe 24
 */
public class Mage extends Personnage {
    // Definition des constructeurs
    
    /**
     * Constructeur avec plusieurs parametres
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
    
    public Mage(String nom, int ptV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
        super(nom, ptV, 0, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
    }
    
     /**
     * Constructeur de recopie d'Archer à partir d'un objet Archer
     * @param m objet Mage
     */
    public Mage(Mage m) {
        super(m);

    }
    /**
     * Constructeur par defaut
     */
    public Mage() {
        super();
    }
    
    // Definiton des methodes 
    /**
     * 
     * @param c de type Creature
     */
    public void combattre(Creature c){
        
    }

}
