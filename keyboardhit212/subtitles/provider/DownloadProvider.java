package keyboardhit212.subtitles.provider;

import java.util.List;

public interface DownloadProvider {
    public List<DownloadEntry> retrieve(SearchEntry entry);
}
