package PostIt;

public class Posts {
    public static void main(String[] args) {
        PostIt post1 = new PostIt("Orange", "Blue", "Idea 1");
        PostIt post2 = new PostIt("Pink", "Black", "Awsome");
        PostIt post3 = new PostIt("Yellow", "Green", "Superb!");
        System.out.println(post1.toString());
        System.out.println(post2.toString());
        System.out.println(post3.toString());

    }
}
