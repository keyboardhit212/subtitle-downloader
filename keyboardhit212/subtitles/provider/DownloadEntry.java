package keyboardhit212.subtitles.provider;

public class DownloadEntry {

    private String title;
    private String lang;
    private String url;

    public DownloadEntry(String title, String lang, String url) {
        this.title = title;
        this.lang = lang;
        this.url = url;
    }

    public String getTitle() {
        return new String(title);
    }

    public String getLang() {
        return new String(lang);
    }

    public String getUrl() {
        return new String(url);
    }
}
