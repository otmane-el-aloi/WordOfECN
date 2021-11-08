/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Classe Joueur
 * @author Groupe 24
 */
public class Joueur {
    /**
     * perso : Personnage
     */
    private Personnage perso ;
    
    // Definition des constructeurs
    /**
     * Constructeur par defaut
     */
    public Joueur(){
        this.perso = null;
    }
    
    // Defintion des methodes
    /**
     * pour creer le joueur
     */
    public void participe(){
        try{
            Random val = new Random();
            System.out.println("Choisir le type de votre joueur");
            Scanner sc = new Scanner(System.in);
            String choix = sc.nextLine();
            System.out.println("Entrer un nom a votre joueur");
            String name = sc.nextLine();
            ArrayList<Nourriture> listNour = new ArrayList<>();
            switch (choix) {
                case "Archer" : 
                    this.setPerso(new Archer(name, val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50), val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50),val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50), new Point2D(0, 0), val.nextInt(50), val.nextInt(10), listNour));
                    break;
                case "Guerrier" :
                    this.setPerso(new Guerrier(name, val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50), val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50),val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50), new Point2D(0, 0), val.nextInt(10), listNour));
                    break;
                case "Mage" :
                    this.setPerso(new Mage(name, val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50), val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50),val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50), new Point2D(0, 0), val.nextInt(10), listNour));
                    break;
                case "Paysan" :
                    this.setPerso(new Paysan(name, val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50), val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50),val.nextInt(50), val.nextInt(50), 
                            val.nextInt(50), new Point2D(0, 0), val.nextInt(10), listNour));
                    break;
                default :
                    System.out.println("Choix impossible");             
            }
        } catch(NumberFormatException e) {
            System.out.println("Saisie incorrecte");
        }
    }
    // getters et setters :
    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }
    
}

    
