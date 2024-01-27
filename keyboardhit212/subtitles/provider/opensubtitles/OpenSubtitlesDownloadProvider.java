package keyboardhit212.subtitles.provider.opensubtitles;

import keyboardhit212.subtitles.GlobalConfiguration;
import keyboardhit212.subtitles.connection.Connection;
import keyboardhit212.subtitles.connection.ConnectionType;
import keyboardhit212.subtitles.connection.FactoryConnection;
import keyboardhit212.subtitles.provider.DownloadEntry;
import keyboardhit212.subtitles.provider.DownloadProvider;
import keyboardhit212.subtitles.provider.SearchEntry;
import keyboardhit212.subtitles.provider.opensubtitles.parser.OpenSubtitlesDownloadParser;
import keyboardhit212.subtitles.provider.parser.Parser;

import java.util.ArrayList;
import java.util.List;

public class OpenSubtitlesDownloadProvider implements DownloadProvider {

    @Override
    public List<DownloadEntry> retrieve(SearchEntry entry) {
        List<DownloadEntry> downloadEntries = new ArrayList<>();
        String url = GlobalConfiguration.BASE_URL + entry.getUrl();
        Connection connection = FactoryConnection.getConnection(ConnectionType.BASIC);
        connection.connect(url);
        if (connection.isConnectionEstablished()) {
            Parser<List<DownloadEntry>> parser = new OpenSubtitlesDownloadParser(connection.getBody());
            downloadEntries = parser.getResults();
        }
        return downloadEntries;
    }
}
