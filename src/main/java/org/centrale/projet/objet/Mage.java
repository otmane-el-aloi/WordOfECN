/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe Mage
 * @author Groupe 24
 */
public class Mage extends Personnage implements Combattant {
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
    
    public Mage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar, ArrayList<Nourriture> listNourriture) {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar, listNourriture);
    }
    
     /**
     * Constructeur de recopie d'Mage à partir d'un objet Mage
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
     * Affiche le nom de Mage
     */
    public void affiche(){
        System.out.println("Je suis un " + this.getNom());
    }
 
  /**
   * Combat magique
   * @param c : objet de type Creature
   */
    @Override
  public void combattre(Creature c) {
    double distance = Point2D.distance(this.getPos(),c.getPos());
    if (this.getPtMana() == 0) {
      System.out.println("Plus de Mana!");
      return;
    }
    if (distance >= 1 && distance < this.getDistAttMax()) {
      Random rInt = new Random();
      this.setPtMana(this.getPtMana() - 1);
      if (rInt.nextInt(100) + 1 <= this.getPourcentageAtt()) {
        int damage = this.getDegMag();
        c.setPtVie(Math.max(c.getPtVie() - damage, 0));
        System.out.println("Attaque réussi avec dégat:" + Math.max(c.getPtVie() - damage, 0) );
      } else {
        System.out.println("attaque ratée!");
      }
    } else {
      System.out.println("Trop loin! Distance: " + distance);
    }
  }

}
