package web;

import java.util.ArrayList;
import java.util.List;
import metier.Voyage; // Ensure you import the Voyage class

public class VoyageModele {
    private String motCle;
    List<Voyage> voyages = new ArrayList<>(); // Change to a list of Voyage objects

    public String getMotCle() {
        return motCle;
    }

    public void setMotCle(String motCle) {
        this.motCle = motCle;
    }

    public List<Voyage> getVoyages() { // Return a list of Voyage objects
        return voyages;
    }

    public void setVoyages(List<Voyage> voyages) { // Accept a list of Voyage objects
        this.voyages = voyages;
    }
}
