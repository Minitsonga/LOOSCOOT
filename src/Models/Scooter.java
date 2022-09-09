package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Vector;

public class Scooter implements Serializable {

    public int id;
    public int nbKm;
    public Vector<Reservation> listReservation = new Vector<Reservation>();
    public Model model;

    public Scooter(int numId, int kilometers, Model model) {

        id = numId;
        nbKm = kilometers;
        this.model = model;


    }

    //TODO Verifier si le client qui veut rendre le scooter est bien le bon (soit nouvelle fonction/ soit ajouter check client dans notReserved)
    // Check aussi avant de louer si Client a le bon permis (Si il a le A c'est bon bous tous)

    public boolean isReserved(LocalDate reqDate, LocalDate endDate) {
        if (!listReservation.isEmpty()) {
            for (Reservation reservation : listReservation) {

                if (reqDate.isEqual(reservation.location.dateDebut) || endDate.isEqual(reservation.location.dateFin)) {
                    return true;
                } else if ((reqDate.isBefore(reservation.location.dateDebut) && endDate.isAfter(reservation.location.dateDebut)) || (reqDate.isBefore(reservation.location.dateFin) && endDate.isAfter(reservation.location.dateFin)) || (reqDate.isAfter(reservation.location.dateDebut) && endDate.isBefore(reservation.location.dateFin))) {
                    return true;
                }

            }
        }
        return false;

    }


    public void addReservation(Reservation reserv) {
        listReservation.add(reserv);
    }

    public Reservation getReservation(LocalDate reqDate, LocalDate endDate, Client c) {
        if (!listReservation.isEmpty()) {
            for (Reservation reservation : listReservation) {

                if (reservation.client.equals(c) && ((reqDate.isEqual(reservation.location.dateDebut) || endDate.isEqual(reservation.location.dateFin)))) {
                    return reservation;
                } else if (reservation.client.equals(c) && ((reqDate.isBefore(reservation.location.dateDebut) && endDate.isAfter(reservation.location.dateDebut)) || (reqDate.isBefore(reservation.location.dateFin) && endDate.isAfter(reservation.location.dateFin)) || (reqDate.isAfter(reservation.location.dateDebut) && endDate.isBefore(reservation.location.dateFin)))) {
                    return reservation;
                }

            }
        }
        return null;
    }
}

