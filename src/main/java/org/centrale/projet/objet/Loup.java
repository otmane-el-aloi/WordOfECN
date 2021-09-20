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
public class Loup extends Monstre {
    // Definition des constructeurs
        /**
     * Construteur avec plusieurs parametres d'un Loup
     * @param pV
     * @param pA
     * @param pP
     * @param dA
     * @param pos 
     * @param ptPar 
     */
    public Loup(int pV, int pA, int pP, int dA, Point2D pos, int ptPar) {
        super(pV, pA, pP,dA, pos, ptPar);
    }
    /**
     * Constructeur avec un parametre
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
    public void affiche() {
        System.out.println("Le loup se situe dans la position : ");
        this.getPos().affiche();
    }
    
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
        int damage;
        if (rInt.nextInt(100) + 1 > this.getPourcentagePar()){
        damage = this.getDegAtt();
        }
        else{
            damage = Math.max(this.getDegAtt()-c.getPtPar(), 0);
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
