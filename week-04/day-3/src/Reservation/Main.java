package Reservation;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Reservation booking1 = new Reservation("booking1");
        Reservation booking2 = new Reservation("booking2");
        Reservation booking3 = new Reservation("booking3");
        Reservation booking4 = new Reservation("booking4");
        Reservation booking5 = new Reservation("booking5");
        Reservation booking6 = new Reservation("booking6");
        Reservation booking7 = new Reservation("booking7");
        Reservation booking8 = new Reservation("booking8");
        Reservation booking9 = new Reservation("booking9");
        Reservation booking10 = new Reservation("booking10");

        ArrayList<Reservation> bookings = new ArrayList<>();
        bookings.add(booking1);
        bookings.add(booking2);
        bookings.add(booking3);
        bookings.add(booking4);
        bookings.add(booking5);
        bookings.add(booking6);
        bookings.add(booking7);
        bookings.add(booking8);
        bookings.add(booking9);
        bookings.add(booking10);

        for (Reservation b : bookings) {
            System.out.println(b.toString());
        }
    }
}
