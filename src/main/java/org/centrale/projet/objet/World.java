/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;

/**
 * Classe Word : definie les Protagonistes
 * @author Groupe 24
 */
public class World {
    static final int nbCreature = 8;
    
    // Définition des attributs
    // robin de type Archer
    private Archer robin;
    // peon de type Paysan
    private Paysan peon;
    // bugs1 et bugs2 de type Lapin
    private Lapin bugs1;
    private Lapin bugs2;
    // guillaumeT de type Archer
    private Archer guillaumeT;
    // groBill de type Guerrier
    private Guerrier groBill;
    // merlin de type Mage 
    private Mage merlin;
    // wolfie de type Loop
    private Loup wolfie;
    // Liste de tous les creqtures
    private Creature[] listToutCreature;
    
    // Définition des constructeurs
    /**
     * Constructeur vide
     */
    public World() {
       
        this.listToutCreature = new Creature[nbCreature];
        this.robin = new Archer();
        this.listToutCreature[0] = this.robin;
        this.robin.setNom("Robin");
        this.peon = new Paysan();
        this.listToutCreature[1] = this.peon;
        this.peon.setNom("Peon");
        this.bugs1 = new Lapin();
        this.listToutCreature[2] = this.bugs1;
        this.bugs2 = new Lapin();
        this.listToutCreature[3] = this.bugs2;
        this.guillaumeT = new Archer();
        this.listToutCreature[4] = this.guillaumeT;
        this.guillaumeT.setNom("guillaumeT");
        this.groBill = new Guerrier();
        this.listToutCreature[5] = this.groBill;
        this.groBill.setNom("GroBill");
        this.merlin = new Mage();
        this.listToutCreature[6] = this.merlin;
        this.merlin.setNom("Merlin");
        this.wolfie = new Loup();
        this.listToutCreature[7] = this.wolfie;
    }

    // Définition des méthodes
    /**
     * This functions computes the initial position of a new personnage 
     * that repects the maximal distance of 5 between Personnage already 
     * initialized in the World. It makes sure that the new position is not already 
     * taken by another Personnage in the World.
     * 
     * @param x
     * @param y
     * @return Intial position of Personnage caracter that respect the conditions
     */
    public Point2D computeInitialPos(int x, int y){
        Random generateurRandom = new Random();
        boolean surposition = true;
        // position du peon
        Point2D pP = new Point2D(x + generateurRandom.nextInt(11)-5,  
                y + generateurRandom.nextInt(11)-5);
        while (surposition == true)
         for (int i=0; i<8; i++){
            double distance;
            distance = Point2D.distance(pP, this.listToutCreature[i].getPos());
            if (distance == 0){
                surposition = true;
                pP.setX(x + generateurRandom.nextInt(11)-5);
                pP.setY(y + generateurRandom.nextInt(11)-5);
                break;
            }
            else {
                surposition = false;
            }
        }
        return pP;
    }
    
    /**
     * creeMondealea permet d'initialiser les positions des creatures
     */
    public void creeMondealea() {
        Random generateurRandom = new Random();
        // initialisation des positions : notre monde a les limites suivantes : [0, 100]
        // position du robin
        int max_pos = 100 - 5 ;
        int min_pos =  5;
        Point2D pR = new Point2D(generateurRandom.nextInt(max_pos-min_pos +1) +
                min_pos, generateurRandom.nextInt(max_pos - min_pos + 1) + min_pos);
        robin.setPos(pR);
        int x  = robin.getPos().getX();
        int y = robin.getPos().getY();
        
        // Initialize peon's postion
        this.robin.setPos(computeInitialPos(x,y));
        this.peon.setPos(computeInitialPos(x,y));
        this.bugs1.setPos(computeInitialPos(x,y));
        this.bugs2.setPos(computeInitialPos(x,y));
        this.guillaumeT.setPos(computeInitialPos(x,y));
        this.groBill.setPos(computeInitialPos(x,y));
        this.merlin.setPos(computeInitialPos(x,y));
        this.wolfie.setPos(computeInitialPos(x,y));
    }
    
    public void tourDeJeu(){
        this.getRobin().deplace();
        this.getPeon().deplace();
        this.getBugs1().deplace();
        this.getBugs2().deplace();
        this.getGuillaumeT().deplace();
        this.getGroBill().deplace();
        this.getMerlin().deplace();
        this.getWolfie().deplace();
    }
    
    /**
     * affiche permet d'afficher les positions des creatures
     */
    public void afficheWorld(){
        this.getRobin().affiche();
        this.getPeon().affiche();
        this.getBugs1().affiche();
        this.getBugs2().affiche();
        this.getGuillaumeT().affiche();
        this.getGroBill().affiche();
        this.getMerlin().affiche();
        this.getWolfie().affiche();
    }
    
    //Definition des getters et setters

    public Archer getRobin() {
        return robin;
    }

    public Paysan getPeon() {
        return peon;
    }

    public Lapin getBugs1() {
        return bugs1;
    }

    public Lapin getBugs2() {
        return bugs2;
    }

    public Archer getGuillaumeT() {
        return guillaumeT;
    }

    public Guerrier getGroBill() {
        return groBill;
    }

    public Mage getMerlin() {
        return merlin;
    }

    public Loup getWolfie() {
        return wolfie;
    }

    public Creature[] getListToutCreature() {
        return listToutCreature;
    }

    public void setRobin(Archer robin) {
        this.robin = robin;
    }

    public void setPeon(Paysan peon) {
        this.peon = peon;
    }

    public void setBugs1(Lapin bugs1) {
        this.bugs1 = bugs1;
    }

    public void setBugs2(Lapin bugs2) {
        this.bugs2 = bugs2;
    }

    public void setGuillaumeT(Archer guillaumeT) {
        this.guillaumeT = guillaumeT;
    }

    public void setGroBill(Guerrier groBill) {
        this.groBill = groBill;
    }

    public void setMerlin(Mage merlin) {
        this.merlin = merlin;
    }

    public void setWolfie(Loup wolfie) {
        this.wolfie = wolfie;
    }

    public void setListToutCreature(Creature[] listToutCreature) {
        this.listToutCreature = listToutCreature;
    }
    
}


