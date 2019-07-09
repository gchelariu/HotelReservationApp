package project.hotel.app;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private static final long serialVersionUID = -7719649347533111463L;
    int nr;
    List<Rezervation> rezervationList;

    Room(int nr) {
        this.nr = nr;
        rezervationList = new ArrayList<Rezervation>();
    }

    public boolean reserve(LocalDate date, String name) {

        Rezervation r = new Rezervation(date, name, nr);
        if(rezervationList.contains(r)){
            return false;
        } else{
            rezervationList.add(r);
            return true;
        }
    }

    @Override
    public String toString(){
        return "" + nr + rezervationList;
    }

    public boolean isAvailable(LocalDate date) {
        Rezervation r = new Rezervation(date, "", nr);
        return rezervationList.contains(r) == false;
    }

    public List<Rezervation> getAllReservations() {
        return rezervationList;
    }
}
