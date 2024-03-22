package university.Homework4.variant3;

import java.io.*;

public class Doctor implements Externalizable {
    private String name;
    private String professional;
    private int number;
    private int days;
    private boolean isCertification;

    public Doctor() {

    }

    public Doctor(String name, String professional, int number, int days, boolean isCertification) {
        this.name = name;
        this.professional = professional;
        this.number = number;
        this.days = days;
        this.isCertification = isCertification;
    }

    public String getName() {
        return name;
    }

    public String getProfessional() {
        return professional;
    }

    public int getNumber() {
        return number;
    }

    public int getDays() {
        return days;
    }

    public boolean isCertification() {
        return isCertification;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public void setNumber(int number) {
        if (!(number >= 0)) {
            throw new RuntimeException("Вы ввели отрицательное число или такой номер уже существует");
        } else {
            this.number = number;
        }
    }

    public void setDays(int days) {
        if (days > 0) this.days = days;
        else throw new RuntimeException("Вы ввели отрицательное количество дней");
    }

    public void setCertification(Boolean isCertification) {
        this.isCertification = isCertification;
    }

    public void setCertification(String isCertification) {
        this.isCertification = isCertification.equalsIgnoreCase("да") ||
                isCertification.equalsIgnoreCase("yes");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getName());
        out.writeObject(this.getProfessional());
        out.writeObject(this.getNumber());
        out.writeObject(this.getDays());
        out.writeObject(this.isCertification());
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.professional = (String) in.readObject();
        this.number = (Integer) in.readObject();
        this.days = (Integer) in.readObject();
        this.isCertification = (Boolean) in.readObject();
    }

    @Override
    public String toString() {
        return "%s, %s, %d, %d, %b".formatted(name, professional, number, days, isCertification);
    }
}