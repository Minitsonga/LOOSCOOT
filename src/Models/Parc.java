package Models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;


public class Parc implements Serializable {

    public static class Address implements Serializable {
        int number;
        String street;
        int postCode;
        String city;

        public Address(int num, String street, int code, String city) {
            number = num;
            this.street = street;
            postCode = code;
            this.city = city;

        }
    }

    public static String nameParc;
    public static Address address;
    public static Vector<Scooter> listScooter = new Vector<Scooter>();
    public static Vector<Client> listClients = new Vector<Client>();

    public enum ChoiceClient {location, retour, cancel;}

    public Parc(String name, Address a) {
        nameParc = name;
        address = a;

    }

    public Parc(String name, Address a, Vector<Scooter> listS, Vector<Client> listC) {
        nameParc = name;
        address = a;
        listScooter = listS;
        listClients = listC;
    }

    public void RegisterScooter(Scooter newScooter) {
        listScooter.add(newScooter);
    }

    public void RegisterClient(Client newClient) {
        listClients.add(newClient);
    }


    public String getNameParc() {
        return nameParc;
    }

    public Address getAddress() {
        return address;
    }


    public Vector<Scooter> getListScooter() {
        return listScooter;
    }

    public Vector<Client> getListClient() {
        return listClients;
    }

    public Vector<Scooter> getListDynamicScooter(ChoiceClient choice, LocalDate d1, LocalDate d2, Client client) {
        Vector<Scooter> list = new Vector<Scooter>();

        for (var el : listScooter) {

            if (choice == ChoiceClient.location) {
                //Check if the cur scooter has not been reserved.
                if (!el.isReserved(d1, d2)) {
                    //Check if the client has the right type of licence (permis) for this scooter
                    if (el.model.licenceType.type.equalsIgnoreCase(client.permis.type.type) || client.permis.type.type.equalsIgnoreCase(new PermisType("A").type) || client.permis.type.type.equalsIgnoreCase(new PermisType("A1").type) && el.model.licenceType.type.equalsIgnoreCase(new PermisType("A2").type)) {
                        //scooter not reserved and can be driven by the client
                        list.add(el);
                    }
                }
            } else if (choice == ChoiceClient.retour) {


                if (el.isReserved(d1, d2)) {
                    //Check if the cur scooter has a reservation and if it has started and if the date asked are the same as the ones in the scooter's reservation.
                    if (el.getReservation(d1, d2, client) != null && LocalDate.now().isAfter(el.getReservation(d1, d2, client).getLocation().dateDebut) && el.getReservation(d1, d2, client).getLocation().dateDebut.isEqual(d1) && el.getReservation(d1, d2, client).getLocation().dateFin.isEqual(d2)) {
                        //if reserved by same client
                        System.out.println("Liste scooter en location" + el.model.label);
                        list.add(el);
                    }


                }

            } else if (choice == ChoiceClient.cancel) {
                //Check if the cur scooter has a reservation, but it has not started yet and if the date asked are the same as the ones in the scooter's reservation..
                if (el.isReserved(d1, d2)) {
                    if (el.getReservation(d1, d2, client) != null && LocalDate.now().isBefore(el.getReservation(d1, d2, client).getLocation().dateDebut) && el.getReservation(d1, d2, client).getLocation().dateDebut.isEqual(d1) && el.getReservation(d1, d2, client).getLocation().dateFin.isEqual(d2)) {
                        //if reserved by same client
                        System.out.println("Liste scooter reserves " + el.model.label);
                        list.add(el);
                    }

                }
            }
        }

        return list;

    }


    public boolean location(Scooter el, LocalDate deb, LocalDate end, Client c) {

        if (!el.isReserved(deb, end)) {

            Location loca = new Location(deb, end);
            Reservation reserv = new Reservation(el, loca, c);

            el.addReservation(reserv);
            c.addReservation(reserv);
            System.out.print("Réservation effectué");

            return true;

        } else {
            return false;
        }
    }


    public boolean returnScooter(Scooter el, int km, LocalDate deb, LocalDate end, Client c) {

        Reservation current = el.getReservation(deb, end, c);
        if (!listScooter.contains(el)) {
            System.out.print("Ce scooter n'existe pas");
        } else {
            if (el.isReserved(deb, end) && current != null) {

                el.nbKm += km;

                el.listReservation.remove(current);
                c.listReservation.remove(current);
                return true;
            }
        }
        return false;
    }


    public Vector<Integer> parcSummary(LocalDate t1) {

        Vector<Integer> summary = new Vector<>();
        int nbLocation = 0;
        int nbDis = 0;
        int nbKil = 0;

        System.out.print(listScooter.size());


        for (Scooter el : listScooter) {

            if (el.isReserved(t1, t1)) {
                nbLocation++;
            } else {
                nbDis++;
            }
            nbKil += el.nbKm;
        }

        summary.add(nbLocation);
        summary.add(nbDis);
        summary.add(nbKil);

        return summary;
    }


}