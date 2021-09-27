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
        int nbMaximalSouhaite = 100;
        World WoE = new World(nbMaximalSouhaite);
        System.out.print("Le nombre maximale de creatures souhaités est:"+ nbMaximalSouhaite);
        System.out.print("Le nombre de protagonistes crées est:"+ WoE.getListCreatures().size() );
        System.out.print("Le nombre de loup crées est:"+ WoE.nbArcher);
        System.out.print("Le nombre de paysan crées est:"+ WoE.nbPaysan);
        System.out.print("Le nombre de lapin crées est:"+ WoE.nbLapin);
        System.out.print("Le nombre de Guerrier crées est:"+ WoE.nbGuerrier);
        System.out.print("Le nombre de Loup crées est:"+ WoE.nbLoup);
        
    }
}
