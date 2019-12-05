public class CodingHours {
    public static void main(String[] args) {
        int workHoursWeekly = 52;
        int codingHours = 6;
        int semester = 17;
        int workDays = (semester * 7) - (semester * 2);

        //Print out the the coding hours of an attendee
        System.out.println("An attendee spends " + (workDays * codingHours) + " hours with coding.");

        //Prints out the percentage of the coding hours in the semester
        System.out.println("The percentage of coding hours in the semester: " + ((6.00 * 5) / workHoursWeekly) * 100 + "%");
        
    }
}
