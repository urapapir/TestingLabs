package com.spbstu.epam.Lab5;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;

import com.spbstu.epam.Lab5.entities.User;
import com.spbstu.epam.Lab5.pages.JDIPageIndex;
import com.spbstu.epam.Lab5.pages.MetColPage;
import org.openqa.selenium.support.FindBy;

@JSite("https://jdi-framework.github.io/tests/")
public class TestPageSelenide extends WebSite {
    public static MetColPage metColPageJDI;
    public static JDIPageIndex JDIPageIndex;
    public static PassForm passForm;

    @FindBy(css = ".logout")
    public static Button logout;
    @FindBy(css = ".uui-navigation | [href=\"page2.htm\"]")
    public static Button metalsAndColorsPageButton;
    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    public static void login(User user1) {
        profilePhoto.click();
        passForm.loginAs(user1);
    }
    public static void openMetalsAndColorsPage() {
        metalsAndColorsPageButton.click();
    }

}
