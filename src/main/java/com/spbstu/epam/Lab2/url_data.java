package com.spbstu.epam.Lab2;

import java.util.List;
import java.util.Arrays;

import com.spbstu.epam.Lab2.TestConfig;
import org.aeonbits.owner.ConfigFactory;
public class url_data {

    static final String adress = ConfigFactory.create(TestConfig.class).homePageURL();
    public static final String aTitle =
            "Index Page";

    public static final String LOGIN =
            "epam";
    public static final String PASSWORD =
            "1234";
    public static final String userName =
            " PITER CHAILOVSKII";

    public static final List<String> imageTexts = Arrays.asList("To include good practices\nand ideas from successful\nEPAM projec",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public static final String Header =
            "EPAM FRAMEWORK WISHES…";
    public static final String HeaderTitles =
            "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                    "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA." +
                    " UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI" +
                    " UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN" +
                    " VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.";
    public static final String[] Services={"Service", "Support", "Dates", "Complex Table", "Simple Table", "Table with pages", "Different elements"};
    public static int countImages =4;
    public static int countTexts = 4;
    public static int countServices = 4;
    public static int countBoxesRatios = 4;
}
