package keyboardhit212.subtitles.view;

import keyboardhit212.subtitles.GlobalConfiguration;
import keyboardhit212.subtitles.provider.DownloadProvider;
import keyboardhit212.subtitles.provider.FactoryProvider;
import keyboardhit212.subtitles.provider.Provider;
import keyboardhit212.subtitles.provider.SearchEntry;

public class DownloadResults implements View {

    @Override
    public void view(Object... params) {
        SearchEntry entry = (SearchEntry) params[0];
        Provider provider = FactoryProvider.getProvider(GlobalConfiguration.PROVIDER_COMPANY);
        DownloadProvider downloadProvider = provider.getDownloadProvider();
        downloadProvider.retrieve(entry);
        System.out.println(entry);
    }
}
