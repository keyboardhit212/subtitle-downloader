package keyboardhit212.subtitles.provider;

import keyboardhit212.subtitles.provider.opensubtitles.OpenSubtitlesProvider;

public class FactoryProvider {

    private FactoryProvider() {}

    public static Provider getProvider(ProviderCompany providerCompany) {
        switch (providerCompany) {
            default:
                return new OpenSubtitlesProvider();
        }
    }
}
