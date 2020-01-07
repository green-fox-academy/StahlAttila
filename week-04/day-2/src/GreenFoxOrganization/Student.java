package GreenFoxOrganization;

public class Student extends Person {
    protected String previousOrganization;
    protected Integer skippedDays;

    public Student(String name, Integer age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;
        this.skippedDays = 0;
    }

    public Student() {
        super();
        this.previousOrganization = "The School of Life";
        this.skippedDays = 0;
    }

    public void introduce() {
        super.introduce();
    }

    @Override
    public void getGoal() {
        System.out.println("My Goal is: Be a junior software developer.");
    }

    public void skipDays(Integer numberOfDays) {
        this.skippedDays += numberOfDays;
    }

    @Override
    public void specificIntroduce() {
        System.out.print(" from " + this.previousOrganization + " who skipped " + this.skippedDays + " days from the course already.");
    }
}
