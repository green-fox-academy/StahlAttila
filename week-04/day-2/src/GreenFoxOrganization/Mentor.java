package GreenFoxOrganization;

public class Mentor extends Person {
    protected String level;

    public void getGoal() {
        System.out.println("My goal is: Educate brilliant junior software developers.");
    }

    public void introduce() {
        super.introduce();
    }

    public Mentor(String name, Integer age, String gender, String level) {
        super(name, age, gender);
        this.level = level;
    }

    public Mentor() {
        super();
        this.level = "intermediate";
    }

    @Override
    public void specificIntroduce() {
        System.out.print(" " + this.level + " mentor.");
    }
}
