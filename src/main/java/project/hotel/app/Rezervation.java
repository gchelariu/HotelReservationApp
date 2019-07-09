package project.hotel.app;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Comparator;

public class Rezervation implements Serializable,Comparable<Rezervation> {

    private static final long serialVersionUID = 3091514142132259451L;
    LocalDate date;
    public String name;
    int nrRoom;

    @Override
    public int compareTo(Rezervation rezervation) {
        return name.compareTo(rezervation.name);
    }

    public static class ComparatorByName implements Comparator<Rezervation>{
        @Override
        public int compare(Rezervation rezervation1, Rezervation rezervation2) {
            return rezervation1.name.compareTo(rezervation2.name);
        }
    }

    //This is just as an example. You can do the same think without a additional method by putting .reversed() at the end.
    //Este doar ca exemplu. Poti face reversul prin a pune pur si simplu .reversed() la apelul anterior!
    public static class ComparatorByNameReverse implements Comparator<Rezervation>{
        @Override
        public int compare(Rezervation rezervation1, Rezervation rezervation2) {
            return rezervation1.name.compareTo(rezervation1.name);
        }
    }

    Rezervation(LocalDate date, String name, int nrRoom) {
        this.date = date;
        this.name = name;
        this.nrRoom = nrRoom;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Rezervation) {
            Rezervation tmp = (Rezervation) obj;
            return this.date.equals(tmp.date) &&
                    this.nrRoom == tmp.nrRoom;
        } else {
            return false;
        }
    }

    @Override
    public String toString(){
        return date + name;
    }

}
