/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe Archer : sous-classe de Personnage
 * @author Groupe 24
 */
public class Archer extends Personnage {
    // Nombre de fleches
    private int nbFleches;
    
    // Constructeurs
    
    /**
     * Constructeur Archer
     * @param nom Nom de l'Archer
     * @param pV points vie
     * @param pA pourcentage attaque
     * @param pP pourcentage par?
     * @param pM pourcentage magie
     * @param rM pourcentage resistance magie
     * @param dA degats d'attaque
     * @param dM degats magie
     * @param distMax distance d'attaque maximal
     * @param pos position du personnage dans le monde
     * @param nbF nombre de fleshes
     */
    
    public Archer(String nom, int pV, int pA, int pP, int pM, int rM, int dA,
            int dM, int distMax, Point2D pos, int nbF) {
        super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, pos);
        this.nbFleches = nbF;
    }
    
     /**
     * Constructeur d'Archer à partir d'un objet Archer
     *
     * @param a objet Archer
     */
    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;

    }
    /**
     * afficher les coordonnes d'un Archer
     */
    public Archer() {
        super();
        this.nbFleches = 0;
    }
    
    // Definiton des methodes 
    public void affiche(){
        System.out.println("La position de "+this.getNom()+" est :");
        this.getPos().affiche();
    }
    
    // Definition des getters et des setters
    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

}
