package GreenFoxOrganizationCloneable;

public class Main {
    public static void main(String[] args) {
        Person John = new Student("John", 20, "male", "BME");
        Person johnTheClone = new Student();
        johnTheClone = John.clone();
        System.out.println(johnTheClone.age);
    }
}
