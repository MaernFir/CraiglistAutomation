package TestFramework.stepFiles;

import java.util.HashMap;
import java.util.Map;

public class CraigListPageConstants {

    public static HashMap<String, String> PriceFilters = new HashMap<String, String>();

    static {
        PriceFilters.put("priceAscending", "//form[@id=\"searchform\"]//a[@data-selection='priceasc']");
        PriceFilters.put("priceDescending", "//form[@id=\"searchform\"]//a[@data-selection='pricedsc']");
        PriceFilters.put("priceUpcoming", "//form[@id=\"searchform\"]//a[@data-selection='upcoming']");
        PriceFilters.put("priceNewest", "//form[@id=\"searchform\"]//a[@data-selection='date']");
        PriceFilters.put("priceRelevant", "//form[@id=\"searchform\"]//a[@data-selection='rel']");
    }

    public static final String craiglistUrl = "https://toronto.craigslist.org/";

    public static final String pageSortButton = "//ul[@id='search-results']";

    public static final String searchResults = "//form[@id=\"searchform\"]//div[@class='search-sort']";

    public static final String searchBar = "//*[@id='query']";

    public static final String searchButton = "//*[@id=\"searchform\"]/div[1]/button";

    public static final String housingLink = "//a[@href='/d/apartments-housing-for-rent/search/apa']";

    public static final String resultPrice = "//span[@class='result-meta']/span[@class='result-price']";

}
