package FleetOfThings;

public class FleetOfThings {

    public static void main(String[] args) {
        Thing milk = new Thing("Get milk");
        Thing obstacle = new Thing("Remove the Obstacle");
        Thing standUp = new Thing("Stand up");
        Thing eat = new Thing("Eat Lunch");
        Fleet fleet = new Fleet();
        // - You have the `Thing` class
        // - You have the `Fleet` class
        // - You have the `FleetOfThings` class with a `main` method
        // - Download those, use those
        // - In the main method create a fleet
        // - Achieve this output:
        // Create a fleet of things to have this output:
        // 1. [ ] Get milk
        // 2. [ ] Remove the obstacles
        // 3. [x] Stand up
        // 4. [x] Eat lunch
        fleet.add(milk);
        fleet.add(obstacle);
        fleet.add(standUp);
        fleet.add(eat);
        standUp.complete();
        eat.complete();

        System.out.println(fleet);
    }
}
