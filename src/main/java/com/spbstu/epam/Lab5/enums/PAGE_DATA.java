package com.spbstu.epam.Lab5.enums;

public enum PAGE_DATA {
    SITE("https://jdi-framework.github.io/tests/index.htm"),
    TITLE("Index Page"),
    LOGIN("epam"),
    PASSWORD("1234"),
    USER_NAME("PITER CHAILOVSKII"),
    ACTUAL_ICONS_NUMBERS(4),
    TEXT(new String[]{"To include good practices\nand ideas from successful\nEPAM projec", "To be flexible and\ncustomizable", "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}),
    MAIN_HEADER("EPAM FRAMEWORK WISHES…"),
    HOME_PAGE("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    SERVICE(new String[]{"Service", "Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements"});

    public String[] strArVal;
    public String str;
    public Integer i;

    PAGE_DATA(String str) {
        this.str = str;
    }

    PAGE_DATA(Integer i) {
        this.i = i;
    }

    PAGE_DATA(String[] strArVal) {
        this.strArVal = strArVal;
    }
}
