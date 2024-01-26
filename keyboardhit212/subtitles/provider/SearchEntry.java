package keyboardhit212.subtitles.provider;

public class SearchEntry {

    private String name;
    private String lang;
    private String url;

    public SearchEntry(String name, String lang, String url) {
        this.name = name;
        this.lang = lang;
        this.url = url;
    }

    public String getName() {
        return new String(this.name);
    }

    public String getUrl() {
        return new String(this.url);
    }

    public String getLang() {return new String(this.lang); }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.name, this.lang, this.url);
    }
}
