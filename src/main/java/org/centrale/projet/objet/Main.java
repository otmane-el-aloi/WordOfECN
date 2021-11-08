/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Groupe 24
 */
public class Main {
    public static void main(String[] args){
        try{
            World WoE = new  World();
            // Propositions de monde aleatoire ou partie existante :
            Scanner sc = new Scanner(System.in);
            System.out.println("Voulez vous une partie aleatoire (=1) ou une parite existante(=0) ?");
            String choix = sc.next();
            boolean verf = true;
            while (verf){
                if (choix.equals("1")){
                    // partie aleatoire
                    int nbMaximalSouhaite = 10;
                    WoE = new World(nbMaximalSouhaite);
                    WoE.creeMondealea();
                    WoE.creationJoueur();
                    verf = false;
                } else if (choix.equals("0")){
                    // partie existante
                    System.out.println("Entrer le nom complet de la partie");
                    ChargementPartie partie = new ChargementPartie(sc.next());
                    WoE = partie.chargerPartie();
                    WoE.afficheWorld();
                    WoE.afficheInterface();
                    verf = false;
                } else {
                    System.out.println("Choix impossible, reessayer !");
                    choix = sc.next();
                }
            }
            // Debut de jeu :
            WoE.tourDeJeu();
            WoE.afficheWorld();
            WoE.afficheInterface();
            
        // Pour les exceptions :
        } catch (IndexOutOfBoundsException e){
            System.out.println("Depassement de la dimension ");
        } catch (ArithmeticException e){
            System.out.println("Operation mathematique impossible !!");
        } catch (ClassCastException e){
            System.out.println("Transtypage impossible a cause des objets non compatible");
        } catch(NumberFormatException e){
            System.out.println("impossible !!");
        } catch(NullPointerException e){
            System.out.println("Saisie incorrecte !!");
        } catch (FileNotFoundException ex) {
            System.out.println("Partie introuvable !!");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchElementException e){
            System.out.println("Cette partie est introuvable");
        }
    
    }
}
    
