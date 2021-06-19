package com.vins.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver, this);
    }

    public void goTo(){
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(searchField));
        searchField.sendKeys(keyword);
        searchButton.click();
    }

    public void goToVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(this.videosLink));
        videosLink.click();
    }

    public int printResults(){
        By allVideosLocator = By.className("tile--vid");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(allVideosLocator, 0));
        int numOfVideosFound = this.allVideos.size();
        System.out.println(numOfVideosFound);
        return numOfVideosFound;
    }



}
