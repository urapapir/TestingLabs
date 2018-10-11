package com.spbstu.epam.Lab2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
public class PageObject {

    public static TestingTools testingTools;

    public static void init(WebDriver driver) {
        testingTools = PageFactory.initElements(driver, TestingTools.class);
    }
}
