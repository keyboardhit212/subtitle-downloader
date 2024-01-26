package keyboardhit212.subtitles.view;

import java.util.Scanner;

public class Home implements View {

    @Override
    public void view(Object... params) {
        Scanner console = new Scanner(System.in);
        System.out.printf("Search Movie Name: ");
        String movieName = console.nextLine();

        new SearchResults().view(movieName);
    }
}
