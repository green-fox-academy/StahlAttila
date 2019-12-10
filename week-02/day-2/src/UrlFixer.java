public class UrlFixer {
    public static void main(String[] args) {
        String url = "https//www.reddit.com/r/nevertellmethebots";
        url = url.replaceFirst("bots", "odds");
        if (url.startsWith("https/")){
            url = url.replace("https/", "https:/");
        }else if (url.startsWith("http/")) {
            url = url.replace("http/", "http:/");
        }
        System.out.println(url);
        // Accidentally I got the wrong URL for a funny subreddit. It's probably "odds" and not "bots"
        // Also, the URL is missing a crutial component, find out what it is and insert it too!
        // Try to solve it more than once using different String functions!
    }
}
