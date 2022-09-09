package Models;

import java.io.Serializable;

public class Model implements Serializable {

    public String label;
    public int cv;
    public int consumption;
    public int capacity;
    public PermisType licenceType;
    public Brand brand;

    public Model(String name, int horses, int cons, int cc, PermisType permisNeeded, Brand brand)
    {
        label = name;
        cv = horses;
        consumption = cons;
        capacity = cc;
        licenceType = permisNeeded;
        this.brand = brand;

    }


}