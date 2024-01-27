package keyboardhit212.subtitles.provider;

public class SearchEntry {

    private String name;
    private String url;

    public SearchEntry(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return new String(this.name);
    }

    public String getUrl() {
        return new String(this.url);
    }


    @Override
    public String toString() {
        return String.format("%s %s", this.name, this.url);
    }
}
