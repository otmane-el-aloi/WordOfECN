/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.Random;
import java.util.ArrayList;

/**
 * Classe Word : definie les Protagonistes
 * @author Groupe 24
 */
public class World {
    
    
    private int  nbMaxCreatures;
    private ArrayList<Creature> listCreatures;
    private ArrayList<Objet> listObjets;
    public int nbPaysan;
    public int nbArcher;
    public int nbGuerrier;
    public int nbLapin;
    public int nbLoup;

    
    
    // Définition des constructeurs
    /**
     * Constructeur 
     * @param nbCreatures
     */
    public World(int nbCreatures) {
        this.nbMaxCreatures = nbCreatures;
        this.nbPaysan = 0;
        this.nbArcher = 0;
        this.nbGuerrier = 0;
        this.nbLapin = 0;
        this.nbLoup = 0;
        Random generateurRandom = new Random();
        listCreatures = new ArrayList<>();
        listObjets = new ArrayList<>();
        for (int i=0; i<generateurRandom.nextInt(this.nbMaxCreatures);i++){
            int choix = generateurRandom.nextInt(5);
            switch(choix){
                case 0:
                    Archer archer = new Archer();
                    this.listCreatures.add(archer);
                    this.nbArcher +=1;
                case 1:
                    Paysan paysan = new Paysan();
                    this.listCreatures.add(paysan); 
                    this.nbPaysan +=1;
                case 2:
                    Lapin lapin = new Lapin();
                    this.listCreatures.add(lapin); 
                    this.nbLapin +=1;
                case 3:
                    Guerrier guerrier = new Guerrier();
                    this.listCreatures.add(guerrier);
                    this.nbGuerrier +=1;
              
                case 4:
                    Loup loup = new Loup();
                    this.listCreatures.add(loup);
                    this.nbLoup +=1;
            }
        }

    }
    /**
     * Constructeur de recopie
     * 
     * @param w 
     */
    public World(World w){
         this.nbMaxCreatures = w.nbMaxCreatures;
         this.nbMaxCreatures = w.nbMaxCreatures;
         this.listObjets = w.listObjets;
         this.nbPaysan = w.nbPaysan;
         this.nbArcher = w.nbArcher;
         this.nbGuerrier = w.nbGuerrier;
         this.nbLapin = w.nbLapin;
         this.nbLoup = w.nbLoup;
    }
    
    /**
     * Constructeurs vides 
     * 
     */
    public World(){
        this.listCreatures = new ArrayList<>();
        this.listObjets = new ArrayList<>();
        this.nbPaysan = 0;
        this.nbArcher = 0;
        this.nbGuerrier = 0;
        this.nbLapin = 0;
        this.nbLoup = 0;
    }
    
    // Définition des méthodes
    /**
     * 
     * @param x
     * @param y
     * @return 
     */
    public Point2D computeInitialPos(int x, int y){
        Random generateurRandom = new Random();
        boolean surposition = true;
        // position du peon
        Point2D pP = new Point2D(x + generateurRandom.nextInt(11)-5,  
                y + generateurRandom.nextInt(11)-5);
        while (surposition == true)
         for (int i=0; i<this.listCreatures.size()-1; i++){
            double distance;
            distance = Point2D.distance(pP, this.listCreatures.get(i).getPos());
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
    /*
    public void creeMondealea() {
        
        Random generateurRandom = new Random();
        // initialisation des positions : notre monde a les limites suivantes : [0, 100]
        int max_pos = 100 - 5 ;
        int min_pos =  5;
        Point2D pR = new Point2D(generateurRandom.nextInt(max_pos-min_pos +1) +
        min_pos, generateurRandom.nextInt(max_pos - min_pos + 1) + min_pos);
        this.listCreatures.get(0).setPos(pR);
        int x  = this.listCreatures.get(0).getPos().getX();
        int y = this.listCreatures.get(0).getPos().getY();
        
        for (int i=1; i<this.listCreatures.size(); i++){
                this.listCreatures.get(i).setPos(computeInitialPos(x, y));
            }
        }
    */
    // Getters & Setters

    public int getNbMaxCreatures() {
        return nbMaxCreatures;
    }

    public ArrayList<Creature> getListCreatures() {
        return listCreatures;
    }

    public ArrayList<Objet> getListObjets() {
        return listObjets;
    }

    public void setNbMaxCreatures(int nbMaxCreatures) {
        this.nbMaxCreatures = nbMaxCreatures;
    }

    public void setListCreatures(ArrayList<Creature> listCreatures) {
        this.listCreatures = listCreatures;
    }

    public void setListObjets(ArrayList<Objet> listObjets) {
        this.listObjets = listObjets;
    }
    
    
    
    
    
}
    
   
    


