package org.centrale.projet.objet;

import java.util.Random;

/**
 * classe Payson : sous-classe de Personnage
 *
 * @author Groupe 24
 */
public class Paysan extends Personnage {
    // Definition des constructeurs

    /**
     * Constructeur avec plusieurs parametres d'Archer
     *
     * @param nom Nom de l'Archer
     * @param ptV points vie
     * @param pA pourcentage attaque
     * @param pP pourcentage par?
     * @param pM pourcentage magie
     * @param rM pourcentage resistance magie
     * @param dA degats d'attaque
     * @param dM degats magie
     * @param distMax distance d'attaque maximal
     * @param pos position du personnage dans le monde
     * @param ptPar points de paries
     */
    public Paysan(String nom, int ptV, int pA, int pP, int pM, int rM, int dA, int dM, int distMax, Point2D pos, int ptPar) {
        super(nom, ptV, 0, pA, pP, pM, rM, dA, dM, distMax, pos, ptPar);
    }

    /**
     * Constructeur de recopie d'Archer à partir d'un objet Archer
     *
     * @param p objet Paysan
     */
    public Paysan(Paysan p) {
        super(p);

    }

    /**
     * Constructeur par defaut
     */
    public Paysan() {
        super();
    }

    @Override
    public void affiche() {
        System.out.println("Je suis un paysan!");
        super.affiche();
    }

    /**
     * Combat corps à corps
     *
     * @param c
     */
    public void combattre(Creature c) {
        double distance = Point2D.distance(this.getPos(), c.getPos());
        if (distance == 1) {
            Random rInt = new Random();
            if (rInt.nextInt(100) + 1 <= this.getPourcentageAtt()) {
                int damage = 0;
                if (rInt.nextInt(100) + 1 > this.getPourcentagePar()) {
                    damage = this.getDegAtt();
                } else {
                    Math.max(this.getDegAtt() - c.getPtPar(), 0);
                }
                c.setPtVie(c.getPtVie() - damage);
                System.out.println("Attaque réussi avec un dégat de: " + damage);
            } else {
                System.out.println("attaque ratée!");
            }
        } else {
            System.out.println(" Trop loin! Distance: " + distance);
        }
    }

}
