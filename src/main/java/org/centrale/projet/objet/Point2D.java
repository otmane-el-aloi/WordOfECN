/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe point2D
 * @author Groupe 24
 */
public class Point2D {

    // attributs
    // position x
    private int x;
    // position y
    private int y;

    // méthodes et constructeurs :
    /**
     * Constructeur avec deux parametres
     * @param i un entier pour determiner la position x
     * @param j un entier pour determiner la position y
     */
    public Point2D(int i, int j) {
        x = i;
        y = j;
    }
    /**
     * Constructeur de recopie
     * @param p objet Point2D
     */
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }
    
    // Definition des getters et setters
    public void setX(int valX) {
        x = valX;
    }

    public void setY(int valY) {
        y = valY;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point2D() {
    }



    public void affiche() {
        System.out.println("[" + x + "," + y + "]");
    }

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }

}
