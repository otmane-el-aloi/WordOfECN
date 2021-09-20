package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe pour presenter les personnages d'un World
 *
 * @author Groupe 24
 */
public class Personnage {


    private String nom;
    // Point de vie
    private int ptVie;
    // Point de mana (niveau de magie)
    private int ptMana;
    // Pourcentage d'attaque
    private int pourcentageAtt;
    // Pourcentage par?
    private int pourcetagePar;
    // Pourcentage de magie
    private int pourcentageMag;
    // Pourcentage resistance de magie
    private int ResistMag;
    // Degree d'attage
    private int degAtt;
    // Dégats de magie 
    private int degMag;
    // Distance d'attque par la magie
    private int distAttMag;
    // position
    private Point2D pos;

    /**
     * Constructeur Personnage
     *
     * @param nom Nom du personnage
     * @param ptV points vie
     * @param ptM points mana (niveau de magie)
     * @param pA pourcentage attaque
     * @param pP pourcentage par?
     * @param pM pourcentage magie
     * @param rM pourcentage resistance magie
     * @param dA degats d'attaque
     * @param dM degats magie
     * @param distMax distance d'attaque maximal
     * @param pos position du personnage dans le monde
     */
    public Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos) {
        this.nom = nom;
        this.ptVie = ptV;
        this.ptMana = ptM;
        this.pourcentageAtt = pA;
        this.pourcetagePar = pP;
        this.pourcentageMag = pM;
        this.ResistMag = rM;
        this.degAtt = dA;
        this.distAttMag = dM;
        this.pos = pos;
    }

    /**
     * Constructeur du Personnage à partir d'un objet personnage
     *
     * @param P objet Personnage
     */
    public Personnage(Personnage P) {
        this.nom = P.nom;
        this.ptVie = P.ptVie;
        this.ptMana = P.ptMana;
        this.pourcentageAtt = P.pourcentageAtt;
        this.pourcetagePar = P.pourcetagePar;
        this.pourcentageMag = P.pourcentageMag;
        this.ResistMag = P.ResistMag;
        this.degAtt = P.degAtt;
        this.distAttMag = P.distAttMag;
        this.pos = new Point2D(P.pos);
    }

    /**
     * Constructeur par defaut
     */
    public Personnage() {
        this.nom = " ";
        this.ptVie = 0;
        this.ptMana = 0;
        this.pourcentageAtt = 0;
        this.pourcetagePar = 0;
        this.pourcentageMag = 0;
        this.ResistMag = 0;
        this.degAtt =  0;
        this.distAttMag =  0;
        this.pos = new  Point2D(0,0);
    }

    // Definition des méthodes :
    /**
     * permet de deplacer personnage sur une case adjacente choisie aleatoirement
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
     * afficher les coordonnes du personnage
     */
    public void affiche() {
        System.out.println("La position de "+this.getNom()+" est :");
        pos.affiche();
    }
    
    // Definition des getters et setters
    public String getNom() {
        return nom;
    }

    public int getPtVie() {
        return ptVie;
    }

    public int getPtMana() {
        return ptMana;
    }

    public int getPourcentageAtt() {
        return pourcentageAtt;
    }

    public int getPourcetagePar() {
        return pourcetagePar;
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public int getResistMag() {
        return ResistMag;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public int getDegMag() {
        return degMag;
    }

    public int getDistAttMag() {
        return distAttMag;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    public void setPourcentageAtt(int pourcentageAtt) {
        this.pourcentageAtt = pourcentageAtt;
    }

    public void setPourcetagePar(int pourcetagePar) {
        this.pourcetagePar = pourcetagePar;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public void setResistMag(int ResistMag) {
        this.ResistMag = ResistMag;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public void setDistAttMag(int distAttMag) {
        this.distAttMag = distAttMag;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }

}
