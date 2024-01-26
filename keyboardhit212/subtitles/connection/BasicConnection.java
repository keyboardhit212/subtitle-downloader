package keyboardhit212.subtitles.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BasicConnection implements Connection {

    private String url;
    private boolean isConnected;
    private String body;

    @Override
    public void connect(String link) {
        this.url = link;
        try {
            URL url = new URL(this.url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String inputLine;
                while ((inputLine = reader.readLine()) != null) {
                    builder.append(inputLine);
                }
                reader.close();
                this.body = builder.toString();
                this.isConnected = true;
            } else {
                this.isConnected = false;
            }
        } catch (IOException e) {
            this.isConnected = false;
        }
    }

    @Override
    public boolean isConnectionEstablished() {
        return isConnected;
    }

    @Override
    public String getBody() {
        return this.body;
    }

    public static void main(String[] args) {
        Connection connection = new BasicConnection();
    }
}
