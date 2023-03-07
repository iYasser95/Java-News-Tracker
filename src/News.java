public class News {

    private String[] titles;
    private String[] dates;
    private String[] links;

    public String[] getTitles() {
        return titles;
    }

    public String[] getDates() {
        return dates;
    }

    public String[] getLinks() {
        return links;
    }
    News(String[] titles, String[] dates, String[] links) {
        this.titles = titles;
        this.dates = dates;
        this.links = links;
    }
}
