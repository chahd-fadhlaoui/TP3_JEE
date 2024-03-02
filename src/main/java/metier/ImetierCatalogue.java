package metier;

import java.util.List;

public interface ImetierCatalogue {
    List<Voyage> getVoyagesParMotCle(String mc);
    void addVoyage(Voyage v);
}
