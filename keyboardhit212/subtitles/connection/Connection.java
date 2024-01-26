package keyboardhit212.subtitles.connection;

public interface Connection {

    public void connect(String url);
    public boolean isConnectionEstablished();
    public String getBody();
}
