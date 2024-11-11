package org.example;

import org.apache.log4j.Logger;
import org.example.enums.FormInputs;
import org.example.pom.FormPage;
import org.example.utils.SeleniumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormTest {

    public static WebDriver driver;

    public static Logger logger = Logger.getLogger(FormTest.class);

    @BeforeClass
    public void BeforeClass() {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver-linux64/chromedriver");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
        driver = SeleniumDriver.getRemoteDriver();
    }

    @Test
    public void FormFillingTest() throws InterruptedException {
        logger.info("Start Test");
        driver.get("https://demoqa.com/automation-practice-form");
        FormPage page = new FormPage(driver);

        page.setFirstName(FormInputs.FIRST_NAME.getValue());
        logger.info("The first name was set");
        Thread.sleep(1000);
        page.setLastName(FormInputs.LAST_NAME.getValue());
        logger.info("The last name was set");
        Thread.sleep(1000);
        page.setEmail(FormInputs.USER_EMAIL.getValue());
        Thread.sleep(1000);
        page.selectMaleGender();
        Thread.sleep(1000);
        page.setMobileNumber(FormInputs.PHONE_NUMBER.getValue());
        Thread.sleep(1000);
        page.setDateOfBirth(FormInputs.DATE_OF_BIRTH.getValue());
        Thread.sleep(1000);
        page.setSubject(FormInputs.SUBJECT_MATH.getValue());
        Thread.sleep(1000);
        page.setSubject(FormInputs.SUBJECT_BIOLOGY.getValue());
        Thread.sleep(1000);
        page.setHobby(FormInputs.SPORTS_HOBBY_ID.getValue());
        Thread.sleep(1000);
        page.setHobby(FormInputs.MUSIC_HOBBY_ID.getValue());
        Thread.sleep(1000);
        page.setPicture(FormInputs.FILE_PATH.getValue());
        Thread.sleep(1000);
        page.setAddress(FormInputs.ADDRESS.getValue());
        Thread.sleep(1000);
        page.setState(FormInputs.STATE.getValue());
        Thread.sleep(1000);
        page.setCity(FormInputs.CITY.getValue());
        Thread.sleep(1000);
        page.submitForm();

        Thread.sleep(5000);

        logger.info("Start Asserts");

        Assert.assertEquals(page.getFirstAndLastName(), FormInputs.FIRST_NAME.getValue() + " " + FormInputs.LAST_NAME.getValue());
        Assert.assertEquals(page.getEmail(), FormInputs.USER_EMAIL.getValue());
        Assert.assertEquals(page.getGender(), FormInputs.GENDER.getValue());
        Assert.assertEquals(page.getMobileNumber(), FormInputs.PHONE_NUMBER.getValue());
        Assert.assertEquals(
                page.getDateOfBirth(),
                LocalDate.parse(FormInputs.DATE_OF_BIRTH.getValue(), DateTimeFormatter.ofPattern("dd MMM yyyy"))
                        .format(DateTimeFormatter.ofPattern("dd MMMM,yyyy"))
        );
        Assert.assertEquals(page.getSubjects(), FormInputs.SUBJECT_MATH.getValue() + ", " + FormInputs.SUBJECT_BIOLOGY.getValue());
        Assert.assertEquals(page.getHobbies(), FormInputs.HOBBIES.getValue());
        Assert.assertEquals(page.getPicture(), Paths.get(FormInputs.FILE_PATH.getValue()).getFileName().toString());
        Assert.assertEquals(page.getAddress(), FormInputs.ADDRESS.getValue());
        Assert.assertEquals(page.getStateAndCity(), FormInputs.STATE.getValue() + " " + FormInputs.CITY.getValue());
        logger.info("End Test");
    }

    @AfterClass
    public void CloseDriver() {
        driver.quit();
    }

}
