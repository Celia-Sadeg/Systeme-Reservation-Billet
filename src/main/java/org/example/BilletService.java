package org.example;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BilletService {
    private List<Billet> billets = new ArrayList<>();

    public BilletService() {
        billets.add(new Billet("Concert", 50.0, "2025-04-15", 10));
        billets.add(new Billet("Match de foot", 30.0, "2025-05-20", 8));
        billets.add(new Billet("Théâtre", 20.0, "2025-06-10", 5));
    }

    public List<Billet> getAllBillets() {
        return billets;
    }

    public Billet reserverBillet(String type, String nomUtilisateur) {
        for (Billet billet : billets) {
            if (billet.getType().equals(type) && billet.getQuantiteDisponible() > 0) {
                billet.setNomUtilisateur(nomUtilisateur);
                billet.decrementerQuantite();
                return billet;
            }
        }
        return null; // Si aucun billet disponible
    }
}
