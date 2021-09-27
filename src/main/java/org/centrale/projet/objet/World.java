package org.centrale.projet.objet;

import java.util.Random;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;

/**
 * Classe World : definie les Protagonistes et gère le monde du jeu
 *
 * @author Groupe 24
 */
public class World {

    /**
     * Dimension du monde
     */
    final static int DIMENSION = 50;
    /**
     * nombreMaxCreature
     */
    private int nbMaxCreatures;

    /**
     * Liste Array des creatures
     */
    //private ArrayList<Creature> listCreatures;
    // private ArrayList<Objet> listObjets;
    /**
     * Linked List de creatures
     */
    private LinkedList<Creature> listCreatures;
    private LinkedList<Objet> listObjets;

    /**
     * Nombres des creatures crées
     */
    public int nbPaysan;
    public int nbArcher;
    public int nbGuerrier;
    public int nbLapin;
    public int nbLoup;

    // Définition des constructeurs
    /**
     * Constructeurs
     *
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
        listCreatures = new LinkedList<>();
        listObjets = new LinkedList<>();
        for (int i = 0; i < this.nbMaxCreatures; i++) {
            int choix = generateurRandom.nextInt(5);
            switch (choix) {
                case 0:
                    Archer archer = new Archer();
                    this.listCreatures.add(archer);
                    this.nbArcher += 1;

                case 1:
                    Paysan paysan = new Paysan();
                    this.listCreatures.add(paysan);
                    this.nbPaysan += 1;

                case 2:
                    Lapin lapin = new Lapin();
                    this.listCreatures.add(lapin);
                    this.nbLapin += 1;

                case 3:
                    Guerrier guerrier = new Guerrier();
                    this.listCreatures.add(guerrier);
                    this.nbGuerrier += 1;

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
    public World(World w) {
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
     * Constructeurs par défault
     *
     */
    public World() {
        this.listCreatures = new LinkedList<>();
        this.listObjets = new LinkedList<>();
        this.nbPaysan = 0;
        this.nbArcher = 0;
        this.nbGuerrier = 0;
        this.nbLapin = 0;
        this.nbLoup = 0;
    }

    // Définition des méthodes
    /**
     * Cette fonction verifie si une position est valide i.e distance supérieur
     * à 3
     *
     * @param pos
     * @return boolean
     */
    public boolean isValidPos(Point2D pos) {
        int d = 3;
        for (Creature C : this.listCreatures) {
            if (Point2D.distance(C.getPos(), pos) < d) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calcul la position d'un protagoniste en tenant compte des conditions de
     * superposition et de distance minimal égale à 3
     *
     * @return pP Objet Point2D
     */
    public Point2D computeInitialPosSup3() {
        Random generateurRandom = new Random();
        boolean notValide = true;
        // position du premier protagoniste
        Point2D pP = new Point2D(generateurRandom.nextInt(World.DIMENSION),
                generateurRandom.nextInt(World.DIMENSION));
        while (notValide == true) {
            if (this.isValidPos(pP) == false) {
                notValide = true;
                pP.setX(generateurRandom.nextInt(World.DIMENSION));
                pP.setY(generateurRandom.nextInt(World.DIMENSION));
            } else {
                notValide = false;
            }
        }
        return pP;
    }

    /**
     * Calcul la position d'un protagoniste en tenant compte de la condition de
     * superposition seulement
     *
     * @return pP objet Point2D
     */
    public Point2D computeInitialPos() {
        Random generateurRandom = new Random();
        boolean surposition = true;
        // position du premier protagoniste
        Point2D pP = new Point2D(generateurRandom.nextInt(World.DIMENSION),
                generateurRandom.nextInt(World.DIMENSION));
        while (surposition == true) {
            for (int i = 0; i < this.listCreatures.size() - 1; i++) {
                double distance;
                distance = Point2D.distance(pP, this.listCreatures.get(i).getPos());
                if (distance == 0) {
                    surposition = true;
                    pP.setX(generateurRandom.nextInt(World.DIMENSION));
                    pP.setY(generateurRandom.nextInt(World.DIMENSION));
                    break;
                } else {
                    surposition = false;
                }
            }
        }
        return pP;
    }

    /**
     * creeMondealea permet d'initialiser les positions des creatures
     */
    public void creeMondealea() {
        // initialisation des positions : notre monde a les limites suivantes : [0, 100]
        for (int i = 0; i < this.listCreatures.size(); i++) {
            // Décommenter pour initialiser aléatoirement les protagonistes avec condition de superposition
            //this.listCreatures.get(i).setPos(computeInitialPos());
            // Pour initialiser aléatoirement les protagonistes avec condition de distance >= 3
            this.listCreatures.get(i).setPos(computeInitialPosSup3());
        }
    }

    // Getters & Setters
    public int getNbMaxCreatures() {
        return nbMaxCreatures;
    }

    public void setNbMaxCreatures(int nbMaxCreatures) {
        this.nbMaxCreatures = nbMaxCreatures;
    }

    public static int getDimension() {
        return DIMENSION;
    }

    public LinkedList<Creature> getListCreatures() {
        return listCreatures;
    }

    public LinkedList<Objet> getListObjets() {
        return listObjets;
    }

}
