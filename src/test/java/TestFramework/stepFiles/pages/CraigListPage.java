package TestFramework.stepFiles.pages;

import static TestFramework.base.Utilities.findAndClickElement;
import static TestFramework.stepFiles.CraigListPageConstants.*;
import static TestFramework.stepFiles.workers.CraigListPage.*;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;

public class CraigListPage {


    @Given("^User navigates to website$")
    public void user_navigates_to_website() {
        navigateToWebsite(craiglistUrl);
        checkElementTitle("craigslist: toronto jobs, apartments, for sale, services, community, and events");
    }

    @Given("^User clicks housing link$")
    public void user_selects_vacancy_category()  {
        findLinkElementByXpath(housingLink).click();
    }

    @Given("^User clicks \"([^\"]*)\" dropdown functionality$")
    public void  user_clicks_sorting_dropdown(String sorting)  {
        findAndClickElement(PriceFilters.get(sorting));

    }

    @Given("^User check sorting$")
    public void user_check_sorting()  {
        checkSorting();
    }

    @Given("^User checks \"([^\"]*)\" value at dropdown$")
    public void user_checks_dropdown(String value, DataTable table) {
        checkDataTable(table, value);
    }

    @Given("^User searches \"([^\"]*)\" on search bar$")
    public void user_checks_dropdown(String value) {
        findLinkElementByXpath(searchBar).sendKeys(value);
        findLinkElementByXpath(searchButton).click();
    }

}
