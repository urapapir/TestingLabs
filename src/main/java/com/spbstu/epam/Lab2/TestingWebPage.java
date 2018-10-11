package com.spbstu.epam.Lab2;

//import com.spbstu.epam.pages.TestingTools;
import com.spbstu.epam.Lab2.TestingTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class TestingWebPage {

    public static TestingTools WebPage;

    public static void init(WebDriver driver) {
        WebPage = PageFactory.initElements(driver, TestingTools.class);
    }
}
