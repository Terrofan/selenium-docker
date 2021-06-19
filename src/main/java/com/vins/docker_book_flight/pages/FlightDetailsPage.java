package com.vins.docker_book_flight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "passCount")
    private WebElement passengersSelect;

    @FindBy(id = "findFlights")
    private WebElement submitButton;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver, this);
    }

    public void selectPassengers(int numOfPassengers){
        this.wait.until(ExpectedConditions.elementToBeClickable(passengersSelect));
        Select select = new Select(passengersSelect);
        select.selectByValue(Integer.toString(numOfPassengers));
    }

    public void goToFindFlightsPage(){
        submitButton.click();
    }



}
