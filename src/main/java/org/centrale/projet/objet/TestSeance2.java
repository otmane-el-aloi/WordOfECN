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
public class TestSeance2 {
    public static void main(String[] args){
        World WoE = new World();
        // Positionnement des protagonistes de maniere aleatoire :
        WoE.creeMondealea();
        // Affichage des positions des protagonistes :
        System.out.println("******Les positions initiales des protagonistes*****");
        WoE.afficheWorld();        
        
        // Deplaçage des positions des protagonistes :
        System.out.println("******Les nouvelles positions des protagonistes apres deplacement******");
        WoE.tourDeJeu();
        WoE.afficheWorld(); 
        Guerrier groBill = WoE.getGroBill();
        Archer robin = WoE.getRobin();
        groBill.combattre(robin);
    }  
}
