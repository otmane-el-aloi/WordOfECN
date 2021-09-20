/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.util.Random;
/**
 * Classe Monstre 
 * @author Groupe 24
 */
public class Monstre {

    // Definition des attributs
    // Points de vie
    private int ptVie;
    // Pourcentage d'attaque
    private int pourcentageAtt;
    // Pourcentage de Par
    private int pourcentagePar;
    // Degree D'attaque
    private int degAtt;
    // Position
    private Point2D pos;

    /**
     * Construteur d'un Monstre
     * 
     * @param pV
     * @param pA
     * @param pP
     * @param dA
     * @param pos 
     */
    public Monstre(int pV, int pA, int pP, int dA, Point2D pos) {
        ptVie = pV;
        pourcentageAtt = pA;
        pourcentagePar = pP;
        degAtt = dA;
        this.pos = pos;
    }
    /**
     * Constructeur avec un parametre
     * @param m : Objet monstre
     */
    public Monstre(Monstre m) {
        this.ptVie = m.ptVie;
        this.pourcentageAtt = m.pourcentageAtt;
        this.pourcentagePar = m.ptVie;
        this.degAtt = m.degAtt;
        this.pos = new Point2D(m.pos);
    }
    /**
     * Constructeur par defaut
     */
    public Monstre() {
        this.ptVie = 0;
        this.pourcentageAtt = 0;
        this.pourcentagePar = 0;
        this.degAtt = 0;
        this.pos = new Point2D(0, 0);        
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
