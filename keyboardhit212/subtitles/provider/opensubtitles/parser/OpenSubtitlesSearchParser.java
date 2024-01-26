package keyboardhit212.subtitles.provider.opensubtitles.parser;

import keyboardhit212.subtitles.provider.SearchEntry;
import keyboardhit212.subtitles.provider.parser.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class OpenSubtitlesSearchParser implements Parser<List<SearchEntry>> {

    private String html;

    public OpenSubtitlesSearchParser(String html) {
        this.html = html;
    }

    @Override
    public List<SearchEntry> getResults() {
        List<SearchEntry> searchEntries = new ArrayList<>();
        Document document = Jsoup.parse(html);
        Elements elements = document.select(".change.odd,.change.even");
        for (Element element : elements) {
            Element entry = element.select("strong a").first();
            String title = entry.html();
            String href = entry.attr("href");
            searchEntries.add(new SearchEntry(title, "", href));
        }
        return searchEntries;
    }

    private String stripLang(String href) {
        String[] splitStrings = href.split("/");
        String[] tailStrings = splitStrings[splitStrings.length - 1].split("-");
        return tailStrings[tailStrings.length - 1];
    }
}
