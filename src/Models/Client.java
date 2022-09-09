package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Vector;

public class Client implements Serializable {

    public String lastName;
    public String firstName;
    public LocalDate birthDate;
    public Vector<Reservation> listReservation = new Vector<Reservation>();
    public Permis permis;

    public Client(String lstName, String frstName, LocalDate birth, boolean hasPermisA, boolean hasPermisA1, boolean hasPermisA2) {
        lastName = lstName;
        firstName = frstName;
        birthDate = birth;

        if (hasPermisA) {
            var r = (int) (Math.random() * (99999984) + 15);
            permis = new Permis(r, new PermisType("A"), this);
        } else if (hasPermisA1) {

            var r = (int) (Math.random() * (99999984) + 15);
            permis = new Permis(r, new PermisType("A1"), this);
        } else if (hasPermisA2) {

            var r = (int) (Math.random() * (99999984) + 15);
            permis = new Permis(r, new PermisType("A2"), this);
        }


    }

    public void addReservation(Reservation reserv) {
        listReservation.add(reserv);
    }

    public Permis getPermis()
    {
        return permis;
    }

}