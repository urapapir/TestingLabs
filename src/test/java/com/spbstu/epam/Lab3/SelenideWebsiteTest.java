package com.spbstu.epam.Lab3;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.spbstu.epam.Lab2.TestConfig;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.spbstu.epam.Lab2.url_data.*;
import static com.spbstu.epam.Lab3.SelenidePageObject.diffElPageSelenide;
import static com.spbstu.epam.Lab3.SelenidePageObject.selenideTestingTools;
import static com.spbstu.epam.Lab3.enums.diffElPage_data.*;
import static org.aeonbits.owner.ConfigFactory.create;


public class SelenideWebsiteTest {
    @BeforeSuite
    public void beforeSuite() {
        TestConfig cfg = create(TestConfig.class);
        Configuration.browser = "chrome";
        Configuration.timeout = 6000;
    }

    @BeforeTest
    public void beforeTest() {
        SelenidePageObject.init();
    }

    @AfterClass
    public void afterClass() {
        Selenide.close();
    }

    @Test
    public void Test_case_1() {
        //переход на нужный Url
        selenideTestingTools.open();
//проверка заголока Chrome
        selenideTestingTools.checkBrowserTitle(aTitle);
//логин на сайте
        selenideTestingTools.login(LOGIN, PASSWORD);
        //проверка имени пользователя
        selenideTestingTools.checkUsername();
//проверка количества картинок на странице
        selenideTestingTools.checkPictures();
        //Проверка количество текстов под картинками
        selenideTestingTools.checkTexts();
//проверка заголовка страницы
        selenideTestingTools.checkHomePageTitle(Header);
//проверка текста на странице
        selenideTestingTools.checkHomePageText(HeaderTitles);
//проверка выпадающего списка служб сверху
        selenideTestingTools.checkHeaderServices(Services);
        //проверка выпадающего списка служб слева
        selenideTestingTools.checkLeftServices(Services);
//переход на страницу Different elements
        selenideTestingTools.openDifferentsElemntsPage();
//проверка видимости и существования элементов radio и checkbox на странице
        diffElPageSelenide.checkBoxesAndRadiosOnDiffElPage();
//выбор значений в элементе checkbox
        diffElPageSelenide.checkBoxSelection(checkBox1.Arr);
        diffElPageSelenide.checkBoxSelection(checkBox3.Arr);
//выбор значения элемента radio
        diffElPageSelenide.radiosSelection(radio4.Arr);
//Выбор значения из элемента dropdown
        diffElPageSelenide.dropdownSelection(dropColor4.Arr);
//проверка в логах состояния элементов checkbox, radio и dropdown
        diffElPageSelenide.checkLogForCheckbox(checkBox1.Arr, "true");
        diffElPageSelenide.checkLogForCheckbox(checkBox3.Arr, "true");
        diffElPageSelenide.checkLogsForRadios(radio4.Arr);
        diffElPageSelenide.checkLogsForDropcolor(dropColor4.Arr);
//отмена выбора элементов checkbox
        diffElPageSelenide.checkBoxUnselection(checkBox3.Arr);
        diffElPageSelenide.checkBoxUnselection(checkBox1.Arr);
//повтораная проверка элемента checkbox после отмены в нём выбора значений
        diffElPageSelenide.checkLogForCheckbox(checkBox1.Arr, "false");
        diffElPageSelenide.checkLogForCheckbox(checkBox3.Arr, "false");

    }

    @Test
    public void Test_case_2() {
        /*
        //переход на нужный Url
        selenideTestingTools.open();
//проверка заголока Chrome
        selenideTestingTools.checkBrowserTitle(aTitle);
//логин на сайте
        selenideTestingTools.login(LOGIN,PASSWORD);
        //проверка имени пользователя
        selenideTestingTools.checkUsername();
        */
/*
        selenideTestingTools.openDatesPage();
        datesPage.setSlidersValue(dates_data.values1.values[0], dates_data.values1.values[1] );
        datesPage.setSlidersValue(dates_data.values2.values[0], dates_data.values2.values[1] );
        datesPage.setSlidersValue(dates_data.values3.values[0], dates_data.values3.values[1] );
        datesPage.setSlidersValue(dates_data.values4.values[0], dates_data.values4.values[1] );
        */
    }
}
