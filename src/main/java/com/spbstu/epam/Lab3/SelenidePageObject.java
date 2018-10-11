package com.spbstu.epam.Lab3;

public class SelenidePageObject {
    static public SelenideTestingTools selenideTestingTools;
    static public DiffElPage diffElPageSelenide;
    static public DatesPage datesPage;

    public static void init() {
        selenideTestingTools = new SelenideTestingTools();
        diffElPageSelenide = new DiffElPage();
        datesPage = new DatesPage();
    }
}
