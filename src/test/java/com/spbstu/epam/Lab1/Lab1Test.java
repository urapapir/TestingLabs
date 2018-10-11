package com.spbstu.epam.Lab1;

import com.spbstu.epam.Lab2.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class Lab1Test {

    private static final String adress= "https://jdi-framework.github.io/tests/index.htm";
    private static final String aTitle = "Index Page";
    private static final String userName = " PITER CHAILOVSKII";
    //public static final
    private static final List<String> BENEFITS_TEXT = Arrays.asList("To include good practices\nand ideas from successful\nEPAM projec",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");
    private static final String Header = "EPAM FRAMEWORK WISHES…";
    private static final int countImages = 4;
    private static final int countTexts=4;

    private static final String HeaderText = "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT," +
            " SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
            "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT " +
            "DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";

    private ChromeDriver driver;

    /*
     * Создание метода BeforeSuite используещего данные из test.properties
     */
    @BeforeSuite
    public void beforeSuite (){
        TestConfig config = ConfigFactory.create(TestConfig.class);
        System.setProperty("webdriver.chrome.driver", config.pathToDriver());
    }

    /*
     * Создание метода BeforeTest который открывает Chrome, делает его на весь экран и переходит по указанному адресу
     */
    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*
     * Создание метода AfterTest, закрывающего окно браузера
     */
    @AfterTest
    public void  afterTest(){
        driver.close();
    }

    //Создание основного метода тестирования
    @Test
    public void websiteTest(){
        //переход к заданному URL
        driver.navigate().to(adress);
        Assert.assertEquals(driver.getCurrentUrl(), adress);


        //проверка заголовка chrome
        Assert.assertEquals(driver.getTitle(), aTitle);

        //Логинимся на странице
        driver.findElementByCssSelector(".profile-photo").click();
        driver.findElementByCssSelector("#Login").sendKeys("epam");
        driver.findElementByCssSelector("#Password").sendKeys("1234");
        driver.findElementByCssSelector("form .btn-login").click();

        //Проверка соответствия имени пользователя
        Assert.assertTrue(0 == driver.findElementByCssSelector(".profile-photo").
                findElements(By.cssSelector(".hidden")).size(), "User name isn\'t displayed");
        Assert.assertEquals(driver.findElementByCssSelector(".profile-photo").
                getAttribute("innerText"), userName);


        //вторая проверка заголовка chrome
        Assert.assertEquals(driver.getTitle(), aTitle);

        //Проверка количества изображений на странице
        List<WebElement> images = driver.findElementsByCssSelector(".icons-benefit");
        Assert.assertEquals(images.size(), countImages,
                String.format("\"There are %d images, number of required images is (%d)",images.size(), countImages));
        images.forEach(e -> Assert.assertTrue(e.isDisplayed(),
                String.format("\"%s\" image isn't displayed.", e.getAttribute("className"))));

        //Проверка количества подписей под изображениями
        List<WebElement> texts = driver.findElementsByCssSelector(".benefit-txt");
        Assert.assertEquals(texts.size(), countTexts,
                String.format("There are %d texts, number of required texts is (%d)",texts.size(), countTexts));
        texts.forEach(e -> Assert.assertTrue(BENEFITS_TEXT.contains(e.getText()),
                String.format("No such benefit text:\"%s\"", e.getText())));

        //Проверка соответствия заголовка страницы
        Assert.assertEquals(Header, driver.findElement(By.xpath("//h3")).getText());
        Assert.assertEquals(HeaderText, driver.findElement(By.xpath("//p[@class='main-txt text-center']")).getText());
    }
}
