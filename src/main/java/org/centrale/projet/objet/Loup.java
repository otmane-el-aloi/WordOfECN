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
public class Loup extends Monstre implements Combattant {
    // Definition des constructeurs
        /**
     * Construteur avec plusieurs parametres d'un Loup
     * @param pV : Ponits de Vie
     * @param pA : pourcentage attaque
     * @param pP : pourcentage par
     * @param dA : degats d'attaque
     * @param pos : position du lapin dans le monde
     * @param ptPar :  points de paries
     */
    public Loup(int pV, int pA, int pP, int dA, Point2D pos, int ptPar) {
        super(pV, pA, pP,dA, pos, ptPar);
    }
    /**
     * Constructeur de recopie
     * @param l : Objet loup
     */
    public Loup(Loup l) {
        super(l);
    }
    /**
     * Constructeur par defaut
     */
    public Loup() {
        super(); 
    }

    // Definition des méthodes
    
    /**
     * Méthode affiche qui permet l'affichage d'un Monstre
     */
    @Override
    public void affiche() {
        System.out.println("Je suis un Loup!");
    }
    
  /**
   * Combat corps à corps
   * 
   * @param c 
   */
    @Override
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
        c.setPtVie(Math.max(c.getPtVie() - damage, 0));
        System.out.println("Attaque réussi avec un dégat de: " + Math.max(c.getPtVie() - damage, 0) );
      } else {
        System.out.println("attaque ratée!");
      }
    } else {
      System.out.println(" Trop loin! Distance: " + distance);
    }
  }
    
}
