package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe pour presenter les personnages d'un World
 *
 * @author Groupe 24
 */
public class Personnage extends Creature {

    
    private String nom;
    // Point de mana (niveau de magie)
    private int ptMana;
    // Pourcentage de magie
    private int pourcentageMag;
    // Pourcentage resistance de magie
    private int ResistMag;
    // Dégats de magie 
    private int degMag;
    // Distance d'attaque maximale
    private int distAttMax;
    // Distance d'attque par la magie
    private int distAttMag;

    /**
     * COnstructeur de la classe Personnage
     * 
     * @param nom
     * @param ptV
     * @param ptM
     * @param pA
     * @param pP
     * @param pM
     * @param rM
     * @param dA
     * @param dM
     * @param distMax
     * @param pos
     * @param ptPar 
     */
    public Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
        super(ptV, pA, pP, dA, pos, ptPar);
        this.nom = nom;
        this.ptMana = ptM;
        this.pourcentageMag = pM;
        this.ResistMag = rM;
        this.distAttMax = distMax;
        this.distAttMag = dM;
    }

    /**
     * Constructeur de recopie Personnage à partir d'un objet personnage
     *
     * @param P objet Personnage
     */
    public Personnage(Personnage P) {
        super(P);
        this.nom = P.nom;
        this.ptMana = P.ptMana;
        this.pourcentageMag = P.pourcentageMag;
        this.ResistMag = P.ResistMag;
        this.distAttMax = P.distAttMax;
        this.distAttMag = P.distAttMag;
    }

    /**
     * Constructeur par defaut
     */
    public Personnage() {
        this.nom = " ";
        this.ptMana = 0;
        this.pourcentageMag = 0;
        this.ResistMag = 0;
        this.distAttMag =  0;
        this.distAttMax = 0;
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

    public int getDistAttMax() {
        return distAttMax;
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

    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    public void setDistAttMag(int distAttMag) {
        this.distAttMag = distAttMag;
    }

    
}
