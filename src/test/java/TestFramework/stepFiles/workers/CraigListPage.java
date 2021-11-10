package TestFramework.stepFiles.workers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import TestFramework.base.Utilities;
import cucumber.api.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static TestFramework.base.Utilities.*;
import static TestFramework.stepFiles.CraigListPageConstants.*;

public class CraigListPage {

   static Utilities utility = new Utilities();

    public static WebElement findLinkElementByCss(String linkConstant) {
        return findWebElementByCss(linkConstant);
    }

    public static WebElement findLinkElementByXpath(String linkConstant) {
        return findWebElementByXpath(linkConstant);
    }

    public static void navigateToWebsite(String title) { utility.navigateToWebsite(title) ; }

    public static void checkElementTitle(String title) {
        utility.checkElementText(title);
    }

    public static WebElement getElementWhenVisible(By value){
        return waitUntil(visibilityOfElement(value));
    }

    public static void checkSorting(){
        WebElement requirement = findLinkElementByXpath(searchResults);
        ArrayList<Integer> obtainedList = new ArrayList<>();
        List<WebElement> elementList= requirement.findElements(By.xpath(resultPrice));
        for(WebElement we:elementList){
            String clearText = we.getText().replaceAll("[^\\d.]", "" );
            Integer parsedValue = Integer.parseInt(clearText);
            obtainedList.add(parsedValue);
        }
        ArrayList<Integer> sortedList = new ArrayList<>();
        for(Integer i:obtainedList){
            sortedList.add(i);
        }

   //     with if boolean or switch and input this can become multi used sorting
        Collections.sort(sortedList);
        for(int i=0; i < sortedList.size(); i++){

        Assert.assertTrue(obtainedList.get(i).equals(sortedList.get(i)));
        }
        }


    public static void checkDataTable(DataTable table, String value) {
        List<String> data = table.asList(String.class);
        WebElement requirement = findLinkElementByXpath(searchResults);
        requirement.click();
        List<WebElement> requirementContext = requirement.findElements(By.tagName("a"));

        int i = 0;
        for (WebElement elm : requirementContext) {
            System.out.println(elm.getText());
            Assert.assertEquals(data.get(i), elm.getText());
            i++;
        }
    }
}
