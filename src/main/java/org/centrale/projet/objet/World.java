/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.centrale.projet.objet;
import java.time.format.DateTimeFormatter; 
import java.time.LocalDateTime;
import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe World : definie les Protagonistes et gére le monde du jeu
 * @author Groupe 24
 */
public class World {
    // Dimension du monde
    private int largeur = 10;
    private int hauteur = 10;
    // nombreMaxCreature
    private int  NBMAXCREATURES;
    // nombre de potions
    final static int NBPOTION = 5;
    // nombre de tour de jeu
    final static int NBTOUR = 5;
    // nombre de nourritures dans le monde :
    final static int NBNOURRITURE = 50;
    // Notre joeueur
    private Joueur joueur;
    // Liste des creatures
    private ArrayList<Creature> listCreatures;
    // Liste des objets
    private ArrayList<Objet> listObjets;
    // Liste des potions
    private ArrayList<Potion> listPotions;
    // Liste des nourritures dans le monde
    private ArrayList<Nourriture> nourrituresMonde;
    // Nuage Toxique
    private NuageToxique nuage;

    // Nombres des creatures crées
    private int nbPaysan;
    private int nbArcher;
    private int nbGuerrier;
    private int nbLapin;
    private int nbLoup;

    
    
    // Définition des constructeurs
    /**
     * Constructeurs avec un parametres 
     * 
     * @param nbCreatures : nombre de creature dans le monde
     */
    public World(int nbCreatures) {
        this.joueur = new Joueur();
        this.joueur.participe();
        this.NBMAXCREATURES = nbCreatures;
        this.nbPaysan = 0;
        this.nbArcher = 0;
        this.nbGuerrier = 0;
        this.nbLapin = 0;
        this.nbLoup = 0;
        Random generateurRandom = new Random();
        listCreatures = new ArrayList<>();
        listObjets = new ArrayList<>();
        // creation des creatures
        for (int i=0; i<this.NBMAXCREATURES;i++){
            int choix = generateurRandom.nextInt(6);
            switch(choix){
                case 0:
                    Archer archer = new Archer();
                    archer.setNom("Archer");
                    this.listCreatures.add(archer);
                    this.nbArcher +=1;
                    break;

                case 1:
                    Paysan paysan = new Paysan();
                    paysan.setNom("Paysan");
                    this.listCreatures.add(paysan); 
                    this.nbPaysan +=1;
                    break;

                case 2:
                    Lapin lapin = new Lapin();
                    this.listCreatures.add(lapin); 
                    this.nbLapin +=1;
                    break;

                case 3:
                    Guerrier guerrier = new Guerrier();
                    guerrier.setNom("Guerrier");
                    this.listCreatures.add(guerrier);
                    this.nbGuerrier +=1;
                    break;
              
                case 4:
                    Loup loup = new Loup();
                    this.listCreatures.add(loup);
                    break;
                    
                case 5:
                    Mage mage = new Mage();
                    this.listCreatures.add(mage);
                    break;
                
                default :
                    System.out.println("choix impossible");
                    
            }
        }
        // Creation des potions :
        Random posAlea = new Random();
        listPotions = new ArrayList<>();
        for(int j=0;j<NBPOTION;j++){
            int choixPotion = generateurRandom.nextInt(2);
            if (choixPotion==0){
                listPotions.add(new Soin());
            } else {
                listPotions.add(new Mana());
            }
        }
        // initialisation des positions des potions
        for (Potion p:listPotions){
            Point2D pos = new Point2D(posAlea.nextInt(largeur), posAlea.nextInt(hauteur));
            p.setPos(pos);
        }
        // Creation des nourritures
        nourrituresMonde = new ArrayList<>();
        for(int h=0;h<NBNOURRITURE;h++){
            nourrituresMonde.add(new Nourriture());
        }
        // initialisation des positions des nourritures :
        for (Nourriture n:nourrituresMonde){
            Point2D pos = new Point2D(posAlea.nextInt(largeur), posAlea.nextInt(hauteur));
            n.setPosNourriture(pos);
        }
        // nuage Toxique :
        nuage = new NuageToxique();
        
        

    }
    /**
     * Constructeur de recopie
     * 
     * @param w :objet de type World
     */
    public World(World w){
         this.NBMAXCREATURES = w.NBMAXCREATURES;
         this.NBMAXCREATURES = w.NBMAXCREATURES;
         this.listObjets = w.listObjets;
         this.nbPaysan = w.nbPaysan;
         this.nbArcher = w.nbArcher;
         this.nbGuerrier = w.nbGuerrier;
         this.nbLapin = w.nbLapin;
         this.nbLoup = w.nbLoup;
         this.joueur = w.getJoueur();
         this.listCreatures = w.listCreatures;
         this.listPotions = w.listPotions;
         this.listObjets = w.listObjets;
         this.nourrituresMonde = w.nourrituresMonde;
         this.largeur = w.largeur;
         this.hauteur = w.hauteur;
    }
    
