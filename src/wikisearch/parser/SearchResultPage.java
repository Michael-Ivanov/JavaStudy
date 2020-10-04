package wikisearch.parser;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchResultPage {

    @SerializedName("batchcomplete")
    @Expose
    private String batchcomplete;
    @SerializedName("continue")
    @Expose
    private Continue _continue;
    @SerializedName("query")
    @Expose
    private SearchQuery query;

    public String getBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(String batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public Continue getContinue() {
        return _continue;
    }

    public void setContinue(Continue _continue) {
        this._continue = _continue;
    }

    public SearchQuery getQuery() {
        return query;
    }

    public void setQuery(SearchQuery query) {
        this.query = query;
    }

}