/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Random;
/**
 * Class Objet
 * @author Groupe 24
 */

public abstract class Objet extends ElementDeJeu{
    // Definition des constructeurs
    /**
     * Constructeur avec un parametre
     * @param pos : Position de l'Objet
     */
    public Objet(Point2D pos) {
        super(pos);
    }
    /**
     * Constructeur de recopie
     * @param o : objet de type Objet
     */
    public Objet(Objet o){
        super(o);
    }
    /**
     * Constructeur par defaut
     */
    public Objet(){
        Random generateurAleatoire = new Random();
        this.setPos(new Point2D(generateurAleatoire.nextInt(100),generateurAleatoire.nextInt(100)));
    }
    // Definition des getters et setters

    
    
}
