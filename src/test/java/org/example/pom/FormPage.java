package org.example.pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FormPage {

    private final WebDriver driver;
    private final JavascriptExecutor javascriptExecutor;

    public FormPage(WebDriver driver) {
        this.driver = driver;
        this.javascriptExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }

    public void setFirstName(String firstName) {
        WebElement field = driver.findElement(By.id("firstName"));
        Type(field, firstName);
    }

    public void setLastName(String lastName) {
        WebElement field = driver.findElement(By.id("lastName"));
        Type(field, lastName);
    }

    public void setEmail(String email) {
        WebElement field = driver.findElement(By.id("userEmail"));
        Type(field, email);
    }

    public void selectMaleGender() {
        WebElement field = driver.findElement(By.xpath("//label[@for='gender-radio-1']"));
        field.click();
    }

    public void setMobileNumber(String mobileNumber) {
        WebElement field = driver.findElement(By.id("userNumber"));
        Type(field, mobileNumber);
    }

    public void setDateOfBirth(String dateOfBirth) {
        WebElement field = driver.findElement(By.id("dateOfBirthInput"));
        field.click();

        javascriptExecutor.executeScript("arguments[0].value = '';", field);

        field.sendKeys(dateOfBirth);
        field.sendKeys(Keys.ENTER);
    }

    public void setSubject(String subject) {
        WebElement field = driver.findElement(By.id("subjectsInput"));

        field.click();

        Type(field, subject);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(".subjects-auto-complete__menu-list")));

        WebElement firstSuggestion = driver.findElement(By.cssSelector(".subjects-auto-complete__option"));
        firstSuggestion.click();
    }

    public void setHobby(String hobbyId) {
        WebElement field = driver.findElement(By.cssSelector("label[for='" + hobbyId + "']"));
        field.click();
    }

    public void setPicture(String filePath) {
        WebElement field = driver.findElement(By.id("uploadPicture"));
        Type(field, filePath);
    }

    public void setAddress(String address) {
        WebElement field = driver.findElement(By.id("currentAddress"));
        Type(field, address);
    }

    public void setState(String state) {
        WebElement field = driver.findElement(By.id("react-select-3-input"));
        TypeAndEnter(field, state);
    }

    public void setCity(String city) {
        WebElement field = driver.findElement(By.id("react-select-4-input"));
        TypeAndEnter(field, city);
    }

    public void submitForm() {
        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();
    }

    private void Type(WebElement field, String text) {
        field.sendKeys(text);
    }

    private void TypeAndEnter(WebElement field, String text) {
        field.sendKeys(text);
        field.sendKeys(Keys.ENTER);
    }
}