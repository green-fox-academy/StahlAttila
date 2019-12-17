package BlogPost;

public class BlogPost {
    private String authorName;
    private String title;
    private String text;
    private String publicationDate;

    public BlogPost(){
        this.authorName = "Unknown";
        this.title = "no title";
        this.text = "empty blog";
        this.publicationDate = "publicationDate";
    }
    public BlogPost(String authorName, String title, String publicationDate){
        this();
        this.authorName = authorName;
        this.title = title;
        this.publicationDate = publicationDate;
    }
    public String getAuthorName(){
        return authorName;
    }
    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getText(){
        return text;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getPublicationDate(){
        return publicationDate;
    }
    public void setPublicationDate(){
        this.publicationDate = publicationDate;
    }
    public String toString(){
        return this.getAuthorName() + "\n"+this.getTitle() + "\n"+ this.getText() + "\n" + this.getPublicationDate();
    }


}
