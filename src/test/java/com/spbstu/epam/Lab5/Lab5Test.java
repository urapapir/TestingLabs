package com.spbstu.epam.Lab5;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.spbstu.epam.Lab5.entities.MetalsAndColorsDataSet;
import com.spbstu.epam.Lab5.util.TestConfig;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.spbstu.epam.Lab5.entities.Names;
import static com.epam.jdi.uitests.core.settings.JDISettings.driverFactory;
import static com.spbstu.epam.Lab5.TestPageSelenide.JDIPageIndex;
import static com.spbstu.epam.Lab5.TestPageSelenide.metColPageJDI;
import static com.spbstu.epam.Lab5.util.Loader.getPageDatas;
import static org.aeonbits.owner.ConfigFactory.create;

public class Lab5Test extends TestNGBase {
/*
    @DataProvider(name = "dataProvider")
    public Object[] createData() {
        return getPageDatas();
    }*/

    @BeforeSuite
    public void beforeSuite() {
        driverFactory.setDriverPath(create(TestConfig.class).driverFolder());
        WebSite.init(TestPageSelenide.class);
        driverFactory.getDriver();
        JDIPageIndex.open();
        metColPageJDI.checkOpened();
        TestPageSelenide.login(Names.PETER);
        TestPageSelenide.openMetalsAndColorsPage();
        metColPageJDI.vegetables.select("Salad");
    }

    @Test(dataProvider = "dataProvider")
    public void Lab5(MetalsAndColorsDataSet metalsAndColorsDataSet) {
        metColPageJDI.metAndColSelection(metalsAndColorsDataSet);
        metColPageJDI.metAndColSelectionCheck(metalsAndColorsDataSet);
    }
}
