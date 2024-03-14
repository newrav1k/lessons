package university.Homework2.variant3;

import java.util.Scanner;
import java.util.Comparator;

public class Doctor implements Comparable<Doctor> {
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
        if ((!(number >= 0 && DoctorApplication.isExistingNumber(number)))) {
            throw new RuntimeException("Вы ввели отрицательное число или такой номер уже существует");
        } else {
            this.number = number;
        }
    }

    public void setDays(int days) {
        if (days > 0) {
            this.days = days;
        } else {
            throw new RuntimeException("Вы ввели отрицательное количество дней");
        }
    }

    public void setCertification(Boolean isCertification) {
        this.isCertification = isCertification;
    }

    public void setCertification(String isCertification) {
        this.isCertification = isCertification.equalsIgnoreCase("да") ||
                isCertification.equalsIgnoreCase("нет");
    }

    @Override
    public int compareTo(Doctor o) {
        return getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "%s, %s, %d, %d, %b".formatted(name, professional, number, days, isCertification);
    }
}