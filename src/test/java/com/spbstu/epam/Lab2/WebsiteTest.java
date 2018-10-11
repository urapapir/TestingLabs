package com.spbstu.epam.Lab2;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.spbstu.epam.Lab2.url_data.*;
public class WebsiteTest {

    private WebDriver driver;
    static final String adress = ConfigFactory.create(TestConfig.class).homePageURL();
    /*
     * Создание метода BeforeSuite используещего данные из test.propertie
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
        PageObject.init(driver);
    }

    /*
     * Создание метода AfterTest, закрывающего окно браузера
     */
    @AfterTest
    public void  afterTest(){
        driver.close();
    }

    //Создание основного метода тестирования, содержащего все спецификации из задания и использующего Page Objects
    @Test
    public void websiteTest(){

        //Переход к заданному URl и проверка самого адреса
        PageObject.testingTools.OpenURL();
        Assert.assertEquals(PageObject.testingTools.currentURL(), adress);

        //chrome title check
        Assert.assertEquals(PageObject.testingTools.getBrowserTitle(), aTitle);

        //Логинимся на странице
        PageObject.testingTools.login(LOGIN,PASSWORD);
        Assert.assertTrue(PageObject.testingTools.isLoggedIn(),
                "Login wasn\'t successful.");

        //Проверка имени пользователя
        Assert.assertTrue(PageObject.testingTools.isUserNameDisplayed(),
                "User name isn\'t displayed");
        Assert.assertEquals(PageObject.testingTools.userName(), userName);


        // chrome title second check
        Assert.assertEquals(PageObject.testingTools.getBrowserTitle(), aTitle);

        //проверка количества изображений на странице
        Assert.assertEquals(PageObject.testingTools.imagesCount(), countImages,
                String.format("There are %d images, number of required images is (%d)", PageObject.testingTools.imagesCount(), countImages));
        Assert.assertTrue(PageObject.testingTools.isImagesDisplayed(), "There are not enough images.");

        //проверка количества подписей под изображениями
        Assert.assertEquals(PageObject.testingTools.textsCount(), countTexts,
                String.format("There are %d texts, number of required texts is (%d)", PageObject.testingTools.textsCount(), countTexts));
        Assert.assertTrue(PageObject.testingTools.checkingTextsCorrection(imageTexts),"There are not enough texts.");

        //Проверка соответствия заголовков
        Assert.assertTrue(PageObject.testingTools.isMainTitleDisplayed(), "Main header text isn\'t displayed.");
        Assert.assertTrue(PageObject.testingTools.isMainTextsDisplayed(), "Header text isn\'t displayed.");
        Assert.assertEquals(PageObject.testingTools.mainTitleText(), Header);
        Assert.assertEquals(PageObject.testingTools.mainTextText(), HeaderTitles);
    }

}