    /**
     * Constructeurs par defaut 
     */
    public World(){
        this.listCreatures = new ArrayList<>();
        this.listObjets = new ArrayList<>();
        this.listPotions = new ArrayList<>();
        this.nbPaysan = 0;
        this.nbArcher = 0;
        this.nbGuerrier = 0;
        this.nbLapin = 0;
        this.nbLoup = 0;
        this.joueur = new Joueur();
        this.nourrituresMonde = new ArrayList<>();
        this.hauteur = 50;
        this.largeur = 50;
    }
    
    // Définition des méthodes
    /**
     *  Cette fonction verifie si une position est valide
     * i.e distance supérieur à 3
     * @param pos : position
     * @return valeur vrai ou faux
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
     * Calcul la position d'un protagoniste en tenant compte des conditions
     * de superposition et de distance minimal égale à 4
     * 
     * @return 
     */
    public Point2D computeInitialPosSup3(){
        Random generateurRandom = new Random();
        boolean notValide = true;
        // position du premier protagoniste
        Point2D pP = new Point2D(generateurRandom.nextInt(largeur),  
                generateurRandom.nextInt(hauteur));
        while (notValide == true){
            if (this.isValidPos(pP)==false){
                notValide = true;
                pP.setX(generateurRandom.nextInt(largeur));
                pP.setY(generateurRandom.nextInt(hauteur));
            }
            else {
                notValide = false;
            }
        }
        return pP;
    }   
    
