package com.spbstu.epam.Lab2;

import com.spbstu.epam.Lab2.TestConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class TestingTools {
    @FindBy(css = ".profile-photo")
    WebElement profilePhoto;
    @FindBy(css = "#Login")
    WebElement loginField;
    @FindBy(css = "#Password")
    WebElement passwordField;
    @FindBy(css = "form .btn-login")
    WebElement submit;
    @FindBy(css = ".logout")
    WebElement logoutBtn;
    @FindBy(css = ".icons-benefit")
    List<WebElement> images;
    @FindBy(css = ".benefit-txt")
    List<WebElement> texts;
    @FindBy(css = ".main-title")
    WebElement mainTitle;
    @FindBy(css = ".main-txt")
    WebElement mainText;

    private final WebDriver driver;

    public TestingTools(WebDriver driver) {
        this.driver = driver;
    }

    public void OpenURL() {
        driver.navigate().to(ConfigFactory.create(TestConfig.class).homePageURL());
        //driver.navigate().to(url_data.adress);
    }

    public String currentURL(){

        return driver.getCurrentUrl();
    }

    public String getBrowserTitle(){
        return driver.getTitle();
    }

    public void login(String login, String password) {
        profilePhoto.click();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submit.click();
    }

    public boolean isLoggedIn(){

        return logoutBtn.isDisplayed();
    }

    public boolean isUserNameDisplayed(){
        return profilePhoto.findElements(By.cssSelector(".hidden")).isEmpty();
    }

    public String userName(){
        return profilePhoto.getAttribute("innerText");
    }

    public int imagesCount(){
        return images.size();
    }

    public boolean isImagesDisplayed(){
        for (WebElement e : images){
            if(!e.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public int textsCount(){
        return texts.size();
    }

    public boolean checkingTextsCorrection(List<String> benefitsText){
        for (WebElement e : texts){
            if(!benefitsText.contains(e.getText())) {
                return false;
            }
        }
        return true;
    }

    public boolean isMainTitleDisplayed(){
        return mainTitle.isDisplayed();
    }

    public boolean isMainTextsDisplayed(){
        return mainText.isDisplayed();
    }

    public String mainTitleText(){
        return mainTitle.getText();
    }

    public String mainTextText(){
        return mainText.getText();
    }


}
