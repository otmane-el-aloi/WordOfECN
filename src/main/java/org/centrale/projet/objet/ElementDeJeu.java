/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe ElementDeJeu abstraite
 * @author Groupe 24
 */
public abstract class ElementDeJeu {
    // Definition des attributs
    private Point2D pos;
    // Definition des constructeurs
    /**
     * Constructeur avec un parametre
     * @param pos : position de l'element de jeu
     */
    public ElementDeJeu(Point2D pos){
        this.pos = pos;
    }
    /**
     * Constructeur par defaut
     */
    public ElementDeJeu(){
        this.pos = new Point2D(0, 0);
    }
    /**
     * Constructeur de recopie
     * @param e : un objet de type ElementDeJeu
     */
    public ElementDeJeu(ElementDeJeu e){
        this.pos = e.getPos();
    }
    
    // Definition des getters et setters
    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
    
}
