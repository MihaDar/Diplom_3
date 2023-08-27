package site.nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //Текст "Профиль"
    private final By textProfile = By.xpath(".//a[text()='Профиль']");

    //Кнопка «Выход»
    private final By buttonLogOut = By.xpath(".//button[text()='Выход']");

    //Кнопка «Конструктор»
    private final By buttonConstructor = By.xpath(".//p[text()='Конструктор']");

    //Логотип  Stellar Burgers
    private final By logoStellarBurgers = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    //"Видимость текста Профиль"
    public boolean visibilityTextProfile() {
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.visibilityOfElementLocated(textProfile));
        return true;
    }

    //@Step("Кликабельность кнопки Выход")
    public void clickableButtonSignOut() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(buttonLogOut));
    }

    //"Клик по кнопке Выход"
    public void clickButtonLogOut() {
        driver.findElement(buttonLogOut).click();
    }

    //"Клик по кнопке Конструктор"
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    //"Клик по логотипу Stellar Burgers"
    public void clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }
}
