package com.vins.docker_book_flight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(), 'Flight Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOff;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        PageFactory.initElements(this.driver, this);
    }

    public String getPrice(){
        this.wait.until(ExpectedConditions.visibilityOf(this.flightConfirmationHeader));
        System.out.println(this.flightConfirmationHeader.getText());
        String price = this.prices.get(1).getText();
        System.out.println(price);
        this.signOff.click();
        return price;
    }
}
