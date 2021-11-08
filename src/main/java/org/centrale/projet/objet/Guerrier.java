/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Random;
/**
 * Classe Guerrier
 * @author Groupe 24
 */
public class Guerrier extends Personnage implements Combattant {
    
    // Definition des constructeurs
    /**
     * Constructeur Guerrier
     * 
     * @param nom : Nom du guerrier
     * @param ptV : Points de Vie
     * @param pA : Points d'attack
     * @param pP : pourcentage para
     * @param pM : pourcentage magie
     * @param rM : pourcentage resistance magie
     * @param dA : degats d'attaque
     * @param dM : degats magie
     * @param distMax : distance max
     * @param pos : position du guerrier
     * @param ptPar : points de paries
     */
    public Guerrier(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar, ArrayList<Nourriture> listNourriture) {
        super(nom, ptV, ptM, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar, listNourriture);
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
     * afficher le nom du Guerrier
     */
    @Override
    public void affiche(){
        System.out.println("Je suis un " + this.getNom());
        
    }
/**
   * Combat corps à corps
   * @param c Creature
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
