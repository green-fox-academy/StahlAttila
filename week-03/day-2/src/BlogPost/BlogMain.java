package BlogPost;

import java.util.ArrayList;

public class BlogMain {
    public static void main(String[] args) {
        BlogPost post1 = new BlogPost("John Doe", "Lorem Ipsum", "2000.05.04.");
        post1.setText("Lorem ipsum dolor sit amet.");

        BlogPost post2 = new BlogPost("Tim Urban", "Wait but why", "2010.10.10.");
        post2.setText("A popular long-form, stick-figure-illustrated blog about almost everything.");

        BlogPost post3 = new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump0", "2017.03.28.");
        post3.setText("Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.");
        /*System.out.println(post1.toString());
        System.out.println("---------------");
        System.out.println(post2.toString());
        System.out.println("---------------");
        System.out.println(post3.toString());*/
        BlogPost post4 = new BlogPost("Attila", "updated", "2019.12.18");
        post4.setText("asdasd yoloyolo");

        Blog blog = new Blog();
        blog.add(post1);
        blog.add(post2);
        blog.add(post3);
        System.out.println(blog.toString());
        blog.delete(1);
        System.out.println(blog.toString());
        System.out.println("-------------------------------");
        blog.update(0, post4);
        System.out.println(blog.toString());





    }
}
