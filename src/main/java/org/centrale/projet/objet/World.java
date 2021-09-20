/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 *
 * @author Otmane, Oussama
 */
public class World {

    // Définition des attributs
    Archer robin = new Archer();
    Paysan peon = new Paysan();
    Lapin bugs = new Lapin();

    // Définition des constructeurs
    public World() {
    }

    // Définition des méthodes
    /**
     * Permet de positionner robin, peon et bugs dans le monde d'une façon aleatoire
     */
    public void creeMondealea() {
        Random generateurRandom = new Random();
        
        // initialisation des positions : notre monde a les limites suivantes : [0, 100]
        // position du robin
        int max_pos = 100 - 5 ;
        int min_pos =  5;
        Point2D pR = new Point2D(generateurRandom.nextInt(max_pos-min_pos +1) + min_pos, generateurRandom.nextInt(max_pos - min_pos + 1) + min_pos);
        robin.setPos(pR);
        int x  = robin.getPos().getX();
        int y = robin.getPos().getY();
        
        // position du peon
        Point2D pP = new Point2D(x - generateurRandom.nextInt(5),  y + generateurRandom.nextInt(5));
        while(pP.getX() == x && pP.getY() == y) { 
             pP.setX(x - generateurRandom.nextInt(5));
             pP.setY(y + generateurRandom.nextInt(5));
        }
        peon.setPos(pP);

        // position du bugs 
        Point2D pB = new Point2D(x + generateurRandom.nextInt(5), y - generateurRandom.nextInt(5));
        while(pB.getX() == x && pB.getY() == y) { 
             pB.setX(x + generateurRandom.nextInt(5));
             pB.setY(y - generateurRandom.nextInt(5));}
        bugs.setPos(pB);
    }
}


