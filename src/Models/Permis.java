package Models;

import java.io.Serializable;

public class Permis implements Serializable {

    public int num;
    public PermisType type;
    public Client client;

    public Permis(int id, PermisType type, Client owner) {
        this.num = id;
        this.type = type;
        this.client = owner;
    }

}