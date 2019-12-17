package PostIt;

public class Posts {
    public static void main(String[] args) {
        PostIt post1 = new PostIt("Orange", "Blue", "Idea 1");
        PostIt post2 = new PostIt("Pink", "Black", "Awsome");
        PostIt post3 = new PostIt("Yellow", "Green", "Superb!");
        System.out.println(post1.getBackgroundColor() + " " + post1.getTextColor() + " " + post1.getText());
        System.out.println(post2.getBackgroundColor() + " " + post2.getTextColor() + " " + post2.getText());
        System.out.println(post3.getBackgroundColor() + " " + post3.getTextColor() + " " + post3.getText());

    }
}
