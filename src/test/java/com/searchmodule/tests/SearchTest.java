package com.searchmodule.tests;

import com.tests.BaseTest;
import com.vins.searchmodule.pages.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {

    @Test
    @Parameters({"keyword"})
    public void search(String keyword){
        SearchPage searchPage = new SearchPage(this.driver);
        searchPage.goTo();
        searchPage.doSearch("Java");
        searchPage.goToVideos();
        int size = searchPage.printResults();
        Assert.assertTrue(size > 0);
    }
}
