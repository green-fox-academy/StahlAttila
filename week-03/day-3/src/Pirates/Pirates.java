package Pirates;

import java.util.Random;

public class Pirates {
    private String title = "pirate";
    private String name;
    private int intoxication = 0;
    private Boolean isDead = false;
    private String condition ="Alive";

    public Pirates(){
        this.name = "Filthy Swine";
        this.intoxication = randomGenerator(6);
        this.isDead = false;
        this.condition = defaultCondition();
    }

    public String defaultCondition(){
        if(intoxication > 4){
            return "Passed out";
        }else{
            return "Alive";
        }
    }

    public Pirates(String name){
        this();
        this.name = name;
    }

    public Pirates(String title, String name){
        this(name);
        this.title = title;
    }

    public void drinkSomeRum(){
        if(!this.getDead() && this.getIntoxication() < 5) {
            this.intoxication++;
            if(this.getIntoxication()>4){
                this.setPassedOut();
            }
        }else{
            System.out.println("he's dead");
        }
    }

    public void howsItGoingMate(){
        if(this.getIntoxication()< 5){
            System.out.println("Pour me anudder!");
        }else if(this.getDead()){
            System.out.println("he's dead");
        }else{
            System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?\", the pirate passes out and sleeps it off");
        }
    }
    public Integer randomGenerator(Integer bound){
        Random random = new Random();
        return random.nextInt(bound);
    }

    public void brawl(Pirates pirate){
        if(!this.getDead() && !pirate.getDead() && !this.getCondition().equals("passed out") && !pirate.getCondition().equals("passed out")) {
            if (randomGenerator(3) > 1) {
                this.die();
                System.out.println(this.getName() + " died.");
            } else if (randomGenerator(3) < 1) {
                pirate.die();
                System.out.println(pirate.getName() + " died.");
            } else {
                this.setPassedOut();
                pirate.setPassedOut();
                System.out.println("Both passed out");
            }
        }

    }

    public void die(){
        this.setDead(true);
    }

    public String toString(){
        return this.title+" "+ this.getName() + " ||  toxication lvl: "+ this.getIntoxication() + " || " + this.getCondition();
    }

    public String getName() {
        return name;
    }

    public int getIntoxication() {
        return intoxication;
    }

    public String getCondition(){
        return condition;
    }

    public void setPassedOut(){
        condition = "passed out";
    }

    public Boolean getDead() {
        return isDead;
    }

    public void setIntoxication(int intoxication) {
        this.intoxication = intoxication;
    }

    public void setDead(Boolean dead) {
        condition = "Dead";
        isDead = true;
    }

    public void setCapt(){
        this.title = "capt.";
        this.name = "Jack Sparrow";
    }


    // test for brawl mechanic
    /*public static void main(String[] args) {
        Pirates pirate1 = new Pirates("Long John");
        Pirates pirate2 = new Pirates("Black Beard");

        pirate1.brawl(pirate2);


    }
*/

}
