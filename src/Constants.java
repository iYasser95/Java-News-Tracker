public enum Constants {
    ITEM("item"),
    TITLE("title"),
    LINK("link"),
    PUBLISH_DATE("pubDate"),
    API_LINK("https://developer.apple.com/news/rss/news.rss"),
    REGEX("amp;"),
    FRAME_TITLE("Developer News");
    public String rawValue;



    private Constants(String rawValue) {
        this.rawValue = rawValue;
    }
}
