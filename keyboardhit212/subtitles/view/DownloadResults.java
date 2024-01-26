package keyboardhit212.subtitles.view;

import keyboardhit212.subtitles.provider.SearchEntry;

public class DownloadResults implements View {

    @Override
    public void view(Object... params) {
        SearchEntry entry = (SearchEntry) params[0];
        System.out.println(entry);
    }
}
