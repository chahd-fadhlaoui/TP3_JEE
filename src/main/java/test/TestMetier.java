package test;

import java.util.List;

import metier.MetierImpl;
import metier.Voyage;

public class TestMetier {

    public static void main(String[] args) {
        MetierImpl metier = new MetierImpl();
        List<Voyage> voyages = metier.getVoyagesParMotCle("tunisie");
        for (Voyage v : voyages) {
            System.out.println(v.getNomVoyage());
        }
    }
}
