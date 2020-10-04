package wikisearch.parser;

import com.google.gson.Gson;

public class Parser {

    String inputString;

    public Parser(String inputString) {
        this.inputString = inputString;
    }

    public void parse() {
        Gson gson = new Gson();
        SearchResultPage page = gson.fromJson(inputString, SearchResultPage.class);
        printResult(page);
    }
    public void printResult(SearchResultPage page) {
        int count = 0;
        for (SearchResult result : page.getQuery().getSearch()) {
            count++;
            System.out.println("Search result #" + count);
            System.out.println(result.getTimestamp());
            System.out.println("Page ID: " + result.getPageid());
            System.out.println(result.getTitle());
            System.out.println(result.getSnippet().replaceAll("<.*?>", ""));
            System.out.println("========================================================================");
        }
    }
}
