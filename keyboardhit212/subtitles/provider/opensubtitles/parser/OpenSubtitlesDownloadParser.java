package keyboardhit212.subtitles.provider.opensubtitles.parser;

import keyboardhit212.subtitles.provider.DownloadEntry;
import keyboardhit212.subtitles.provider.SearchEntry;
import keyboardhit212.subtitles.provider.parser.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class OpenSubtitlesDownloadParser implements Parser<List<DownloadEntry>> {

    private String html;

    public OpenSubtitlesDownloadParser(String html) {
        this.html = html;
    }

    @Override
    public List<DownloadEntry> getResults() {
        List<DownloadEntry> downloadEntries = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements elements = document.select(".change.even,.change.odd");
        for (Element element : elements) {
            Element entry = element.select("strong a").first();
            String title = entry.html();
            String href = entry.attr("href");
            System.out.println(stripLang(href));

            downloadEntries.add(new DownloadEntry(title, "F", href));
        }
        return downloadEntries;
    }

    private String stripLang(String href) {
        String[] splittedHref = href.split("-");
        return splittedHref[splittedHref.length - 1].toUpperCase();
    }

}
