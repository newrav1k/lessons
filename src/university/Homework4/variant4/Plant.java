package university.Homework4.variant4;

import java.io.*;

public class Plant implements Externalizable {

    private String name;
    private String county;
    private int valueOfLeaves;
    private int age;
    private boolean isHide;

    public Plant() {

    }

    public Plant(String name, String county, int valueOfLeaves, int age, boolean isHide) {
        this.name = name;
        this.county = county;
        this.valueOfLeaves = valueOfLeaves;
        this.age = age;
        this.isHide = isHide;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(county);
        out.writeObject(valueOfLeaves);
        out.writeObject(age);
        out.writeObject(isHide);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.county = (String) in.readObject();
        this.valueOfLeaves = (Integer) in.readObject();
        this.age = (Integer) in.readObject();
        this.isHide = (Boolean) in.readObject();
    }
}