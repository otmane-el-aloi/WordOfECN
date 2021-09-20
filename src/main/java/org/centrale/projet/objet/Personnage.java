package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe pour presenter les personnages d'un World
 *
 * @author Groupe 24
 */
public class Personnage extends Creature {

    
    private String nom;
    // Point de vie
    //private int ptVie;
    // Point de mana (niveau de magie)
    private int ptMana;
    // Pourcentage d'attaque
    //private int pourcentageAtt;
    // Pourcentage par?
    //private int pourcetagePar;
    // Pourcentage de magie
    private int pourcentageMag;
    // Pourcentage resistance de magie
    private int ResistMag;
    // Degree d'attage
    //private int degAtt;
    // Dégats de magie 
    private int degMag;
    // Distance d'attque par la magie
    private int distAttMag;
    // position
    //private Point2D pos;
    // ?????
    private int ptPar;

    /**
     * Constructeur avec plusieurs parametres de Personnage
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
     * @param ptPar ???????
     */
    public Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
        super(ptV, pA, dA, pos);
        this.nom = nom;
        //this.ptVie = ptV;
        this.ptMana = ptM;
        //this.pourcentageAtt = pA;
        //this.pourcetagePar = pP;
        this.pourcentageMag = pM;
        this.ResistMag = rM;
        //this.degAtt = dA;
        this.distAttMag = dM;
        //this.pos = pos;
        this.ptPar = ptPar;
    }

    /**
     * Constructeur de recopie Personnage à partir d'un objet personnage
     *
     * @param P objet Personnage
     */
    public Personnage(Personnage P) {
        super(P);
        this.nom = P.nom;
        //this.ptVie = P.ptVie;
        this.ptMana = P.ptMana;
        //this.pourcentageAtt = P.pourcentageAtt;
        //this.pourcetagePar = P.pourcetagePar;
        this.pourcentageMag = P.pourcentageMag;
        this.ResistMag = P.ResistMag;
        //this.degAtt = P.degAtt;
        this.distAttMag = P.distAttMag;
        //this.pos = new Point2D(P.pos);
        this.ptPar = P.ptPar;
    }

    /**
     * Constructeur par defaut
     */
    public Personnage() {
        this.nom = " ";
        //this.ptVie = 0;
        this.ptMana = 0;
        //this.pourcentageAtt = 0;
        //this.pourcetagePar = 0;
        this.pourcentageMag = 0;
        this.ResistMag = 0;
        //this.degAtt =  0;
        this.distAttMag =  0;
        //this.pos = new  Point2D(0,0);
        this.ptPar = 0;
    }

    // Definition des méthodes :
    /**
     * afficher les coordonnes du personnage
     */
    public void affiche() {
        System.out.println("La position de "+this.getNom()+" est :");
        this.getPos().affiche();
    }
    
    // Definition des getters et setters

    public String getNom() {
        return nom;
    }

    public int getPtMana() {
        return ptMana;
    }

    public int getPourcentageMag() {
        return pourcentageMag;
    }

    public int getResistMag() {
        return ResistMag;
    }

    public int getDegMag() {
        return degMag;
    }

    public int getDistAttMag() {
        return distAttMag;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPtMana(int ptMana) {
        this.ptMana = ptMana;
    }

    public void setPourcentageMag(int pourcentageMag) {
        this.pourcentageMag = pourcentageMag;
    }

    public void setResistMag(int ResistMag) {
        this.ResistMag = ResistMag;
    }

    public void setDegMag(int degMag) {
        this.degMag = degMag;
    }

    public void setDistAttMag(int distAttMag) {
        this.distAttMag = distAttMag;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }
}
