/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Random;
/**
 *
 * @author Otmane
 */
public class Monstre {

    // Definition des attributs
    private int ptVie;
    private int pourcentageAtt;
    private int pourcentagePar;
    private int degAtt;
    private Point2D pos;

    // Definition des constructeurs
    public Monstre(int pV, int pA, int pP, int dA, Point2D pos) {
        ptVie = pV;
        pourcentageAtt = pA;
        pourcentagePar = pP;
        degAtt = dA;
        this.pos = pos;
    }

    public Monstre(Monstre m) {
    }

    public Monstre() {
    }

    // Definition des methodes
    public void deplace() {
        Random rd = new Random();
        this.pos.setX(rd.nextInt(10));
        this.pos.setY(rd.nextInt(10));
    }

    public void affiche() {
        System.out.println("Le Monster se situe dans la position : ");
        pos.affiche();
    }

    // Definition des getters et setters : 
    public int getPtVie() {
        return ptVie;
    }

    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    public int getPourcentagePar() {
        return pourcentagePar;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    public void setPourcentagePar(int pourcentagePar) {
        this.pourcentagePar = pourcentagePar;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

}
