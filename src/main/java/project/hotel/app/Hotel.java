package project.hotel.app;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel implements Serializable {
    private static final long serialVersionUID = -299345675886125574L;
    List<Room> roomList;

    public Hotel() {
        roomList = new ArrayList<Room>();
        for (int i = 0; i < 11; ++i) {
            roomList.add(new Room(i));
        }
    }

    public boolean isRoomAvailable(int nr, LocalDate date) {
        Room x = roomList.get(nr);
        return x.isAvailable(date);
    }

    public boolean reserveRoom(int nr, LocalDate d, String nume) {
        Room x = roomList.get(nr);
        return x.reserve(d, nume);
    }

    @Override
    public String toString() {
        return "" + roomList;
    }

    public int getAvailableRoom(LocalDate d) {
        for (int i = 0; i < roomList.size(); ++i) {
            if (roomList.get(i).isAvailable(d)) {
                return i;
            }
        }
        return -1;
    }

    public void save() {
        // Serializare
        try {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream("hotel.db");
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(this);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Hotel load() {
        Hotel object1 = null;
        // Deserialization
        try {
            // Reading the object from a file
            FileInputStream file = new FileInputStream("hotel.db");
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            object1 = (Hotel) in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
        } catch (FileNotFoundException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
        }

        if (object1 == null) {
            object1 = new Hotel();
        }
        return object1;
    }

    public List<Rezervation> getAllRezervationsSortedByName() {
//        Pas 1: Obtinem lista cu toate rezervarile.
//        Pas 2: Sortez
//        Pas 3: Le returnez
        List<Rezervation> acumulator = new ArrayList<>();
        for (Room room: roomList){
            List<Rezervation> tmp = room.getAllReservations();
            acumulator.addAll(tmp);
        }

        //Example of Anonim Class
        //IMPORTANT ca exemplu (Anonim Class)
        acumulator.sort(new Rezervation.ComparatorByName());

        return  acumulator;
    }
}
