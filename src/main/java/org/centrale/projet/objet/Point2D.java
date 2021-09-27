/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 * Classe point2D
 *
 * @author Groupe 24
 */
public class Point2D {

    // attributs
    /**
     * position x
     */
    private int x;
    /**
     * position y 
     */
    private int y;

    // méthodes et constructeurs :
    /**
     * Constructeur avec deux parametres
     *
     * @param i un entier pour determiner la position x
     * @param j un entier pour determiner la position y
     */
    public Point2D(int i, int j) {
        x = i;
        y = j;
    }

    /**
     * Constructeur de recopie
     *
     * @param p objet Point2D
     */
    public Point2D(Point2D p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Affiche la position du point
     */
    public void affiche() {
        System.out.println("[" + x + "," + y + "]");
    }

    /**
     * Cette méthode calcule la distance euclidienne entre deux points
     *
     * @param p1
     * @param p2
     * @return
     */
    static double distance(Point2D p1, Point2D p2) {
        double distance = Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
        return distance;
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

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void setPosition(int newX, int newY) {
        x = newX;
        y = newY;
    }

}
