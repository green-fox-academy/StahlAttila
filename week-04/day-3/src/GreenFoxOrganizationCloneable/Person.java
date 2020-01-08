package GreenFoxOrganizationCloneable;

public class Person {
    protected String name;
    protected Integer age;
    protected String gender;

    public void introduce() {
        System.out.print("Hi, I'm " + this.name + ", a " + this.age + " year old " + this.gender);
        specificIntroduce();
        System.out.println();
    }

    public void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }

    public Person() {
        this.name = "Jane Doe";
        this.age = 30;
        this.gender = "female";
    }

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public void specificIntroduce() {
        System.out.print(".");
    }

    public Person clone(){
        return null;
    }
}
