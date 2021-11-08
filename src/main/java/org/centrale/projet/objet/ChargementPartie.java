/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Groupe 24
 */
public class ChargementPartie {
    // Definitions des attributs
    /**
     * source = nom du fichier de sauvegarde
     */
    private String source;
    /**
     * type BufferedReader
     */
    private BufferedReader fichier;
    
    // Definitions des constructeurs
    /**
     * Constructeur a un parametre
     * @param source : nom du fichier de sauvegarde
     * @throws FileNotFoundException 
     */
    public ChargementPartie(String source) throws FileNotFoundException{
        this.source = source;
        this.fichier = new BufferedReader(new FileReader(source), 100000);
    }
    // Definitions des methodes
    /**
     * Permet de gerer les differents objets de types ElementDeJeu
     * @param params : une ligne qui correspond a un objet de type ElementDeJeu
     * @return : un objet ElementDeJeu avec ses attributs
     */
    public ElementDeJeu creerElementJeu(String params){
        ElementDeJeu elmt = null;
        String delimiteurs = " ,.;";
        StringTokenizer tokenizer;
        tokenizer = new StringTokenizer(params, delimiteurs);
        while(tokenizer.hasMoreTokens()){
            String mot = tokenizer.nextToken();
            mot = mot.toLowerCase();
            // s'il est un Objet
            if (mot.equals("nuagetoxique")){
                int pourcentageAttack = Integer.parseInt(tokenizer.nextToken());
                int ptPara = Integer.parseInt(tokenizer.nextToken());
                int ptDegAtt = Integer.parseInt(tokenizer.nextToken());
                int pourcentagePara = Integer.parseInt(tokenizer.nextToken());
                int centreX = Integer.parseInt(tokenizer.nextToken());
                int centreY = Integer.parseInt(tokenizer.nextToken());
                int rayon = 10;
                elmt = new NuageToxique(new Point2D(centreX, centreY), rayon, pourcentageAttack, pourcentagePara, ptDegAtt, ptPara);
            } else if (mot.equals("soin")){
                int ptVie = Integer.parseInt(tokenizer.nextToken());
                int posX = Integer.parseInt(tokenizer.nextToken());
                int posY = Integer.parseInt(tokenizer.nextToken());
                elmt = new Soin(new Point2D(posX, posY), ptVie);
            } else if (mot.equals("mana")){
                int ptMana = Integer.parseInt(tokenizer.nextToken());
                int posX = Integer.parseInt(tokenizer.nextToken());
                int posY = Integer.parseInt(tokenizer.nextToken());
                elmt = new Mana(new Point2D(posX, posY), ptMana);
            } else if (mot.equals("archer")| mot.equals("guerrier")|mot.equals("mage")|mot.equals("paysan")) {
                String nom = tokenizer.nextToken();
                int ptVie = Integer.parseInt(tokenizer.nextToken());
                int ptMagie = Integer.parseInt(tokenizer.nextToken());
                int pourcentageAtt = Integer.parseInt(tokenizer.nextToken());
                int pourcentagePar = Integer.parseInt(tokenizer.nextToken());;
                int pourcentageMagie = Integer.parseInt(tokenizer.nextToken());
                int pourcentageResistmagie = Integer.parseInt(tokenizer.nextToken());
                int degAtt = Integer.parseInt(tokenizer.nextToken());
                int degMagie = Integer.parseInt(tokenizer.nextToken());
                int distMax = Integer.parseInt(tokenizer.nextToken());
                int ptParade = Integer.parseInt(tokenizer.nextToken());
                int posX  = Integer.parseInt(tokenizer.nextToken());
                int posY = Integer.parseInt(tokenizer.nextToken());
                if (mot.equals("archer")) {
                    elmt = new Archer(nom, ptVie, ptMagie, pourcentageAtt, pourcentagePar, pourcentageMagie, pourcentageResistmagie, degAtt, degMagie, distMax, new Point2D(posX, posY), ptParade, 5, new ArrayList<>());
                } else if (mot.equals("guerrier")){
                    elmt  = new Guerrier(nom, ptVie, ptMagie, pourcentageAtt, 
                        pourcentagePar, pourcentageMagie, pourcentageResistmagie, degAtt, degMagie, distMax, new Point2D(posX, posY), ptParade, new ArrayList<>());
                } else if (mot.equals("mage")){
                    elmt = new Mage(nom, ptVie, ptMagie, pourcentageAtt, 
                        pourcentagePar, pourcentageMagie, pourcentageResistmagie, degAtt, degMagie, distMax, new Point2D(posX, posY), ptParade, new ArrayList<>());
                } else if (mot.equals("paysan")){
                    elmt = new Paysan(nom, ptVie, ptMagie, pourcentageAtt, 
                        pourcentagePar, pourcentageMagie, pourcentageResistmagie, degAtt, degMagie, distMax, new Point2D(posX, posY), ptParade, new ArrayList<>());
                }
                    
            } else if (mot.equals("lapin")|mot.equals("loup")){
                int ptVie = Integer.parseInt(tokenizer.nextToken());
                int pourcentageAttack = Integer.parseInt(tokenizer.nextToken());
                int pourcentagePar = Integer.parseInt(tokenizer.nextToken());
                int degAttach = Integer.parseInt(tokenizer.nextToken());
                int ptPar = Integer.parseInt(tokenizer.nextToken());;
                int posX = Integer.parseInt(tokenizer.nextToken());
                int posY = Integer.parseInt(tokenizer.nextToken());
                if (mot.equals("lapin")){
                    elmt = new Lapin(ptVie, pourcentageAttack, pourcentagePar, degAttach, new Point2D(posX, posY), ptPar);
                } else {
                    elmt = new Loup(ptVie, pourcentageAttack, pourcentagePar, degAttach, new Point2D(posX, posY), ptPar);
                }
            } 
        }
        return elmt;
    }
    /**
     * permet de definir le world 
     * @return le World correspond a la partie chargee
     * @throws IOException 
     */
    public World chargerPartie() throws IOException{
        String delimiteurs = " ,.;";
        StringTokenizer tokenizer;
        World WoE = new World();
        
        ArrayList<Creature> listCreatures = new ArrayList<>();
        ArrayList<Potion> listPotions = new ArrayList<>();
        
        
        ElementDeJeu elmtJeu;
        // parcours des lignes du fichier
        String ligne;
        ligne = fichier.readLine();
        while(ligne != null){
            tokenizer = new StringTokenizer(ligne, delimiteurs);
            while(tokenizer.hasMoreTokens()){
                String mot = tokenizer.nextToken();
                mot = mot.toLowerCase();
                if (mot.equals("largeur" )){
                    WoE.setLargeur(Integer.parseInt(tokenizer.nextToken()));
                } else if (mot.equals("hauteur")){
                    WoE.setHauteur(Integer.parseInt(tokenizer.nextToken()));
                } else if (mot.equals("joueur")){   
                    String typeJoueur = tokenizer.nextToken();
                    typeJoueur = typeJoueur.toLowerCase();
                    String nom = tokenizer.nextToken();
                    int ptVie = Integer.parseInt(tokenizer.nextToken());
                    int ptMagie = Integer.parseInt(tokenizer.nextToken());
                    int pourcentageAtt = Integer.parseInt(tokenizer.nextToken());
                    int pourcentagePar = Integer.parseInt(tokenizer.nextToken());;
                    int pourcentageMagie = Integer.parseInt(tokenizer.nextToken());
                    int pourcentageResistmagie = Integer.parseInt(tokenizer.nextToken());
                    int degAtt = Integer.parseInt(tokenizer.nextToken());
                    int degMagie = Integer.parseInt(tokenizer.nextToken());
                    int distMax = Integer.parseInt(tokenizer.nextToken());
                    int ptParade = Integer.parseInt(tokenizer.nextToken());
                    int posX  = Integer.parseInt(tokenizer.nextToken());
                    int posY = Integer.parseInt(tokenizer.nextToken());
                    Joueur j = new Joueur();
                    if (typeJoueur.equals("archer")) {
                        Archer a = new Archer(nom, ptVie, ptMagie, pourcentageAtt, 
                            pourcentagePar, pourcentageMagie, pourcentageResistmagie, degAtt, degMagie, distMax, new Point2D(posX, posY), ptParade, 5, new ArrayList<>());
                        j.setPerso(a);

                    } else if (typeJoueur.equals("guerrier")){
                        Guerrier g  = new Guerrier(nom, ptVie, ptMagie, pourcentageAtt, 
                            pourcentagePar, pourcentageMagie, pourcentageResistmagie, degAtt, degMagie, distMax, new Point2D(posX, posY), ptParade, new ArrayList<>());
                        j.setPerso(g);
                    } else if (typeJoueur.equals("mage")){
                        Mage m = new Mage(nom, ptVie, ptMagie, pourcentageAtt, 
                            pourcentagePar, pourcentageMagie, pourcentageResistmagie, degAtt, degMagie, distMax, new Point2D(posX, posY), ptParade, new ArrayList<>());
                        j.setPerso(m);
                    } else if (typeJoueur.equals("paysan")){
                        Paysan pa = new Paysan(nom, ptVie, ptMagie, pourcentageAtt, 
                            pourcentagePar, pourcentageMagie, pourcentageResistmagie, degAtt, degMagie, distMax, new Point2D(posX, posY), ptParade, new ArrayList<>());
                        j.setPerso(pa);
                    }
                    WoE.setJoueur(j);
                } else {
                    elmtJeu = creerElementJeu(ligne);
                    if (elmtJeu instanceof Creature){
                        listCreatures.add((Creature)elmtJeu);
                    } else if (elmtJeu instanceof Potion){
                        listPotions.add((Potion)elmtJeu);
                    } else if (elmtJeu instanceof NuageToxique){
                        WoE.setNuage((NuageToxique)elmtJeu);
                    }
                    break;
                }
            }
            ligne = fichier.readLine();
        }
        fichier.close();
        WoE.setListCreatures(listCreatures);
        WoE.setListPotions(listPotions);
        return WoE;
        }
    
    // Definition des getters et setters
    public String getSource() {
        return source;
    }

    public BufferedReader getFichier() {
        return fichier;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setFichier(BufferedReader fichier) {
        this.fichier = fichier;
    }
    
}
