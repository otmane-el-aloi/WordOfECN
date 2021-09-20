/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Otmane
 */
public class Archer extends Personnage {
    // Definition des attributs :
    private int nbFleches;
    
    // Definition des constructeurs
    public Archer(String nom, int pV, int pA, int pP, int pM, int rM, int dA,
            int dM, int distMax, Point2D pos, int nbF) {
        super(nom, pV, 0, pA, pP, pM, rM, dA, dM, distMax, pos);
        this.nbFleches = nbF;
    }

    public Archer(Archer a) {
        super(a);
        this.nbFleches = a.nbFleches;

    }

    public Archer() {
        super();
    }
    // Definiton des methodes 
    public void affiche(){
        System.out.println("L'Archer se situe dans la position : ");
        Point2D p = this.getPos();
        p.affiche();
    }
    
    // Definition des getters et des setters
    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

}
