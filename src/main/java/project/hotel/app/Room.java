package project.hotel.app;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Room implements Serializable {

    private static final long serialVersionUID = -7719649347533111463L;
    int nr;
    SortedSet<Rezervation> reservationSet;

    Room(int nr) {
        this.nr = nr;
        reservationSet = new TreeSet<>();
    }

    public boolean reserve(LocalDate date, String name) {
        Rezervation r = new Rezervation(date, name, nr);
        return reservationSet.add(r);
    }

    @Override
    public String toString() {
        return "" + nr + reservationSet;
    }

    public boolean isAvailable(LocalDate date) {
        Rezervation r = new Rezervation(date, "", nr);
        return reservationSet.contains(r) == false;
    }

    public List<Rezervation> getAllReservations() {
        List<Rezervation> x = new ArrayList<>();
        x.addAll(reservationSet);
        return x;
    }
}
