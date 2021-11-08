/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe NuageToxique qui implemente les interfaces Deplacable et Combattant
 * @author Groupe 24
 */
public class NuageToxique extends Objet implements Deplacable, Combattant {
    
    // Definition des attributs :
    /**
     * centre du nuage
     */
    private Point2D centre;
    /**
     * nombre de carre a mettre dans les cotes
     */
    private int rayon;
    /**
     * pourcentage d'attaque
     */  
    private int pourcentageAttack;
    /**
     * pourcentage de parade
     */
    private int pourcentagePara;
    /**
     * points de degats d'attaque
     */
    private int ptDegAtt;
    /**
     * points de parade
     */
    private int ptPara;
    // Definition des constructeurs:
    /**
     * 
     * @param centre : centre du nuage
     * @param rayon : points de dammage apporte par le nuage
     * @param pourcentageAttack : pourcentage d'attaque
     * @param pourcentagePara : pourcentage de parade
     * @param ptDegAtt : points de degats d'attaque
     * @param ptPara : points de parade
     */
    public NuageToxique(Point2D centre, int rayon, int pourcentageAttack, int pourcentagePara, int ptDegAtt, int ptPara){
        this.centre = centre;
        this.rayon = rayon;
        this.pourcentageAttack = pourcentageAttack;
        this.pourcentagePara = pourcentagePara;
        this.ptDegAtt = ptDegAtt;
        this.ptPara = ptPara;
    }
    /**
     * Constructeur par defaut
     */
    public NuageToxique(){
        Random rd = new Random();
        Point2D pos =  new Point2D(rd.nextInt(20), rd.nextInt(20));
        this.centre = pos;
        this.rayon = rd.nextInt(5);
        this.pourcentageAttack = rd.nextInt(20);
        this.pourcentagePara = rd.nextInt(20);
        this.ptDegAtt = rd.nextInt(20);
        this.ptPara = rd.nextInt(20);
    }
    /**
     * Constructeur de recopie
     * @param nT : objet de type NuageToxique
     */
    public NuageToxique(NuageToxique nT){
        this.centre = nT.getCentre();
        this.rayon = nT.getRayon();
        this.pourcentageAttack = nT.pourcentageAttack;
        this.pourcentagePara = nT.pourcentagePara;
        this.ptDegAtt = nT.ptDegAtt;
        this.ptPara = nT.ptPara;
    }
    
    // Definition des methodes :
    /**
     * pour deplacer le nuage dans le monde
     */
    @Override
    public void deplace(int largeur, int hauteur) {
        Random rd = new Random();
        boolean verf_x = false;
        boolean verf_y = false;
        while(!verf_x && !verf_y){
            int direction_x = rd.nextInt(3) - 1;
            int direction_y = rd.nextInt(3) - 1;
            if ((direction_x!= 0) && (direction_y != 0)){
                if ((0 <= this.centre.getX()+ direction_x) && (this.centre.getX()+ direction_x < largeur)){
                    this.centre.setX(this.centre.getX()+direction_x);
                    verf_x = true;
                } 
                if ((0 <= this.centre.getY()+ direction_y) && (this.centre.getY()+ direction_y < hauteur)){
                    this.centre.setY(this.centre.getY()+direction_y);
                    verf_y = true;
                }
            }
        }
    }
    /**
     * le nuage combattre un creature
     * @param c : Objet de type Creature
     */
    @Override
    public void combattre(Creature c){
        if ( (c.getPos().getX()>(this.centre.getX()+this.rayon)) &&  (c.getPos().getX()<(this.centre.getX()-this.rayon))){
            if (((c.getPos().getY()>(this.centre.getY()+this.rayon)) &&  (c.getPos().getY()<(this.centre.getY()-this.rayon)))){
                System.out.println("Au dessous d'un NuageToxique");
                Random rInt = new Random();
                if (rInt.nextInt(100) + 1 <= this.getPourcentageAttack()) {
                  int damage = 0;
                  if (rInt.nextInt(100) + 1 > this.getPourcentagePara()){
                  damage = this.getPtDegAtt();
                  }
                  else{
                      Math.max(this.getPtDegAtt()-c.getPtPar(), 0);
                  }
                  c.setPtVie(Math.max(c.getPtVie() - damage, 0));
                  
                  System.out.println("Attaque réussi avec un dégat de: " + Math.max(c.getPtVie() - damage, 0) );
                } else {
                  System.out.println("attaque ratée!");
                }
            }
        }
    }
    
    /**
     * affiche les caracteristiaues du nuage
     */
    public void affiche(){
        System.out.println("Je suis NuageToxique");
        System.out.println("Mon centre est :");
        this.getCentre().affiche();
        System.out.println("Mon rayon est : "+this.rayon);
    }
    
    // DEfiniton des getters et setters

    public Point2D getCentre() {
        return centre;
    }

    public int getRayon() {
        return rayon;
    }

    public void setCentre(Point2D centre) {
        this.centre = centre;
    }

    public void setRayon(int rayon) {
        this.rayon = rayon;
    }

    public int getPourcentageAttack() {
        return pourcentageAttack;
    }

    public int getPourcentagePara() {
        return pourcentagePara;
    }

    public int getPtDegAtt() {
        return ptDegAtt;
    }

    public int getPtPara() {
        return ptPara;
    }

    public void setPourcentageAttack(int pourcentageAttack) {
        this.pourcentageAttack = pourcentageAttack;
    }

    public void setPourcentagePara(int pourcentagePara) {
        this.pourcentagePara = pourcentagePara;
    }

    public void setPtDegAtt(int ptDegAtt) {
        this.ptDegAtt = ptDegAtt;
    }

    public void setPtPara(int ptPara) {
        this.ptPara = ptPara;
    }

    
    
}
