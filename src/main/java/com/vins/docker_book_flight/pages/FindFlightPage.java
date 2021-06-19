package com.vins.docker_book_flight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FindFlightPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "reserveFlights")
    private WebElement continueButton;

    @FindBy(id = "buyFlights")
    private WebElement secondContinueButton;

    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver, this);
    }

    public void submitFindFlightPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }

    public void goToFlightConfirmationPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(secondContinueButton));
        secondContinueButton.click();
    }

}
