package com.spbstu.epam.Lab3;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ElementsCollection;
import org.aeonbits.owner.ConfigFactory;
import com.spbstu.epam.Lab2.TestConfig;
import static com.spbstu.epam.Lab2.url_data.*;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

public class SelenideTestingTools {
    @FindBy(css = ".profile-photo")
    SelenideElement profilePic;

    @FindBy(css = "#Login")
    SelenideElement login;

    @FindBy(css = "#Password")
    SelenideElement password;

    @FindBy(css = "form .btn-login")
    SelenideElement submit;

    @FindBy(css = ".logout")
    SelenideElement logOut;

    @FindBy(css = ".icons-benefit")
    ElementsCollection pictures;

    @FindBy(css = ".benefit-txt")
    ElementsCollection benefitTexts;

    @FindBy(css = ".main-title")
    SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    SelenideElement mainText;

    @FindBy(css = "li.dropdown")
    SelenideElement headerServiceBtn;

    @FindBy(css = "li.sub-menu")
    SelenideElement leftServiceBtn;

    @FindBy(css = ".m-l8 .dropdown-menu")
    SelenideElement headerServiceMenu;

    @FindBy(css = ".sub")
    SelenideElement leftServiceMenu;

    @FindBy(css = ".dropdown-menu | [href=\"page8.htm\"]")
    SelenideElement differentElementPageButton;

    @FindBy(css = "li a[href='page4.htm']")
    SelenideElement datesPageButton;

    public SelenideTestingTools() {
        Selenide.page(this);
    }

    public void open() {
        Selenide.open(ConfigFactory.create(TestConfig.class).homePageURL());
    }

    public void login(String log, String pass){
        profilePic.click();
        login.sendKeys(log);
        password.sendKeys(pass);
        submit.click();
        logOut.shouldBe(visible);
    }

    public void checkBrowserTitle(String title) {
        assert Selenide.title().equals(title);
    }

    public void checkPictures() {
        pictures.shouldHaveSize(countImages);
        for (int i = 0; i < countImages; i++) {
            pictures.get(i).shouldBe(visible);
        }
    }

    public void checkTexts() {
        benefitTexts.shouldHaveSize(countTexts);
        for (int i = 0; i < countTexts; i++) {
            benefitTexts.get(i).shouldBe(visible);
        }
    }

    public void checkUsername() {
        profilePic.shouldHave(text(userName));
        profilePic.shouldBe(visible);
    }

    public void checkHomePageTitle(String mainTitle) {
        this.mainTitle.shouldHave(text(mainTitle));
        this.mainTitle.shouldBe(visible);
    }

    public void checkHomePageText(String mainText) {
        this.mainText.shouldBe(visible);
        this.mainText.shouldHave(text(mainText));
    }

    public void checkHeaderServices(String[] str){
        headerServiceBtn.click();
        headerServiceMenu.shouldBe(visible);
        for (int i = 0; i < countServices; i++) {
            headerServiceMenu.shouldHave(text(str[i]));
        }
    }

    public void checkLeftServices(String[] str){
        leftServiceBtn.click();
        leftServiceMenu.shouldBe(visible);
        for (int i = 0; i < countServices; i++) {
            leftServiceMenu.shouldHave(text(str[i]));
        }
    }
    public void openDifferentsElemntsPage(){
        if (headerServiceMenu.is(hidden))
            headerServiceBtn.click();
        differentElementPageButton.click();
    }
    public void openDatesPage(){
        if (headerServiceMenu.is(hidden))
            headerServiceBtn.click();
        datesPageButton.click();
    }




}
