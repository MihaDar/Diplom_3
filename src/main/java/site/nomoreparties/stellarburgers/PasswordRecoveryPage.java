package site.nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PasswordRecoveryPage {

    private WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    //Текст "Восстановление пароля"
    private final By textPasswordRecovery = By.xpath(".//h2[text()='Восстановление пароля']");

    //Кнопка "Войти" под формой восстановления пароля
    private final By buttonSignIn = By.xpath(".//a[text()='Войти']");

    //"Видимость текста Восстановление пароля"
    public void visibilityTextLogin(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textPasswordRecovery));
    }

    //"Клик по кнопке Войти"
    public void clickButtonSignin() {
        driver.findElement(buttonSignIn).click();
    }
}
