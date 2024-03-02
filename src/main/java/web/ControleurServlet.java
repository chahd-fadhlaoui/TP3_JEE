package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.ImetierCatalogue;
import metier.MetierImpl;
import metier.Voyage; // Import the Voyage class

@WebServlet(name = "cs", urlPatterns = {"/controleur"})
public class ControleurServlet extends HttpServlet {
    private ImetierCatalogue metier;

    @Override
    public void init() throws ServletException {
        metier = new MetierImpl(); // Make sure MetierImpl is updated to work with Voyages
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String mc = request.getParameter("motCle");
        VoyageModele mod = new VoyageModele(); // Use the updated VoyageModele
        mod.setMotCle(mc);
        List<Voyage> voyages = metier.getVoyagesParMotCle(mc); // Assuming getVoyagesParMotCle method is defined
        mod.setVoyages(voyages);
        request.setAttribute("modele", mod);
        request.getRequestDispatcher("VoyagesView.jsp").forward(request, response); // Forward to the updated JSP
    }
}
