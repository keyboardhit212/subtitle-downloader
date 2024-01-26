package keyboardhit212.subtitles.connection;

public class FactoryConnection {

    private FactoryConnection() {}

    public static Connection getConnection(ConnectionType connectionType) {
        switch (connectionType) {
            default:
                return new BasicConnection();
        }
    }
}
