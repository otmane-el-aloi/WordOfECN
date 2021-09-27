/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

/**
 *
 * @author Groupe 24
 */
public class TestSeance3 {
    
    public static void main(String[] args){
        // Diapo 9
        
        int nbMaximalSouhaite = 100;
        World WoE = new World(nbMaximalSouhaite);
        
        /*
        System.out.print("Le nombre maximale de creatures souhaités est:"+ nbMaximalSouhaite +"\n");
        System.out.print("Le nombre de protagonistes crées est:"+ WoE.getListCreatures().size() +"\n" );
        System.out.print("Le nombre de loup crées est:"+ WoE.nbArcher + "\n");
        System.out.print("Le nombre de paysan crées est:"+ WoE.nbPaysan + "\n");
        System.out.print("Le nombre de lapin crées est:"+ WoE.nbLapin + "\n");
        System.out.print("Le nombre de Guerrier crées est:"+ WoE.nbGuerrier + "\n");
        System.out.print("Le nombre de Loup crées est:"+ WoE.nbLoup + "\n");
        */
        
        // Diapo 12
        /*
        int nbElement = WoE.getListCreatures().size();
        for (int i=0;i<nbElement-1; i++){
            WoE.getListCreatures().get(i).affiche();
            
        }
        */
        // Diapo 16
        WoE.creeMondealea();
        
        int nbElement = WoE.getListCreatures().size();
        for (int i=0;i<nbElement-1; i++){
            WoE.getListCreatures().get(i).affiche();
            }
     
    }
}
