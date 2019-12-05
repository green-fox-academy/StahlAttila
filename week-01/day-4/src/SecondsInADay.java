public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        // Prints out the seconds left from the day
        System.out.println("Remaining seconds: " + (currentSeconds + currentMinutes * 60 + currentHours * 3600));

    }
}