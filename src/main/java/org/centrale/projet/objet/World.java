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
    
    // Dimension du monde
    final static int DIMENSION = 50;
    // nombreMaxCreature
    private int  nbMaxCreatures;
    // Liste des creatures
    private ArrayList<Creature> listCreatures;
    private ArrayList<Objet> listObjets;
    // Nombres des creatures crées
    public int nbPaysan;
    public int nbArcher;
    public int nbGuerrier;
    public int nbLapin;
    public int nbLoup;

    
    
    // Définition des constructeurs
    /**
     * Constructeur 
     * @param nbCreatures
     * @param dim
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
        for (int i=0; i<this.nbMaxCreatures;i++){
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
                
                break;
                    
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
     * Calcul la position d'un protagoniste en tenant compte des conditions
     * 
     * @return 
     */
    public Point2D computeInitialPos(){
        Random generateurRandom = new Random();
        boolean surposition = true;
        // position du premier protagoniste
        Point2D pP = new Point2D(generateurRandom.nextInt(World.DIMENSION),  
                generateurRandom.nextInt(World.DIMENSION));
        while (surposition == true)
         for (int i=0; i<this.listCreatures.size()-1; i++){
            double distance;
            distance = Point2D.distance(pP, this.listCreatures.get(i).getPos());
            if (distance == 0){
                surposition = true;
                pP.setX(generateurRandom.nextInt(World.DIMENSION));
                pP.setY(generateurRandom.nextInt(World.DIMENSION));
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
        // initialisation des positions : notre monde a les limites suivantes : [0, 100]
        for (int i=0; i<this.listCreatures.size(); i++){
                this.listCreatures.get(i).setPos(computeInitialPos());
            }
        }

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

    public static int getDimension() {
        return DIMENSION;
    }
    
    
}
    
   
    


