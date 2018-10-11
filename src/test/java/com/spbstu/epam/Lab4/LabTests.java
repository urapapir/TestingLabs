package com.spbstu.epam.Lab4;

import com.spbstu.epam.Lab4.Pages.DiffElPage;
import com.spbstu.epam.Lab4.Pages.MyIndexPage;
import com.spbstu.epam.Lab4.allure.Allure;
import com.spbstu.epam.Lab4.enums.IndexData;
import com.spbstu.epam.Lab4.enums.diffElPage_data;
import com.codeborne.selenide.Configuration;
import com.spbstu.epam.Lab5.entities.Names;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Step;

@Listeners(Allure.class)
public class LabTests {
    private static MyIndexPage indexPage;
    private static DiffElPage differentElementsPage;

    @BeforeClass(description = "Set browser and initialize pages")
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x2500";
        Configuration.startMaximized = false;
        indexPage = new MyIndexPage();
        differentElementsPage = new DiffElPage();
    }

    @Test(description = "Test home page and elements UPDATED")
    @Step("Case_1")
    public void Task1() {
        //переход на нужный Url
        indexPage.open(IndexData.URL.strValue);
        //проверка заголовка страницы
        indexPage.checkTitle(IndexData.TITLE.strValue);
        //проверка логина пользователя (Исправил в стиле EntityDriving)
        indexPage.login(Names.PETER);
      // indexPage.checkLogin(IndexData.LOGIN.strValue, IndexData.PASSWORD.strValue, IndexData.USERNAME.strValue);
        //Проверка header'а страницы
        indexPage.checkMainHeader(IndexData.MAIN_HEADER.strValue);
        //Проверка текста на странцие
        indexPage.checkMainText(IndexData.MAIN_TEXT.strValue);
        //проверка наличия нужного количества изображений на странице
        indexPage.checkPictures(IndexData.PICTURE_NUMBER.intValue);
        //проверка наличия нужного количества подписей на странице
        indexPage.checkPictureTexts(IndexData.PICTURE_TEXTS.strArrayValue);

        //проверка верхних выпадающих списков
        indexPage.checkHeadDropdown(IndexData.DROPDOWN_TEXTS.strArrayValue);
        //проверка нижних выпадающих списков
        indexPage.checkLeftDropdown(IndexData.DROPDOWN_TEXTS.strArrayValue);
    }
    @Test
    @Step("Case_2")
    public void Task2() {
        //переход на страицу Different elements
        indexPage.relocateToDifferentElements();
        //првоерка количества чекбоксов
        differentElementsPage.checkElements(diffElPage_data.CHECKBOX_NUMBER.intValue,
                diffElPage_data.CHECKBOX_NUMBER.intValue);
        //выбор значения чекбоксов
        differentElementsPage.selectCheckbox(diffElPage_data.checkbox1.strValue);
        differentElementsPage.selectCheckbox(diffElPage_data.checkbox3.strValue);

        //выбор значения в radio
        differentElementsPage.selectRadio(diffElPage_data.radio4.strValue);
        //выбор значения из выпадающего списка
        differentElementsPage.selectDropdown(diffElPage_data.dropdown4.strValue);

        //проверка логов
        differentElementsPage.checkCheckboxInLog(diffElPage_data.checkbox1.strValue, "true");
        differentElementsPage.checkCheckboxInLog(diffElPage_data.checkbox3.strValue, "true");
        differentElementsPage.checkRadioInLog(diffElPage_data.radio4.strValue);
        differentElementsPage.checkDropdownInLog(diffElPage_data.dropdown4.strValue);

        //release checkboxes
        differentElementsPage.unselectCheckbox(diffElPage_data.checkbox1.strValue);
        differentElementsPage.unselectCheckbox(diffElPage_data.checkbox3.strValue);

        differentElementsPage.checkCheckboxInLog(diffElPage_data.checkbox1.strValue, "false");
        differentElementsPage.checkCheckboxInLog(diffElPage_data.checkbox3.strValue, "false");
    }
}
