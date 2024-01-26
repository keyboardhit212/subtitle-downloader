package keyboardhit212.subtitles.provider.opensubtitles;

import keyboardhit212.subtitles.provider.DownloadProvider;
import keyboardhit212.subtitles.provider.Provider;
import keyboardhit212.subtitles.provider.SearchProvider;

public class OpenSubtitlesProvider implements Provider {
    @Override
    public SearchProvider getSearchProvider() {
        return new OpenSubtitlesSearchProvider();
    }

    @Override
    public DownloadProvider getDownloadProvider() {
        return new OpenSubtitlesDownloadProvider();
    }
}
