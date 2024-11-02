package org.example;

import org.example.enums.FormInputs;
import org.example.pom.FormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FormTest {

    public static WebDriver driver;

    @BeforeClass
    public void BeforeClass() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void FormFillingTest() {
        driver.get("https://demoqa.com/automation-practice-form");
        FormPage page = new FormPage(driver);

        page.setFirstName(FormInputs.FIRST_NAME.getValue());
        page.setLastName(FormInputs.LAST_NAME.getValue());
        page.setEmail(FormInputs.USER_EMAIL.getValue());
        page.selectMaleGender();
        page.setMobileNumber(FormInputs.PHONE_NUMBER.getValue());
        page.setDateOfBirth(FormInputs.DATE_OF_BIRTH.getValue());
        page.setSubject(FormInputs.SUBJECT_MATH.getValue());
        page.setSubject(FormInputs.SUBJECT_BIOLOGY.getValue());
        page.setHobby(FormInputs.SPORTS_HOBBY_ID.getValue());
        page.setHobby(FormInputs.MUSIC_HOBBY_ID.getValue());
        page.setPicture(FormInputs.FILE_PATH.getValue());
        page.setAddress(FormInputs.ADDRESS.getValue());
        page.setState(FormInputs.STATE.getValue());
        page.setCity(FormInputs.CITY.getValue());
        page.submitForm();
    }

    @AfterClass
    public void CloseDriver() {
        driver.quit();
    }

}
