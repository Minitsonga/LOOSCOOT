package Models;

import java.io.*;
import java.util.Vector;

public class DataScooter implements Serializable {


    public void SaveData(Parc p) {
        try {
            OutputStream file = new FileOutputStream("output.txt");
            ObjectOutput output = new ObjectOutputStream(file);
            output.writeObject(p.getNameParc());
            output.writeObject(p.getAddress());
            output.writeObject(p.getListScooter());
            output.writeObject(p.getListClient());
            output.close();
            System.out.println("Saved : " + p.getListClient().size());
            System.out.println("Save nicely done");
        } catch (Exception e) {
            System.out.println("Output failed." + e);
        }


    }

    public Parc LoadData() {
        Parc parc = null;
        String nameParc;
        Parc.Address address;
        Vector<Scooter> scooters = new Vector<>();
        Vector<Client> clients = new Vector<>();

        try {
            FileInputStream fileIn = new FileInputStream("output.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            nameParc = (String) in.readObject();
            address = (Parc.Address) in.readObject();
            scooters = (Vector<Scooter>) in.readObject();
            clients = (Vector<Client>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Parc loaded Successfully ");
            System.out.println(clients.size());
            parc = new Parc(nameParc, address, scooters, clients);
            return parc;
        } catch (Exception e) {
            System.out.println("No loaded.");
            return null;
        }

    }

}