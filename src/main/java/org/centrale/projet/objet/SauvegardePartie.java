/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;

import java.io.*;

/**
 *
 * @author Groupe 24
 */
public class SauvegardePartie {
    // Definition des attributs
    /**
     * nom du fichier de sauvegarde
     */
    private String nomFichier;
    /**
     *  attribut de type BufferedWriter
     */
    private BufferedWriter bufferedWriter = null;
    // Definitions des constructeurs
    /**
     * Constructeur a un parametre
     * @param nomFichier : nom du fichier à sauvegarder
     */
    public SauvegardePartie(String nomFichier){
        this.nomFichier = nomFichier;
    }
    // Definitons des methodes
    /**
     * permet de traiter les objets de types ElementDeJeu
     * @param elmt : objet de type ElementDeJeu
     * @return ligne qui contient les caracteristiques de l'elmt
     */
    public String getTexteSauvegarde(ElementDeJeu elmt){
        String ligne = "";
        if (elmt instanceof Personnage){
            if (elmt instanceof Archer){
                ligne = "Archer ";
            } else if (elmt instanceof Guerrier){
                ligne = "Guerrier ";
            } else if (elmt instanceof Mage){
                ligne = "Mage ";
            } else {
                ligne = "Paysan ";
            }
            ligne += ((Personnage) elmt).getNom()+ " ";
            ligne += ((Personnage) elmt).getPtVie() + " ";
            ligne += ((Personnage) elmt).getPtMana() + " ";
            ligne += ((Personnage) elmt).getPourcentageAtt() + " ";
            ligne += ((Personnage) elmt).getPourcentagePar() + " ";
            ligne += ((Personnage) elmt).getPourcentageMag() + " ";
            ligne += ((Personnage) elmt).getPourcentageResistMag() + " ";
            ligne += ((Personnage) elmt).getDegAtt() + " ";
            ligne += ((Personnage) elmt).getDegMag() + " ";
            ligne += ((Personnage) elmt).getDistAttMax() + " ";
            ligne += ((Personnage) elmt).getPtPar() + " ";
            ligne += ((Personnage) elmt).getPos().getX() + " ";
            ligne += ((Personnage) elmt).getPos().getY() + " ";
        } else if (elmt instanceof Monstre){
            if (elmt instanceof Lapin){
                ligne = "Lapin ";
            } else if (elmt instanceof Loup) {
                ligne = "Loup ";
            }
            ligne += ((Monstre) elmt).getPtVie() + " ";
            ligne += ((Monstre) elmt).getPourcentageAtt() + " ";
            ligne += ((Monstre) elmt).getPourcentagePar() + " ";
            ligne += ((Monstre) elmt).getDegAtt() + " ";
            ligne += ((Monstre) elmt).getPtPar() + " ";
            ligne += ((Monstre) elmt).getPos().getX() + " ";
            ligne += ((Monstre) elmt).getPos().getY() + " ";
        } else if (elmt instanceof Potion){
            if (elmt instanceof Soin){
                ligne = "Soin ";
                ligne += ((Soin) elmt).getValPtVie() + " ";
                ligne += ((Soin) elmt).getPos().getX() + " ";
                ligne += ((Soin) elmt).getPos().getY() + " ";
            } else {
                ligne = "Mana ";
                ligne += ((Mana) elmt).getValMana() + " ";
                ligne += ((Mana) elmt).getPos().getX() + " ";
                ligne += ((Mana) elmt).getPos().getY() + " ";
            }
        }
        
        
        
        return ligne;
    }
    /**
     * permet de generer un fichier aui contient toutes les informations liees au world
     * @param WoE : objet de type World qui presente la aprtie jouee
     */
    public void sauvegarderPartier(World WoE){
        try { 
            String ligne = "";
            bufferedWriter = new BufferedWriter(new FileWriter(nomFichier));
            // sauvegarder la hauteur et la largeur
            bufferedWriter.write("Largeur "+ Integer.toString(WoE.getLargeur()));
            bufferedWriter.newLine();
            bufferedWriter.write("Hauteur "+ Integer.toString(WoE.getHauteur()));
            bufferedWriter.newLine();
            // sauvergarder les differents creatures (personnages et creatures)
            for(Creature c:WoE.getListCreatures()){
                ligne = getTexteSauvegarde(c);
                bufferedWriter.write(ligne);
                bufferedWriter.newLine();  
            }
            // sauvegarder Nuage Toxique :
            ligne = "NuageToxique ";
            ligne += WoE.getNuage().getPourcentageAttack()+" ";
            ligne += WoE.getNuage().getPourcentagePara()+" ";
            ligne += WoE.getNuage().getPtPara()+" ";
            ligne += WoE.getNuage().getCentre().getX()+" ";
            ligne += WoE.getNuage().getCentre().getY()+" ";
            ligne += "10 "; // rayon de la nuage
            bufferedWriter.write(ligne);
            bufferedWriter.newLine();
            // Sauvegarde des potions :
            for(Potion p:WoE.getListPotions()){
                ligne = getTexteSauvegarde(p);
                bufferedWriter.write(ligne);
                bufferedWriter.newLine();
            }
            // Sauvegarder joueur :
            ligne = "Joueur ";
            if (WoE.getJoueur().getPerso() instanceof Archer){
                ligne += "Archer ";
            } else if (WoE.getJoueur().getPerso() instanceof Guerrier){
                ligne += "Guerrier ";
            } else if (WoE.getJoueur().getPerso() instanceof Mage){
                ligne += "Mage ";
            } else if (WoE.getJoueur().getPerso() instanceof Paysan){
                ligne += "Paysan ";
            }
            ligne += WoE.getJoueur().getPerso().getNom() + " ";
            ligne += WoE.getJoueur().getPerso().getPtVie() + " ";
            ligne += WoE.getJoueur().getPerso().getPtMana() + " ";
            ligne += WoE.getJoueur().getPerso().getPourcentageAtt() + " ";
            ligne += WoE.getJoueur().getPerso().getPourcentagePar() + " ";
            ligne += WoE.getJoueur().getPerso().getPourcentageMag() + " ";
            ligne += WoE.getJoueur().getPerso().getPourcentageResistMag() + " ";
            ligne += WoE.getJoueur().getPerso().getDegAtt() + " ";
            ligne += WoE.getJoueur().getPerso().getDegMag() + " ";
            ligne += WoE.getJoueur().getPerso().getDistAttMax() + " ";
            ligne += WoE.getJoueur().getPerso().getPtPar() + " ";
            ligne += WoE.getJoueur().getPerso().getPos().getX() + " ";
            ligne += WoE.getJoueur().getPerso().getPos().getY() + " ";
            bufferedWriter.write(ligne);            
            
        } 
        catch (FileNotFoundException ex) {
          ex.printStackTrace();
        } 
        catch (IOException ex) {
          ex.printStackTrace();
        }
        finally {
          try {
            if (bufferedWriter != null) {
              bufferedWriter.flush();
              bufferedWriter.close();
            }
          }
          catch (IOException ex) {
            ex.printStackTrace();
          }
        }
        
    }
    // Definitions des getters et setters
    public String getNomFichier() {
        return nomFichier;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setNomFichier(String nomFichier) {
        this.nomFichier = nomFichier;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }
    
}
