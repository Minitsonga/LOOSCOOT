package Models;

import java.io.Serializable;

public class Reservation implements Serializable {

    public Scooter scooter;
    public Location location;
    public Client client;

    public Reservation(Scooter scooterReserved, Location location, Client client) {

        scooter = scooterReserved;
        this.location = location;
        this.client = client;

    }

    public Location getLocation()
    {
        return location;
    }


}