package com.spbstu.epam.Lab5.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.*;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JComboBox;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import com.epam.web.matcher.junit.Assert;
import com.spbstu.epam.Lab5.entities.MetalsAndColorsDataSet;
import org.openqa.selenium.support.FindBy;

@JPage(url = "/page2.htm", title = "Metal and Colors")

public class MetColPage extends WebPage {
    @FindBy(css = ".radio")
    public RadioButtons radios;

    @JFindBy(css = "#elements-checklist | .checkbox label")
    public CheckList elements;

    @JDropdown(root = @FindBy(css = ".colors"),
            list = @FindBy(tagName = "li"))
    public Dropdown colors;

    @JComboBox(root = @FindBy(css = ".metals"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"))
    public ComboBox metals;

    @JComboBox(root = @FindBy(css = ".salad"),
            expand = @FindBy(css = ".caret"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button"))
    public ComboBox vegetables;

    @FindBy(css = ".panel-body-list.results li")
    public TextList resultLog;

    public TextList expectedResult;

    @FindBy(css = "#submit-button")
    public Button submit;

    public void elAndVegetableUnselection(MetalsAndColorsDataSet metalsAndColorsDataSet) {
        for (int i = 0; i < metalsAndColorsDataSet.getElements().length; i++)
            elements.select(metalsAndColorsDataSet.getElements()[i]);
        for (int i = 0; i < metalsAndColorsDataSet.getVegetables().length; i++)
            vegetables.select(metalsAndColorsDataSet.getVegetables()[i]);
    }

    public void metAndColSelection(MetalsAndColorsDataSet metalsAndColorsDataSet) {
        radios.select(Integer.toString(metalsAndColorsDataSet.getSummary()[0]));
        radios.select(Integer.toString(metalsAndColorsDataSet.getSummary()[1]));
        for (int i = 0; i < metalsAndColorsDataSet.getElements().length; i++) {
            elements.select(metalsAndColorsDataSet.getElements()[i]);
        }
        metals.select(metalsAndColorsDataSet.getMetals());
        colors.select(metalsAndColorsDataSet.getColor());
        for (int i = 0; i < metalsAndColorsDataSet.getVegetables().length; i++) {
            vegetables.select(metalsAndColorsDataSet.getVegetables()[i]);
        }
        submit.click();
        elAndVegetableUnselection(metalsAndColorsDataSet);
    }

    public void metAndColSelectionCheck(MetalsAndColorsDataSet metalsAndColorsDataSet) {
        int sum = (metalsAndColorsDataSet.getSummary()[0] + metalsAndColorsDataSet.getSummary()[1]);
        Assert.assertTrue(resultLog.getValue().contains(Integer.toString(sum)));
        for (int i = 0; i < metalsAndColorsDataSet.getElements().length; i++)
            Assert.assertTrue(resultLog.getValue().contains(metalsAndColorsDataSet.getElements()[i]));
        Assert.assertTrue(resultLog.getValue().contains(metalsAndColorsDataSet.getColor()));
        Assert.assertTrue(resultLog.getValue().contains(metalsAndColorsDataSet.getMetals()));
        for (int i = 0; i < metalsAndColorsDataSet.getVegetables().length; i++)
            Assert.assertTrue(resultLog.getValue().contains(metalsAndColorsDataSet.getVegetables()[i]));
    }
}
