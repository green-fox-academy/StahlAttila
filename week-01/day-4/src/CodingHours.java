public class CodingHours {
    public static void main(String[] args) {
        int codingHours = 6;
        int semester = 17;
        int workDays = (semester * 7) - (semester * 2);
        System.out.println("An attendee spends " + (workDays * codingHours) + " hours with coding.");
    }
}
