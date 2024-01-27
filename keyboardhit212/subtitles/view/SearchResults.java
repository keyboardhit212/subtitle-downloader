package keyboardhit212.subtitles.view;

import keyboardhit212.subtitles.GlobalConfiguration;
import keyboardhit212.subtitles.provider.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SearchResults implements View {

    @Override
    public void view(Object... params) {
        String movieName = (String) params[0];
        Provider provider = FactoryProvider.getProvider(GlobalConfiguration.PROVIDER_COMPANY);
        SearchProvider searchProvider = provider.getSearchProvider();
        List<SearchEntry> searchEntryList = searchProvider.search(movieName);
        displayEntries(searchEntryList);
        choiceSelection(searchEntryList);
    }

    private void displayEntries(List<SearchEntry> searchEntryList) {
        int i = 1;
        for (SearchEntry entry : searchEntryList) {
            System.out.printf("%d.) %s\n", i, entry.getName());
            i++;
        }
    }

    private void choiceSelection(List<SearchEntry> searchEntryList) {
        Scanner console = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter choice: ");
                int choice = console.nextInt();
                if (choice > searchEntryList.size() || choice == 0)
                    throw new Exception("Invalid Choice!");
                new DownloadResults().view(searchEntryList.get(choice - 1));
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
