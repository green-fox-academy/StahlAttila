package Reservation;

import java.util.ArrayList;
import java.util.Random;

public class Reservation implements Reservationy{
    protected String bookingName;

    public Reservation(String booking) {
        this.bookingName = booking;
    }

    @Override
    public String getDowBooking() {
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        return days[random(7)];
    }

    @Override
    public String getCodeBooking() {
        String chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 0 1 2 3 4 5 6 7 8 9";
        chars = chars.replace(" ", "");
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            code.append(chars.charAt(random(36)));
        }
        return code.toString();
    }

    public static int random(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }

    @Override
    public String toString() {
        return "Booking# " + getCodeBooking() + " for " + getDowBooking();
    }
}
