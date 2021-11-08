package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe pour presenter les personnages d'un World
 *
 * @author Groupe 24
 */
public abstract class Personnage extends Creature {
    
    private String nom;
    // Point de mana (niveau de magie)
    private int ptMana;
    // Pourcentage de magie
    private int pourcentageMag;
    // Pourcentage resistance de magie
    private int pourcentageResistMag;
    // Dégats de magie 
    private int degMag;
    // Distance d'attaque maximale
    private int distAttMax;
    // Distance d'attque par la magie
    private int distAttMag;
    // Liste de nourriture
    private ArrayList<Nourriture> listNourriture;

    /**
     * 
     * Constructeur Personnage
     * 
     * @param nom : nom du Personnage
     * @param ptV : Point de Vie
     * @param ptM : Point de Mana
     * @param pA : Pouircentage d'attack
     * @param pP : Pourcentage de Paries
     * @param pM : pourcentage magie
     * @param rM : pourcentage resistance magie
     * @param dA : degats d'attaque
     * @param dM : degats magie
     * @param distMax : distance d'attaque maximal
     * @param pos : position du personnage dans le monde
     * @param ptPar : points de parade
     * @param listNourriture : liste des nourritures
     */
    public Personnage(String nom, int ptV, int ptM, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar, ArrayList<Nourriture> listNourriture) {
        super(ptV, pA, pP, dA, pos, ptPar);
        this.nom = nom;
        this.ptMana = ptM;
        this.pourcentageMag = pM;
        this.pourcentageResistMag = rM;
        this.distAttMax = distMax;
        this.distAttMag = dM;
        this.listNourriture = listNourriture;
    }

    /**
     * Constructeur de recopie Personnage à partir d'un objet personnage
     * @param P objet Personnage
     */
    public Personnage(Personnage P) {
        super(P);
        this.nom = P.nom;
        this.ptMana = P.ptMana;
        this.pourcentageMag = P.pourcentageMag;
        this.pourcentageResistMag = P.pourcentageResistMag;
        this.distAttMax = P.distAttMax;
        this.distAttMag = P.distAttMag;
        this.listNourriture = P.listNourriture;
    }

    /**
     * Constructeur par defaut
     */
    public Personnage() {
        Random rd = new Random();
        this.nom = "Personnage";
        this.ptMana = rd.nextInt(20);
        this.pourcentageMag = rd.nextInt(20);
        this.pourcentageResistMag = rd.nextInt(20);
        this.distAttMag =  rd.nextInt(20);
        this.distAttMax = rd.nextInt(20);
        this.listNourriture = new ArrayList<>();
    }
    
    // Definition des methodes :
    /**
     * ajouter l'effet de la nourriture au caracteristique du personnage
     */
    public void consommerNouriture(){
        for(Nourriture n:listNourriture){
            switch(n.getCarac()){
                case 0 : 
                    if (this.pourcentageMag + n.getVal() < 0){
                        n.setVal(0);
                    }
                    this.pourcentageMag += n.getVal();
                    break;
                case 1 :
                    if (this.pourcentageResistMag + n.getVal() < 0){
                        n.setVal(0);
                    }
                    this.pourcentageResistMag += n.getVal();
                    break;
                case 2 :
                    if (this.distAttMax + n.getVal() < 0){
                        n.setVal(0);
                    }
                    this.distAttMax += n.getVal();
                    break;
                case 3 :
                    if (this.distAttMag + n.getVal() < 0){
                        n.setVal(0);
                    }
                    this.distAttMag += n.getVal();
                    break;
            }
        }
    }
    /**
     * Eliminer l'effet de la nourriture
     */
    public void deconsommerNourriture(int indice){
        //for(Nourriture n:listNourriture){
        switch(listNourriture.get(indice).getCarac()){
            case 0 : 
                this.pourcentageMag -= listNourriture.get(indice).getVal();
                break;
            case 1 :
                this.pourcentageResistMag -= listNourriture.get(indice).getVal();
                break;
            case 2 :
                this.distAttMax -= listNourriture.get(indice).getVal();
                break;
            case 3 :
                this.distAttMag -= listNourriture.get(indice).getVal();
                break;
        }
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

    public int getPourcentageResistMag() {
        return pourcentageResistMag;
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

    public void setPourcentageResistMag(int pourcentageResistMag) {
        this.pourcentageResistMag = pourcentageResistMag;
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

    public ArrayList<Nourriture> getListNourriture() {
        return listNourriture;
    }

    public void setListNourriture(ArrayList<Nourriture> listNourriture) {
        this.listNourriture = listNourriture;
    }

    
}
