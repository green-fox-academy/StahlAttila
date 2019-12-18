package BlogPost;

import java.util.ArrayList;

public class Blog {
    private ArrayList<BlogPost> blogPosts;

    public Blog(){
        this.blogPosts = new ArrayList<BlogPost>();
    }

    public void add(BlogPost post){
        this.blogPosts.add(post);
    }
    public void delete(Integer index){
        this.blogPosts.remove(index);
    }
    public void update(Integer index, BlogPost post){
        this.blogPosts.set(index, post);
    }

    @Override
    public String toString() {
        return "Blog posts: \n" + blogPosts;
    }
}
