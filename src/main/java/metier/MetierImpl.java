package metier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MetierImpl implements ImetierCatalogue {

    @Override
    public List<Voyage> getVoyagesParMotCle(String mc) {
        List<Voyage> voyages = new ArrayList<>();
        Connection conn = SingletonConnection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from VOYAGES where NOM_VOYAGE LIKE ?");
            ps.setString(1, "%" + mc + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Voyage v = new Voyage();
                v.setIdVoyage(rs.getLong("ID_VOYAGE"));
                v.setNomVoyage(rs.getString("NOM_VOYAGE"));
                v.setPrix(rs.getDouble("PRIX"));
                voyages.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return voyages;
    }

    @Override
    public void addVoyage(Voyage v) {
        // TODO Auto-generated method stub
    }
}
