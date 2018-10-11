package com.spbstu.epam.Lab3;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.spbstu.epam.Lab2.url_data.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.checked;

public class DiffElPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkBoxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

   @FindBy(css = "div.colors select")
   private SelenideElement dropColors;

    @FindBy(css = "#mCSB_1")
    private SelenideElement leftArea;

    @FindBy(css = "#mCSB_2")
    private SelenideElement rightArea;

    @FindBy(css = "ul.panel-body-list.logs")
    private SelenideElement logs;

    @FindBy(css = "[value=\"Default Button\"]")
    private SelenideElement defaultBtn;

    @FindBy(css = "[value=\"Button\"]")
    private SelenideElement btn;

    @FindBy(css = ".dropdown-menu | [href=\"page4.htm\"]")
    private SelenideElement datesPageBtn;


    public DiffElPage() {
        Selenide.page(this);
    }

    public void checkBoxesAndRadiosOnDiffElPage(){
        for (int i = 0; i < countBoxesRatios; i++) {
            checkBoxes.get(i).shouldBe(visible);
            radios.get(i).shouldBe(visible);
        }
        defaultBtn.shouldBe(visible);
        btn.shouldBe(visible);
        leftArea.shouldBe(visible);
        rightArea.shouldBe(visible);
        dropColors.shouldBe(visible);
    }
    public void checkBoxSelection(String checkbox){
        for (int i = 0; i < countBoxesRatios; i++) {
            if (!checkBoxes.get(i).is(checked) && checkBoxes.get(i).getText().contains(checkbox)) {
                checkBoxes.get(i).setSelected(true);
            }
        }
    }

    public void checkBoxUnselection(String checkbox){
        for (int i = 0; i < countBoxesRatios; i++) {
            if (checkBoxes.get(i).is(checked) && checkBoxes.get(i).getText().contains(checkbox)) {
                checkBoxes.get(i).setSelected(false);
            }
        }
    }

    public void radiosSelection(String radio){
        for (int i = 0; i < countBoxesRatios; i++) {
            if (!radios.get(i).is(selected) && radios.get(i).getText().contains(radio)) {
                radios.get(i).setSelected(true);
            }
        }
    }

    public void dropdownSelection(String dropdown) {
     dropColors.selectOption(dropdown);
    }

    public void checkLogForCheckbox(String checkboxName, String checkboxState) {
        logs.shouldHave(text(String.format("%s: condition changed to %s", checkboxName, checkboxState)));
    }

    public void checkLogsForRadios(String radioState) {
        logs.shouldHave(text(String.format("metal: value changed to %s", radioState)));
    }

    public void checkLogsForDropcolor(String colorState) {
        logs.shouldHave(text(String.format("Colors: value changed to %s", colorState)));
    }






}
