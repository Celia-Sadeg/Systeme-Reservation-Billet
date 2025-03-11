package org.example;

import java.util.*;

public class ReservationManager {
    private static final List<String> DESTINATIONS = Arrays.asList(
            "Paris", "New York", "Tokyo", "Dubaï", "Londres", "Berlin", "Sydney", "Toronto"
    );
    private static final Random RANDOM = new Random();

    private Map<Integer, Reservation> reservations;
    private int nextId;

    public ReservationManager() {
        this.reservations = new HashMap<>();
        this.nextId = 1;
    }

    public int reserverBillet(String clientName, String destination, Date dateVoyage) {
        if (!DESTINATIONS.contains(destination)) {
            throw new IllegalArgumentException("Destination non disponible.");
        }
        Reservation reservation = new Reservation(nextId, clientName, destination, dateVoyage);
        reservations.put(nextId, reservation);
        return nextId++;
    }

    public void annulerReservation(int reservationId) {
        if (reservations.containsKey(reservationId)) {
            reservations.remove(reservationId);
            System.out.println("Réservation annulée avec succès.");
        } else {
            System.out.println("Réservation introuvable.");
        }
    }

    public void afficherReservations() {
        if (reservations.isEmpty()) {
            System.out.println("Aucune réservation.");
            return;
        }
        for (Reservation res : reservations.values()) {
            System.out.println(res);
        }
    }

    private static class Reservation {
        private int id;
        private String clientName;
        private String destination;
        private Date dateVoyage;
        private String billetCode;

        public Reservation(int id, String clientName, String destination, Date dateVoyage) {
            this.id = id;
            this.clientName = clientName;
            this.destination = destination;
            this.dateVoyage = dateVoyage;
            this.billetCode = genererBilletCode();
        }

        private String genererBilletCode() {
            return "BILLET-" + id + "-" + RANDOM.nextInt(9999);
        }

        @Override
        public String toString() {
            return "Réservation #" + id + " | Client: " + clientName +
                    " | Destination: " + destination + " | Date: " + dateVoyage +
                    " | Billet: " + billetCode;
        }
    }
}
