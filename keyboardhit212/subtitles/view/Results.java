package keyboardhit212.subtitles.view;

import keyboardhit212.subtitles.GlobalConfiguration;
import keyboardhit212.subtitles.connection.Connection;
import keyboardhit212.subtitles.connection.ConnectionType;
import keyboardhit212.subtitles.connection.FactoryConnection;
import keyboardhit212.subtitles.provider.*;

import java.util.List;

public class Results implements View {

    private static String SEARCH_URL = "https://www.opensubtitles.org/en/search/sublanguageid-all/tag-";

    @Override
    public void view(Object... params) {
        String movieName = (String) params[0];
        Provider provider = FactoryProvider.getProvider(GlobalConfiguration.PROVIDER_COMPANY);
        SearchProvider searchProvider = provider.getSearchProvider();
        List<SearchEntry> searchEntryList = searchProvider.search(movieName);
        displayEntries(searchEntryList);
    }

    private void displayEntries(List<SearchEntry> searchEntryList) {
        int i = 1;
        for (SearchEntry entry : searchEntryList) {
            System.out.printf("%d.) %s - %s\n", i, entry.getName(), entry.getLang());
            i++;
        }
    }
    
}
