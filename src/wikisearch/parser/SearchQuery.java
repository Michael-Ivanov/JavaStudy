package wikisearch.parser;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SearchQuery {

    @SerializedName("searchinfo")
    @Expose
    private SearchResult searchinfo;
    @SerializedName("search")
    @Expose
    private List<SearchResult> search = null;

    public SearchResult getSearchinfo() {
        return searchinfo;
    }

    public void setSearchinfo(SearchResult searchinfo) {
        this.searchinfo = searchinfo;
    }

    public List<SearchResult> getSearch() {
        return search;
    }

    public void setSearch(List<SearchResult> search) {
        this.search = search;
    }

}
