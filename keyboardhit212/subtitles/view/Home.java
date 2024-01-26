package keyboardhit212.subtitles.view;

import keyboardhit212.subtitles.GlobalConfiguration;
import keyboardhit212.subtitles.provider.FactoryProvider;
import keyboardhit212.subtitles.provider.Provider;
import keyboardhit212.subtitles.provider.ProviderCompany;

import java.util.Scanner;

public class Home implements View {

    @Override
    public void view(Object... params) {
        Scanner console = new Scanner(System.in);
        System.out.printf("Search Movie Name: ");
        String movieName = console.nextLine();

        new Results().view(movieName);
    }
}
