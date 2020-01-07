package GreenFoxOrganization;

public class Sponsor extends Person {
    protected String company;
    protected Integer hiredStudents;

    @Override
    public void introduce() {
        super.introduce();
    }

    @Override
    public void specificIntroduce() {
        System.out.print("who represents " + this.company + " and hired " + this.hiredStudents + " students so far.");
    }

    public void hire() {
        ++this.hiredStudents;
    }

    @Override
    public void getGoal() {
        System.out.println("My goal is: Hire brilliant junior software developers.");
    }

    public Sponsor(String name, Integer age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
        this.hiredStudents = 0;
    }

    public Sponsor() {
        super();
        this.company = "Google";
        this.hiredStudents = 0;
    }
}
