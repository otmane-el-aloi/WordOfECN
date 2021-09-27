package org.centrale.projet.objet;

/**
 *
 * @author Groupe 24
 */
public class TestSeance3 {

    public static void main(String[] args) {
        // Diapo 9
        /*
        int nbMaximalSouhaite = 100;
        World WoE = new World(nbMaximalSouhaite);
         */
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
        /*
        WoE.creeMondealea();
        
        int nbElement = WoE.getListCreatures().size();
        for (int i=0;i<nbElement-1; i++){
            WoE.getListCreatures().get(i).affiche();
            }
         */
 /*
        //Diapo 18
        int nbMaximalSouhaite[] = {100, 1000, 10000, 100000, 1000000};
        for (int i = 0; i<nbMaximalSouhaite.length; i++){
            long debutN = System.nanoTime();
            World WoE = new World(nbMaximalSouhaite[i]);
            WoE.creeMondealea();
            int tailleConteneur = WoE.getListCreatures().size();
            Point2D barycentre = new Point2D(0, 0);
            for (int j=0; j<tailleConteneur-1; j++){
                barycentre.setX(barycentre.getX()+WoE.getListCreatures().get(j).getPos().getX());
                barycentre.setY(barycentre.getY()+WoE.getListCreatures().get(j).getPos().getY());
            }
            barycentre.setX(barycentre.getX()/tailleConteneur);
            barycentre.setY(barycentre.getY()/tailleConteneur);
            long finN = System.nanoTime();
            System.out.print("le barycentre des creatures pour N="+i +"est:");
            barycentre.affiche();
            System.out.print("Temps ecoule en ns pour est:"+(finN-debutN) + "\n");
        }
         */
 /*
        //Diapo 18 iterateur
        int nbMaximalSouhaite[] = {100, 1000, 10000, 100000, 1000000};
        for (int i = 0; i<nbMaximalSouhaite.length; i++){
            long debutN = System.nanoTime();
            World WoE = new World(nbMaximalSouhaite[i]);
            WoE.creeMondealea();
            int tailleConteneur = WoE.getListCreatures().size();
            Point2D barycentre = new Point2D(0, 0);
            for (Creature C: WoE.getListCreatures()){
                barycentre.setX(barycentre.getX()+C.getPos().getX());
                barycentre.setY(barycentre.getY()+C.getPos().getY());
            }
            barycentre.setX(barycentre.getX()/tailleConteneur);
            barycentre.setY(barycentre.getY()/tailleConteneur);
            long finN = System.nanoTime();
            System.out.print("le barycentre des creatures pour N="+i +"est:");
            barycentre.affiche();
            System.out.print("Temps ecoule en ns pour est:"+(finN-debutN) + "\n");
        }
         */
        //Diapo 21
        int nbMaximalSouhaite = 10;
        World WoE = new World(nbMaximalSouhaite);
        WoE.creeMondealea();
        for (int i = 0; i < nbMaximalSouhaite - 1; i++) {
            WoE.getListCreatures().get(i).affiche();
        }

    }
}
