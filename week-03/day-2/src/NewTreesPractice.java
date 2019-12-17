class NewTrees{
    String Type;
    String leafColor;
    int age;
    String sex;

    void attributes(){
        System.out.println(Type + " " + leafColor + " " + age + " " + sex);
    }
}

public class NewTreesPractice {
    public static void main(String[] args) {

        NewTrees tree1 = new NewTrees();
        tree1.Type = "Walnut";
        tree1.leafColor = "green";
        tree1.age = 15;
        tree1.sex = "yes,pls";

        NewTrees tree2 = new NewTrees();
        tree2.Type = "Crabapples";
        tree2.leafColor = "pink";
        tree2.age = 7;
        tree2.sex = "yes,pls";

        NewTrees tree3 = new NewTrees();
        tree3.Type = "Birch";
        tree3.leafColor = "green";
        tree3.age = 3;
        tree3.sex = "yes,pls";

        NewTrees tree4 = new NewTrees();
        tree4.Type = "Cherry 'Kwanzan'";
        tree4.leafColor = "pink";
        tree4.age = 11;
        tree4.sex = "yes,pls";

        NewTrees tree5 = new NewTrees();
        tree5.Type = "Plum";
        tree5.leafColor = "dark purple";
        tree5.age = 7;
        tree5.sex = "yes,pls";

        tree1.attributes();
        tree2.attributes();
        tree3.attributes();
        tree4.attributes();
        tree5.attributes();

    }
}