    /**
     * Calcul la position d'un protagoniste en tenant compte de la condition
     * de superposition seulement
     * 
     * @return : Position
     */
    public Point2D computeInitialPos(){
        Random generateurRandom = new Random();
        boolean surposition = true;
        // position du premier protagoniste
        Point2D pP = new Point2D(generateurRandom.nextInt(largeur),  
                generateurRandom.nextInt(hauteur));
        while (surposition == true)
         for (int i=0; i<this.listCreatures.size()-1; i++){
            double distance;
            distance = Point2D.distance(pP, this.listCreatures.get(i).getPos());
            if (distance == 0){
                surposition = true;
                pP.setX(generateurRandom.nextInt(largeur));
                pP.setY(generateurRandom.nextInt(hauteur));
                break;
            }
            else {
                surposition = false;
            }
        }
        return pP;
    }
    /**
     * Verifie si une position est remplie par une creature
     * @param list : liste des creatures
     * @param pos : position a tester
     * @return 
     */
    public boolean caseRemplie(ArrayList<Creature> list, Point2D pos){
        boolean rempli = false;
        for(Creature c:list){
            if (Point2D.distance(c.getPos(), pos) == 0){
                rempli = true;
                break;
            }
        }
        return rempli;
    }
    

    
    /**
     * creeMondealea permet d'initialiser les positions des creatures, des potions et des nourriures :
     */
    public void creeMondealea() {
        Random posAlea = new Random();
        // initialisation des positions des creatures: notre monde a les limites suivantes : [0, 100]
        for (Creature c:this.listCreatures){
                // Pour initialiser aléatoirement les protagonistes avec condition de distance >= 3
                c.setPos(computeInitialPosSup3());
        }
    }
   /**
    * permet de creer le joueur humain
    */
    public void creationJoueur() {
        this.joueur.getPerso().setPos(computeInitialPosSup3());
    }
    
    
    /**
     * permet de simuler le jeu
     * @throws NumberFormatException : exception
     */
    public void tourDeJeu() throws NumberFormatException{
        // Listes des indices des potions a supprimer :
        ArrayList<Integer> removedPotion = new ArrayList<>();

        // Debut de jeu :
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<NBTOUR;i++){
            System.out.println("Debut de la Tour "+i);
            // Traitement des creatures :
            for (Creature c:listCreatures){
                // Pour les personnages :
                if (c instanceof Personnage){
                    // Ajouter les nourritures rencontrees par les personnages :
                    for(Nourriture n:nourrituresMonde){
                        if (Point2D.distance(c.getPos(), n.getPosNourriture()) == 0){
                            ((Personnage) c).getListNourriture().add(n);
                        }
                    }
                    // Appliquer l'effet des nourritures :
                    ((Personnage) c).consommerNouriture();
                }
                // Appliquer l'effet des potions :
                for(Potion p:listPotions){
                    if(Point2D.distance(c.getPos(), p.getPos()) == 0){
                        if (p instanceof Soin){
                            c.setPtVie(c.getPtVie()+((Soin) p).getValPtVie());
                            removedPotion.add(listPotions.indexOf(p));

                        } else {
                            if (c instanceof Personnage){
                                ((Personnage) c).setPtMana(((Personnage) c).getPtMana() + ((Mana) p).getValMana());
                                removedPotion.add(listPotions.indexOf(p));
                            }
                        }
                    }
                }
                // Appliquer l'effet du nuage toxique:
                nuage.combattre(c);
            }
            // Traitement du joueuer :
            // Consommation des potions par le joueur :
            for(Potion p:listPotions){
                if(Point2D.distance(this.joueur.getPerso().getPos(), p.getPos()) == 0){
                    if(p instanceof Soin){
                        this.joueur.getPerso().setPtVie(((Soin) p).getValPtVie() + this.joueur.getPerso().getPtVie());
                        removedPotion.add(listPotions.indexOf(p));
                    } else {
                        this.joueur.getPerso().setPtMana(((Mana) p).getValMana() + this.joueur.getPerso().getPtMana());
                        removedPotion.add(listPotions.indexOf(p));
                    }
                }  
            }
            // Appliquer l'effet du nuage sur le joueur :
            nuage.combattre(this.joueur.getPerso());
            
            // Choix du joueur :
            System.out.println("Entrer 0 si vous voulez se deplacer ou 1 si vous voulez combattre");
            String choix = sc.next();
            int choixInt = Integer.parseInt(choix);
            if (choixInt==0){
                System.out.println("Debut de deplacement");
                // Deplacement :
                System.out.println("Deplacement par clavier: w=Haut, d=Droit, s=Bas, a=Gauche");
                boolean verf = true;
                while(verf){
                    String direction = sc.next();
                    switch(direction){
                        case "w":
                            if (caseRemplie(listCreatures, new Point2D(joueur.getPerso().getPos().getX()-1, joueur.getPerso().getPos().getY()))){
                                System.out.println("Case remplie, essayer d'autres directions");  
                            } else {
                                joueur.getPerso().getPos().setX(joueur.getPerso().getPos().getX()-1);
                                verf = false;
                            }
                            break;
                        case "d":
                            if (caseRemplie(listCreatures, new Point2D(joueur.getPerso().getPos().getX(), joueur.getPerso().getPos().getY()+1))){
                                System.out.println("Case remplie, essayer d'autres directions");  
                            } else {
                                joueur.getPerso().getPos().setY(joueur.getPerso().getPos().getY()+1);
                                
                                verf = false;
                            }
                            break;
                        case "s":
                            if (caseRemplie(listCreatures, new Point2D(joueur.getPerso().getPos().getX()+1, joueur.getPerso().getPos().getY()))){
                                System.out.println("Case remplie, essayer d'autres directions");  
                            } else {
                                joueur.getPerso().getPos().setX(joueur.getPerso().getPos().getX()+1);
                                verf = false;
                            }
                            break;
                        case "a":
                            if (caseRemplie(listCreatures, new Point2D(joueur.getPerso().getPos().getX(), joueur.getPerso().getPos().getY()-1))){
                                System.out.println("Case remplie, essayer d'autres directions");  
                            } else {
                                joueur.getPerso().getPos().setY(joueur.getPerso().getPos().getY()-1);
                                verf = false;
                            }
                            break;
                        default :
                            System.out.println("direction introuvable, reessayer");
                            break;
                            
                    }
                }
                System.out.println("Position du joueur : ");
                this.joueur.getPerso().getPos().affiche();                                
            } else {
                // Combat joueuer avec les trois types
                System.out.println("Debut de combat");
                if (this.joueur.getPerso() instanceof Paysan){
                    System.out.println("Paysan ne peut pas combattre");
                } else {
                    for(Creature m: this.listCreatures){
                        if (m instanceof Loup){
                            if (this.joueur.getPerso() instanceof Archer){
                                Archer a = (Archer)this.joueur.getPerso();
                                a.combattre(m);
                            } else {
                                if (this.joueur.getPerso() instanceof Guerrier){
                                    Guerrier g = (Guerrier)this.joueur.getPerso();
                                    g.combattre(m);
                                } else {
                                    if (this.joueur.getPerso() instanceof Mage){
                                        Mage h = (Mage)this.joueur.getPerso();
                                        h.combattre(m);
                                    }
                                }
                            }   
                        }
                    }
                }
            }
            // Sauvegarder la partie :
            System.out.println("Voulez-vous sauvegarder cette partie ? Oui = 1 ou Non = 0");
            String choixSauv = sc.next();
            boolean verfSauv = true;
            while (verfSauv){
                if (choixSauv.equals("1")){
                    SauvegardePartie partie;
                    System.out.println("Voulez-vous choisir un nom de la partie ? Oui = 1 ou Non = 0");
                    String choixNom = sc.next();
                    boolean verfChoixNom = true;
                    while (verfChoixNom){
                        if (choixNom.equals("1")){
                            System.out.println("Entrez un nom a votre partie");
                            String nomFichier = sc.next();
                            partie = new SauvegardePartie(nomFichier+".txt");
                            partie.sauvegarderPartier(this);
                            System.out.println("Partie sauvegardee dans le ficheir : "+nomFichier+".txt");
                            verfChoixNom = false;
                        } else if (choixNom.equals("0")){
                            LocalDateTime myDateObj = LocalDateTime.now();
                            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
                            String formattedDate = myDateObj.format(myFormatObj);
                            System.out.println("La partie est sauvegardee dans le fichier : "+"Session"+"WoE-"+formattedDate+".txt");
                            partie = new SauvegardePartie("Session"+"WoE-"+formattedDate+".txt");
                            partie.sauvegarderPartier(this);
                            verfChoixNom = false;
                        } else {
                            System.out.println("Choix incorrectre, reessayer avec 0 ou 1");
                            choixNom = sc.next();
                        }
                    }
                    verfSauv = false;
                } else if (choixSauv.equals("0")){
                    verfSauv = false;
                } else {
                    System.out.println("Choix incorrectre, reessayer avec 0 ou 1");
                    choixSauv = sc.next();
                }
            }
            // Mise A jour du jeu :
            // Supprimer les potions consommees :
            listPotions.removeAll(removedPotion);
            removedPotion = new ArrayList<>();
            // mise a jour des nourritures/personnages :
            ArrayList<Integer> indiceNourritureFini = new ArrayList<>();
            for (Creature c:listCreatures){
                // traitement des nourritures :
                if (c instanceof Personnage){
                    for(Nourriture n:((Personnage) c).getListNourriture()){
                        n.setNbTour(n.getNbTour()-1);
                        if (n.getNbTour() == 0){
                            ((Personnage) c).deconsommerNourriture(((Personnage) c).getListNourriture().indexOf(n));
                            indiceNourritureFini.add(((Personnage) c).getListNourriture().indexOf(n));
                        }
                    }
                    // supprimer nourritures epuisees
                    ((Personnage) c).getListNourriture().removeAll(indiceNourritureFini);
                }
                // deplacement des creatures :
                c.deplace(largeur, hauteur);
            }
            // deplacement du nuage toxique :
            nuage.deplace(largeur, hauteur);
            }
        System.out.println("Fin de la partie");
        }
    
    /**
     * affiche les creatures, le joueur humain et les potions qui existent dans notre world
     */
    public void afficheWorld(){
        // Affichages des caracteristiques des Creatures :
        System.out.println("-------------Caracteristiques du jeu-------------");
        // Affichages des dimensions du monde :
        System.out.println("Largeur "+largeur);
        System.out.println("Hauteur "+hauteur);
        // Affichage des creatures
        for(Creature c:listCreatures){
            if (c instanceof Personnage){
                if (c instanceof Archer){
                    System.out.print("Archer ");
                } else if (c instanceof Guerrier){
                    System.out.print("Guerrier ");
                } else if (c instanceof Mage){
                    System.out.print("Mage ");
                } else {
                    System.out.print("Paysan ");
                }
                System.out.print(((Personnage) c).getNom() + " ");
                System.out.print(((Personnage) c).getPtVie() + " ");
                System.out.print(((Personnage) c).getPtMana() + " ");
                System.out.print(((Personnage) c).getPourcentageAtt() + " ");
                System.out.print(((Personnage) c).getPourcentagePar() + " ");
                System.out.print(((Personnage) c).getPourcentageMag() + " ");
                System.out.print(((Personnage) c).getPourcentageResistMag() + " ");
                System.out.print(((Personnage) c).getDegAtt() + " ");
                System.out.print(((Personnage) c).getDegMag() + " ");
                System.out.print(((Personnage) c).getDistAttMax() + " ");
                System.out.print(((Personnage) c).getPtPar() + " ");
                System.out.print(((Personnage) c).getPos().getX() + " ");
                System.out.println(((Personnage) c).getPos().getY());
            } else if (c instanceof Monstre){
                if (c instanceof Loup){
                    System.out.print("Loup ");
                 
                } else {
                    System.out.print("Lapin ");
                }
                System.out.print(((Monstre) c).getPtVie() + " ");
                System.out.print(((Monstre) c).getPourcentageAtt() + " ");
                System.out.print(((Monstre) c).getPourcentagePar() + " ");
                System.out.print(((Monstre) c).getDegAtt() + " ");
                System.out.print(((Monstre) c).getPtPar() + " ");
                System.out.print(((Monstre) c).getPos().getX() + " ");
                System.out.println(((Monstre) c).getPos().getY() + " ");
            }
        }
        // Affichage d'un nuage toxique :
        System.out.print("NuageToxique ");
        System.out.print(nuage.getPourcentageAttack()+" ");
        System.out.print(nuage.getPourcentagePara() +" ");
        System.out.print(nuage.getPtPara()+" ");
        System.out.print(nuage.getCentre().getX()+" ");
        System.out.print(nuage.getCentre().getY()+" ");
        System.out.println(nuage.getRayon()+" ");
        
        // Affichages des potions:
        for(Potion p:listPotions){
            if (p instanceof Soin){
                System.out.print("Soin ");
                System.out.print(((Soin) p).getValPtVie() + " ");
                System.out.print(((Soin) p).getPos().getX() + " ");
                System.out.println(((Soin) p).getPos().getY());
                
            } else {
                System.out.print("Mana ");
                System.out.print(((Mana) p).getValMana() + " ");
                System.out.print(((Mana) p).getPos().getX() + " ");
                System.out.println(((Mana) p).getPos().getY());
            }
        }
        
        // Affichages des caracteristiques du joueur :
        System.out.print("Joueur ");
        System.out.print(this.joueur.getPerso().getNom() + " ");
        System.out.print(this.joueur.getPerso().getPtVie() + " ");
        System.out.print(this.joueur.getPerso().getPtMana() + " ");
        System.out.print(this.joueur.getPerso().getPourcentageAtt() + " ");
        System.out.print(this.joueur.getPerso().getPourcentagePar() + " ");
        System.out.print(this.joueur.getPerso().getPourcentageMag() + " ");
        System.out.print(this.joueur.getPerso().getPourcentageResistMag() + " ");
        System.out.print(this.joueur.getPerso().getDegAtt() + " ");
        System.out.print(this.joueur.getPerso().getDegMag() + " ");
        System.out.print(this.joueur.getPerso().getDistAttMax() + " ");
        System.out.print(this.joueur.getPerso().getPtPar() + " ");
        System.out.print(this.joueur.getPerso().getPtPar() + " ");
        System.out.print(this.joueur.getPerso().getPos().getX() + " ");
        System.out.println(this.joueur.getPerso().getPos().getY()); 
    }
    
    public void afficheInterface(){
        // matrice du monde
        System.out.println("-------------Interface graphique-------------");
        String[][] matrix = new String[largeur][hauteur];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                matrix[i][j] = "----------";
            }
        }
        //System.out.println("Positions des creatures");
        // affichage des creatures
        for (Creature c : this.listCreatures){
            if (c instanceof Monstre){
                matrix[c.getPos().getX()][c.getPos().getY()] = " Monster  ";
            } else {
                if (c instanceof Archer) {
                    matrix[c.getPos().getX()][c.getPos().getY()] = "  Archer  ";
                } else if (c instanceof Guerrier){
                    matrix[c.getPos().getX()][c.getPos().getY()] = " Guerrier ";
                } else if (c instanceof Mage){
                    matrix[c.getPos().getX()][c.getPos().getY()] = "   Mage   ";
                } else if (c instanceof Paysan){
                    matrix[c.getPos().getX()][c.getPos().getY()] = "  Paysan  ";
                }
                
            }
        }
        //System.out.println("Positions des potions");
        // affichage des potions
        for (Potion p : this.listPotions){
            if (p instanceof Soin){
                if (matrix[p.getPos().getX()][p.getPos().getY()] == "----------"){
                    matrix[p.getPos().getX()][p.getPos().getY()] = "   Soin   ";
                } else {
                    matrix[p.getPos().getX()][p.getPos().getY()] += "&&   Soin   ";
                }
            } else {
                if (matrix[p.getPos().getX()][p.getPos().getY()] == "----------"){
                    matrix[p.getPos().getX()][p.getPos().getY()] = "   Mana   ";
                } else {
                    matrix[p.getPos().getX()][p.getPos().getY()] += "&&   Mana   ";
                }
                
            }
        }
        // affichage des nourritures :
        for (Nourriture n : this.nourrituresMonde){
            matrix[n.getPosNourriture().getX()][n.getPosNourriture().getY()] = "Nourriture";
        }
        // affichage du joueur
        String NomJoueur = this.joueur.getPerso().getNom();
        while(NomJoueur.length() < 10){
            NomJoueur += " ";
        }
        matrix[this.joueur.getPerso().getPos().getX()][this.joueur.getPerso().getPos().getY()] = NomJoueur;
        
        System.out.println("Affichage du monde WoE");
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+"||");
            }
            System.out.println("||");
        }
    }

    // Getters & Setters
    public int getNbMaxCreatures() {
        return NBMAXCREATURES;
    }

    public void setNbMaxCreatures(int nbMaxCreatures) {
        this.NBMAXCREATURES = nbMaxCreatures;
    }

    public ArrayList<Creature> getListCreatures() {
        return listCreatures;
    }

    public ArrayList<Objet> getListObjets() {
        return listObjets;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

    public int getNbPaysan() {
        return nbPaysan;
    }

    public int getNbArcher() {
        return nbArcher;
    }

    public int getNbGuerrier() {
        return nbGuerrier;
    }

    public int getNbLapin() {
        return nbLapin;
    }

    public int getNbLoup() {
        return nbLoup;
    }

    public void setListCreatures(ArrayList<Creature> listCreatures) {
        this.listCreatures = listCreatures;
    }

    public void setListObjets(ArrayList<Objet> listObjets) {
        this.listObjets = listObjets;
    }

    public void setNbPaysan(int nbPaysan) {
        this.nbPaysan = nbPaysan;
    }

    public void setNbArcher(int nbArcher) {
        this.nbArcher = nbArcher;
    }

    public void setNbGuerrier(int nbGuerrier) {
        this.nbGuerrier = nbGuerrier;
    }

    public void setNbLapin(int nbLapin) {
        this.nbLapin = nbLapin;
    }

    public void setNbLoup(int nbLoup) {
        this.nbLoup = nbLoup;
    }

    public static int getNbPotion() {
        return NBPOTION;
    }

    public ArrayList<Potion> getListPotions() {
        return listPotions;
    }

    public void setListPotions(ArrayList<Potion> listPotions) {
        this.listPotions = listPotions;
    }

    public int getNBMAXCREATURES() {
        return NBMAXCREATURES;
    }

    public static int getNBPOTION() {
        return NBPOTION;
    }

    public static int getNBTOUR() {
        return NBTOUR;
    }

    public static int getNBNOURRITURE() {
        return NBNOURRITURE;
    }

    public ArrayList<Nourriture> getNourrituresMonde() {
        return nourrituresMonde;
    }

    public NuageToxique getNuage() {
        return nuage;
    }

    public void setNBMAXCREATURES(int NBMAXCREATURES) {
        this.NBMAXCREATURES = NBMAXCREATURES;
    }

    public void setNourrituresMonde(ArrayList<Nourriture> nourrituresMonde) {
        this.nourrituresMonde = nourrituresMonde;
    }

    public void setNuage(NuageToxique nuage) {
        this.nuage = nuage;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }

    public void setHauteur(int hauteur) {
        this.hauteur = hauteur;
    }
    
    
}
    
   
  
