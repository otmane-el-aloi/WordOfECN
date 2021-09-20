/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;
/**
 *
 * @author Groupe 24
 */
public class Guerrier extends Personnage {
    
    // Definition des constructeurs 
    
    private int ptPar;
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
    
    public Guerrier(String nom, int ptV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
        super(nom, ptV, 0, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
        
    }
    
     /**
     * Constructeur de recopie d'Archer à partir d'un objet Archer
     * @param g objet Guerrier
     */
    public Guerrier(Guerrier g) {
        super(g);

    }
    /**
     * Constructeur par defaut
     */
    public Guerrier() {
        super();
    }
    
    // Definiton des methodes 
/**
   * Combat contact
   *
   * @param c Creature
   */
  public void combattre(Creature c) {
    double distance = Point2D.distance(this.getPos(),c.getPos());
    if (distance == 1) {
      Random rInt = new Random();
      if (rInt.nextInt(100) + 1 <= this.getPourcentageAtt()) {
        int damage = 0;
        if (rInt.nextInt(100) + 1 > this.getPourcentagePar()){
        damage = this.getDegAtt();
        }
        else{
            Math.max(this.getDegAtt()-c.getPtPar(), 0);
        }
        c.setPtVie(c.getPtVie() - damage);
        System.out.println("Attaque réussi avec un dégat de: " + damage );
      } else {
        System.out.println("attaque ratée!");
      }
    } else {
      System.out.println(" Trop loin! Distance: " + distance);
    }
  }

}
