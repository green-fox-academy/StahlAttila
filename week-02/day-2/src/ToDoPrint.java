public class ToDoPrint {
    public static void main(String[] args) {
        String todoText = " - Buy milk\n";
        todoText ="My todo:\n" + todoText + " - Download games\n" + " \t-Diablo";

        //with Stringbuilder
        StringBuilder todoSB = new StringBuilder();
        todoSB.append("My todo:\n");
        todoSB.append(todoText);
        todoSB.append(" - Download games\n");
        todoSB.append(" \t- Diablo");
        //with Stringbuilder
        //System.out.println(todoSB);
        System.out.println(todoText);
    }

}
