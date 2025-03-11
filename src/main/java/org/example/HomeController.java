package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final BilletService billetService;

    public HomeController(BilletService billetService) {
        this.billetService = billetService;
    }

    @GetMapping("/")
    public String accueil() {
        return "index";
    }

    @GetMapping("/billets")
    public String afficherBillets(Model model) {
        model.addAttribute("billets", billetService.getAllBillets());
        return "billets";
    }

    @GetMapping("/reservation")
    public String afficherReservation(Model model) {
        model.addAttribute("billets", billetService.getAllBillets());
        return "reservation";
    }

    @PostMapping("/reserver")
    public String reserverBillet(@RequestParam String type, Model model) {
        String nomUtilisateur = "Utilisateur_" + (int) (Math.random() * 1000); // Génère un nom aléatoire
        Billet billet = billetService.reserverBillet(type, nomUtilisateur);

        if (billet != null) {
            model.addAttribute("message", "Réservation réussie pour " + nomUtilisateur);
        } else {
            model.addAttribute("message", "Échec : plus de billets disponibles !");
        }

        model.addAttribute("billets", billetService.getAllBillets());
        return "reservation";
    }
}
