package com.vins.docker_book_flight.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstNameField;
    @FindBy(name = "lastName")
    private WebElement lastNameField;
    @FindBy(id = "email")
    private WebElement usernameField;
    @FindBy(name = "password")
    private WebElement passwordField;
    @FindBy(name = "confirmPassword")
    private WebElement confirmPasswordField;
    @FindBy(id = "register-btn")
    private WebElement submitButton;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        driver.get("http://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
    }

    public void enterUserDetails(String firstName, String lastName){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
    }

    public void enterUserCredentials(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(password);
    }

    public void clickSubmit(){
        this.submitButton.click();
    }
}
