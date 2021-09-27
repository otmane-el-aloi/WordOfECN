/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Random;

/**
 * classe Creature
 * @author Groupe 24
 */
public class Creature {
    // Definition des attributs
    // Points de vie
    private int ptVie;
    // Pourcentage d'attaque
    private int pourcentageAtt;
    // Pourcentage de parage
    private int pourcentagePar;
    // Degree D'attaque
    private int degAtt;
    // Position
    private Point2D pos;
    //point de para
    private int ptPar;
    
    /**
     * Constructeur de la classe Creature
     * 
     * @param pV
     * @param pA
     * @param pP
     * @param dA
     * @param pos
     * @param ptPar 
     */
    public Creature(int pV, int pA, int pP, int dA, Point2D pos, int ptPar) {
        this.ptVie = pV;
        this.pourcentageAtt = pA;
        this.pourcentagePar = pP;
        this.degAtt = dA;
        this.pos = pos;
        this.ptPar = ptPar;
    }
    /**
     * Constructeur avec un parametre
     * @param c : Objet Creature
     */
    public Creature(Creature c) {
        this.ptVie = c.ptVie;
        this.pourcentageAtt = c.pourcentageAtt;
        this.pourcentagePar = c.pourcentagePar;
        this.degAtt = c.degAtt;
        this.pos = new Point2D(c.pos);
        this.ptPar = c.ptPar;
    }
    /**
     * Constructeur par defaut
     */
    public Creature() {
        this.ptVie = 0;
        this.pourcentageAtt = 0;
        this.pourcentagePar = 0;
        this.degAtt = 0;
        this.pos = new Point2D(0, 0);    
        this.ptPar = 0;
    }
    
    // Definition des méthodes
    /**
     * Méthode deplace permet le déplacement d'un monstre
     * 
     */
    public void deplace() {
        Random rd = new Random();
        boolean verf_x = false;
        boolean verf_y = false;
        while(!verf_x && !verf_y){
            int direction_x = rd.nextInt(3) - 1;
            int direction_y = rd.nextInt(3) - 1;
            if ((direction_x!= 0) && (direction_y != 0)){
                if ((0 <= this.pos.getX()+ direction_x) && (this.pos.getX()+ direction_x < 100)){
                    this.pos.setX(this.pos.getX()+direction_x);
                    verf_x = true;
                } 
                if ((0 <= this.pos.getY()+ direction_y) && (this.pos.getY()+ direction_y < 100)){
                    this.pos.setY(this.pos.getY()+direction_y);
                    verf_y = true;
                }
            }
        }
    }
    
    /**
     * Méthode affiche qui permet l'affichage d'un Monstre
     */
    public void affiche() {
        System.out.println("ma position est : ");
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
    
    public int getPtPar() {
        return ptPar;
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

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }
    
    
}
