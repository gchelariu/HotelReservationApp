package project.hotel.app;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Reception {

    Hotel h;

    public Reception(Hotel h) {
        this.h = h;
    }

    private void showMenu() {
        System.out.println("Tipe the number: ");
        System.out.println("1 To make a reservation");
        System.out.println("2 TO show all hotel reservations.");
        System.out.println("3 To show all reservations in alphabetical order and exit.");
        System.out.println("4 To close the application.");
    }


    public void run() {
        Scanner s = new Scanner(System.in);

        while (true) {
            showMenu();
            String tasta = s.nextLine();
            switch (tasta) {
                case "1":
                    System.out.println("Type the date of the reservation (yyyy-mm-dd)");
                    LocalDate d = LocalDate.parse(s.nextLine());

                    System.out.println("Enter the client name");
                    String nume = s.next();

                    int nrCamera = h.getAvailableRoom(d);
                    System.out.println("Room " + nrCamera + " has been reserved.");

                    if(nrCamera == -1) {
                        System.out.println("Sorry. No room available");
                        break;
                    }
                    h.reserveRoom(nrCamera, d, nume);
                    break;
                case "2":
                    System.out.println(h);
                    break;
                case "3":
                    System.out.println(h.getAllRezervationsSortedByName());
                case "4":
                    h.save();
                    return;
            }
        }
    }
}

