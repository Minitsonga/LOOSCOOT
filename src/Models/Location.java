package Models;

import java.io.Serializable;
import java.time.LocalDate;

public class Location implements Serializable {

    public LocalDate dateDebut;
    public LocalDate dateFin;

    public Location(LocalDate deb, LocalDate fin) {
        dateDebut = deb;
        dateFin = fin;


    }



}