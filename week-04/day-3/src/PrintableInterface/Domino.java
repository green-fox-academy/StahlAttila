package PrintableInterface;

public class Domino implements Printable {
    protected Integer left;
    protected Integer right;

    @Override
    public void PrintAllField() {
        System.out.println("Domino A side: " + this.left+", B side: "+this.right);
    }
}
