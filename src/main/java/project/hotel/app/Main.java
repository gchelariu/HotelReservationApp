package project.hotel.app;

public class Main {

    public static void main(String[] args) {

        Reception r = new Reception(Hotel.load());
        r.run();
    }
}
