package keyboardhit212.subtitles;

import keyboardhit212.subtitles.connection.ConnectionType;
import keyboardhit212.subtitles.provider.ProviderCompany;

public class GlobalConfiguration {

    public static ConnectionType CONNECTION_TYPE = ConnectionType.BASIC;
    public static ProviderCompany PROVIDER_COMPANY = ProviderCompany.OPEN_SUBTITLES;

    private GlobalConfiguration() {}
}
