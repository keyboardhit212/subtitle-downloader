package keyboardhit212.subtitles.provider.opensubtitles;

import keyboardhit212.subtitles.GlobalConfiguration;
import keyboardhit212.subtitles.connection.Connection;
import keyboardhit212.subtitles.connection.FactoryConnection;
import keyboardhit212.subtitles.provider.SearchEntry;
import keyboardhit212.subtitles.provider.SearchProvider;
import keyboardhit212.subtitles.provider.opensubtitles.parser.OpenSubtitlesSearchParser;
import keyboardhit212.subtitles.provider.parser.Parser;

import java.util.List;

public class OpenSubtitlesSearchProvider implements SearchProvider {

    private static String SEARCH_URL = GlobalConfiguration.BASE_URL + "/en/search2/sublanguageid-all/moviename-";

    @Override
    public List<SearchEntry> search(String entry) {
        Connection connection = FactoryConnection.getConnection(GlobalConfiguration.CONNECTION_TYPE);
        connection.connect(String.format("%s%s", SEARCH_URL, entry.toLowerCase().replace(" ", "+")));
        System.out.println(entry.replace(" ", "+"));
        if (connection.isConnectionEstablished()) {
            Parser parser = new OpenSubtitlesSearchParser(connection.getBody());
            return (List<SearchEntry>) parser.getResults();
        }
        return null;
    }
}
