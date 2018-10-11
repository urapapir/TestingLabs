package com.spbstu.epam.Lab3;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {
    @FindBy(css = ".ui-slider-horizontal")
    private SelenideElement sliderLength;

    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    public DatesPage() {
        Selenide.page(this);
    }

    public int getLength(){
        int length=0;
        return length = sliderLength.getSize().width;
    }
    public int getSliderValue(SelenideElement slider){
        int SliderValue=0;
        return SliderValue = Integer.parseInt(slider.getText());
    }
   /* private void moveSliderTo(SelenideElement slider, int value) {
        Selenide.actions().clickAndHold(slider).build().perform();
        //Selenide.actions().clickAndHold(slider).build().perform();
        while (value > getSliderValue(slider))
            actions().moveByOffset(1, 0).build().perform();

        while (value < Integer.parseInt(slider.getText()))
            actions().moveByOffset(-1, 0).build().perform();

        actions().release().build().perform();
    }

    public void setSlidersValue(int leftSliderValue, int rightSliderValue) {
        if (leftSliderValue > getSliderValue(sliders.get(1))) {
            moveSliderTo(sliders.get(1), rightSliderValue);
            moveSliderTo(sliders.get(0), leftSliderValue);
        }
        if(rightSliderValue >= getSliderValue(sliders.get(0))) {
                moveSliderTo(sliders.get(0), leftSliderValue);
                moveSliderTo(sliders.get(1), rightSliderValue);
        }
        sliders.get(0).shouldHave(text(String.valueOf(leftSliderValue)));
        sliders.get(1).shouldHave(text(String.valueOf(rightSliderValue)));
    }
    */
}
