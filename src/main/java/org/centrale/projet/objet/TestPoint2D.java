/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Otmane, Oussama
 */
public class TestPoint2D {

    public static void main(String[] args) {
        Point2D p1 = new Point2D();
        Point2D p2 = new Point2D(5, 10);
        Point2D p3 = new Point2D(p1);

        p1.setX(2);
        p1.setY(6);

        int x = p1.getX();
        int y = p1.getY();
        System.out.println("Les coordonnées de p1 sont : [" + x + ";" + y + "]");

        System.out.println("Les coordonnées de p2 sont : ");
        p2.affiche();

        System.out.println("Après translation de (3, 4), les coordonnées de p2 sont  : ");
        p2.translate(3, 4);
        p2.affiche();
        System.out.println("Le résultat attendues sont :");
        System.out.println("[8, 14]");

        System.out.println("Nouvelles coordonnées de p2 ");
        p2.setPosition(6, 7);
        p2.affiche();
        System.out.println("Le résultat attendues sont :");
        System.out.println("[6, 7]");

    }
}
