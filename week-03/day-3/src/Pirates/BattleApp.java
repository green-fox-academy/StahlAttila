package Pirates;

public class BattleApp {
    public static void main(String[] args) {

        Ship theBlackYolo = new Ship("The Black Yolo");
        theBlackYolo.fillShip();

        Ship theWildHuntress = new Ship("The Wild Huntress");
        theWildHuntress.fillShip();


        System.out.println(theBlackYolo.toString());
        System.out.println("-------------------------------------------");
        System.out.println(theWildHuntress.toString());

        theBlackYolo.battle(theWildHuntress);

        System.out.println(theBlackYolo.toString());
        System.out.println("-------------------------------------------");
        System.out.println(theWildHuntress.toString());
    }

}



