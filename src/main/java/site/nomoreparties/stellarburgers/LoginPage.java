package site.nomoreparties.stellarburgers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //Текст "Вход"
    private final By textLogin = By.xpath(".//h2[text()='Вход']");

    //Поле email
    private final By fieldEmail = By.xpath(".//label[text() = 'Email']/parent::*/input");

    //Поле пароль
    private final By fieldPassword = By.xpath(".//label[text() = 'Пароль']/parent::*/input");

    //Кнопка "Войти"
    private final By buttonSignIn = By.xpath(".//button[text()='Войти']");

    //Кнопка "Зарегистрироваться"
    private final By buttonRegister = By.className("Auth_link__1fOlj");

    //Кнопка "Восстановить пароль"
    private final By buttonRecoverPassword = By.xpath(".//a[text()='Восстановить пароль']");



    //"Видимость текста Вход"
    public boolean visibilityTextLogin(){
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textLogin));
    return true;
    }

    //"Ввод в поле Email"
    public void inputFieldEmail (String email){
        driver.findElement(fieldEmail).sendKeys(email);
    }

    //"Ввод в поле пароль"
    public void inputFieldPassword (String password){
        driver.findElement(fieldPassword).sendKeys(password);
    }

    //"Клик по кнопке Войти"
    public void clickButtonSignIn() {
        driver.findElement(buttonSignIn).click();
    }

    //"Клик по кнопке Зарегистрироваться"
    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    //"Клик по кнопке Восстановить пароль"
    public void clickButtonRecoverPassword() {
        driver.findElement(buttonRecoverPassword).click();
    }
}
